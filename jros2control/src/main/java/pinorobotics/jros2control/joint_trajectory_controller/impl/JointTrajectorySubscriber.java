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
import id.xfunction.logging.XLogger;
import id.xfunction.util.IdempotentService;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Flow.Subscription;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pinorobotics.jros2control.joint_trajectory_controller.ActuatorHardware;
import pinorobotics.jros2control.joint_trajectory_controller.ActuatorHardware.JointState;

/**
 * @author lambdaprime intid@protonmail.com
 */
public class JointTrajectorySubscriber extends IdempotentService {
    private static final XLogger LOGGER = XLogger.getLogger(JointTrajectorySubscriber.class);
    private Optional<TopicSubscriber<JointTrajectoryMessage>> subscriber = Optional.empty();
    private List<String> joints;
    private List<Double> initialPositions;
    private JRosClient client;
    private List<ActuatorHardware> actuatorHardwareList;
    private Map<String, Integer> jointsMap;
    private RosName controllerName;

    public JointTrajectorySubscriber(
            JRosClient client,
            List<String> joints,
            List<ActuatorHardware> actuatorHardwareList,
            List<Double> initialPositions,
            RosName controllerName) {
        this.client = client;
        this.actuatorHardwareList = actuatorHardwareList;
        this.joints = joints;
        this.initialPositions = initialPositions;
        this.controllerName = controllerName;
        this.jointsMap =
                IntStream.range(0, joints.size())
                        .boxed()
                        .collect(Collectors.toMap(i -> joints.get(i), i -> i));
    }

    @Override
    protected void onStart() {
        var positions = initialPositions.stream().mapToDouble(j -> j).toArray();
        updatePositions(positions);
        var subscriber =
                new TopicSubscriber<>(
                        new MessageDescriptor<>(JointTrajectoryMessage.class), controllerName) {
                    @Override
                    public void onNext(JointTrajectoryMessage item) {
                        super.onNext(item);
                        LOGGER.info("Received new trajectory {0}", item);
                        for (var p : item.points) {
                            for (int i = 0; i < p.positions.length; i++) {
                                if (!Double.isFinite(p.positions[i])) continue;
                                positions[jointsMap.get(item.joint_names[i].data)] = p.positions[i];
                            }
                        }
                        updatePositions(positions);
                        // request next message
                        getSubscription().get().request(1);
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

    private void updatePositions(double[] positions) {
        actuatorHardwareList.forEach(
                listener -> {
                    try {
                        listener.update(new JointState(joints, positions, new double[0]));
                    } catch (Exception e) {
                        LOGGER.severe(e);
                    }
                });
    }
}
