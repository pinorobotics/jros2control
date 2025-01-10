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
package pinorobotics.jros2control.joint_trajectory_controller;

/**
 * Listener which is registered with {@link JointTrajectoryController}
 *
 * <p>{@link JointStateListener} listens for any joint state updates received from {@link
 * JointTrajectoryController}. It can be used to send all such updates to the robot to move it to a
 * new state.
 *
 * <p>This listener is suppose to be implemented by the user.
 *
 * @author lambdaprime intid@protonmail.com
 */
public interface JointStateListener {

    record JointState(double[] positions, double[] velocities) {
        public JointState(double[] positions) {
            this(positions, new double[positions.length]);
        }
    }

    void update(JointState state);
}
