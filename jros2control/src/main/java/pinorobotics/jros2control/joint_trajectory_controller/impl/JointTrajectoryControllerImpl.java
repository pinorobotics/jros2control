/*
 * Copyright 2025 jroscontrol project
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
import id.xfunction.Preconditions;
import id.xfunction.util.IdempotentService;
import java.util.List;
import pinorobotics.jros2control.joint_trajectory_controller.ActuatorHardware;
import pinorobotics.jros2control.joint_trajectory_controller.JointTrajectoryController;

public class JointTrajectoryControllerImpl extends IdempotentService
        implements JointTrajectoryController {

    private JointTrajectorySubscriber subscriber;

    public JointTrajectoryControllerImpl(
            JRos2Client client,
            List<ActuatorHardware> actuatorHardwareList,
            List<String> joints,
            List<Double> initialPositions,
            RosName controllerName) {
        Preconditions.equals(
                joints.size(),
                initialPositions.size(),
                "mismatch between joints and number of initial positions");
        this.subscriber =
                new JointTrajectorySubscriber(
                        client, joints, actuatorHardwareList, initialPositions, controllerName);
    }

    @Override
    protected void onStart() {
        subscriber.start();
    }

    @Override
    protected void onClose() {
        subscriber.close();
    }
}
