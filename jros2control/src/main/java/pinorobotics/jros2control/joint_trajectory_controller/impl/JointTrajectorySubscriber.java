/*
 * Copyright 2024 jroscontrol project
 * 
 * Website: https://github.com/pinorobotics/jros2control
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pinorobotics.jros2control.joint_trajectory_controller.impl;

import id.jros2messages.trajectory_msgs.JointTrajectoryMessage;
import id.jrosclient.JRosClient;
import id.jrosclient.TopicSubscriber;
import id.jroscommon.RosName;
import id.jrosmessages.MessageDescriptor;
import id.jrosmessages.std_msgs.StringMessage;
import id.jrosmessages.trajectory_msgs.JointTrajectoryPointMessage;
import id.xfunction.logging.XLogger;
import id.xfunction.util.IdempotentService;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Subscription;
import pinorobotics.jros2control.joint_trajectory_controller.ActuatorHardware;

/**
 * @author lambdaprime intid@protonmail.com
 */
public class JointTrajectorySubscriber extends IdempotentService {
    private static final XLogger LOGGER = XLogger.getLogger(JointTrajectorySubscriber.class);
    private Optional<TopicSubscriber<JointTrajectoryMessage>> subscriber = Optional.empty();
    private JRosClient client;
    private List<Double> initialPositions;
    private RosName controllerName;
    private JointTrajectoryProcessor trajectoryProcessor;
    private List<String> joints;

    public JointTrajectorySubscriber(
            JRosClient client,
            List<String> joints,
            List<ActuatorHardware> actuatorHardwareList,
            List<Double> initialPositions,
            RosName controllerName) {
        this.client = client;
        this.joints = joints;
        this.initialPositions = initialPositions;
        this.controllerName = controllerName;
        this.trajectoryProcessor = new JointTrajectoryProcessor(joints, actuatorHardwareList);
    }

    @Override
    protected void onStart() {
        LOGGER.fine("Start joint trajectory controller {0}", controllerName);
        var positions = initialPositions.stream().mapToDouble(j -> j).toArray();
        trajectoryProcessor.process(
                new JointTrajectoryMessage()
                        .withPoints(new JointTrajectoryPointMessage().withPositions(positions))
                        .withJointNames(
                                joints.stream()
                                        .map(StringMessage::new)
                                        .toArray(i -> new StringMessage[i])));
        var subscriber =
                new TopicSubscriber<>(
                        new MessageDescriptor<>(JointTrajectoryMessage.class),
                        controllerName.add("joint_trajectory")) {
                    @Override
                    public void onNext(JointTrajectoryMessage item) {
                        super.onNext(item);
                        LOGGER.fine("Received new trajectory {0}", item);
                        try {
                            trajectoryProcessor.process(item);
                        } finally {
                            // request next message
                            getSubscription().get().request(1);
                        }
                    }
                };
        // register a new subscriber with default QOS policies
        // users can redefine QOS policies using overloaded version of subscribe() method
        client.subscribe(subscriber);
        this.subscriber = Optional.of(subscriber);
    }

    @Override
    protected void onClose() {
        LOGGER.fine("Stop joint trajectory controller {0}", controllerName);
        subscriber.flatMap(TopicSubscriber::getSubscription).ifPresent(Subscription::cancel);
    }
}
