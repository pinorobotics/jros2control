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

import id.jros2client.JRos2Client;
import id.jroscommon.RosName;
import id.xfunction.logging.XLogger;
import id.xfunction.util.IdempotentService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import pinorobotics.jros2actionlib.ActionHandler;
import pinorobotics.jros2actionlib.JRos2ActionFactory;
import pinorobotics.jros2actionlib.JRos2ActionServer;
import pinorobotics.jros2control.control_msgs.FollowJointTrajectoryActionDefinition;
import pinorobotics.jros2control.control_msgs.FollowJointTrajectoryGoalMessage;
import pinorobotics.jros2control.control_msgs.FollowJointTrajectoryResultMessage;
import pinorobotics.jros2control.control_msgs.FollowJointTrajectoryResultMessage.ErrorType;
import pinorobotics.jros2control.joint_trajectory_controller.ActuatorHardware;

/**
 * @author lambdaprime intid@protonmail.com
 */
public class FollowJointTrajectoryActionServer extends IdempotentService
        implements ActionHandler<
                FollowJointTrajectoryGoalMessage, FollowJointTrajectoryResultMessage> {
    private static final XLogger LOGGER =
            XLogger.getLogger(FollowJointTrajectoryActionServer.class);
    private JRos2ActionFactory actionlibFactory = new JRos2ActionFactory();
    private JRos2Client client;
    private RosName controllerName;
    private JRos2ActionServer<FollowJointTrajectoryGoalMessage, FollowJointTrajectoryResultMessage>
            actionServer;
    private JointTrajectoryProcessor trajectoryProcessor;

    public FollowJointTrajectoryActionServer(
            JRos2Client client,
            List<String> joints,
            List<ActuatorHardware> actuatorHardwareList,
            RosName controllerName) {
        this.client = client;
        this.controllerName = controllerName;
        this.trajectoryProcessor = new JointTrajectoryProcessor(joints, actuatorHardwareList);
    }

    @Override
    protected void onStart() {
        LOGGER.fine("Start forward joint trajectory controller {0}", controllerName);
        actionServer =
                actionlibFactory.createActionServer(
                        client,
                        new FollowJointTrajectoryActionDefinition(),
                        controllerName.add("follow_joint_trajectory"),
                        this);
        actionServer.start();
    }

    @Override
    protected void onClose() {
        LOGGER.fine("Stop forward joint trajectory controller {0}", controllerName);
        actionServer.close();
    }

    @Override
    public CompletableFuture<FollowJointTrajectoryResultMessage> execute(
            FollowJointTrajectoryGoalMessage goal) throws Exception {
        LOGGER.fine("Process new goal trajectory");
        trajectoryProcessor.process(goal.trajectory);
        return CompletableFuture.completedFuture(
                new FollowJointTrajectoryResultMessage().withErrorCode(ErrorType.SUCCESSFUL));
    }
}
