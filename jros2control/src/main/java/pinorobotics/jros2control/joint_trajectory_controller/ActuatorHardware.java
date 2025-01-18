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

import id.xfunction.XJson;
import java.util.List;

/**
 * Listener which is registered with {@link JointTrajectorySubscriber}
 *
 * <p>{@link ActuatorHardware} listens for any joint state updates received from {@link
 * JointTrajectorySubscriber}. It can be used to send all such updates to the robot to move it to a
 * new state.
 *
 * <p>This listener is suppose to be implemented by the user. Its goal is a bit similar to <a
 * href="https://control.ros.org/jazzy/doc/ros2_control/hardware_interface/doc/writing_new_hardware_component.html">Hardware
 * Component in ROS2<a/> (or <a href="https://wiki.ros.org/ros_control#Hardware_Interfaces">Hardware
 * Interface in ROS1</a>) in a sense that it acts as an abstraction between <b>jros2control</b> and
 * the physical hardware.
 *
 * @author lambdaprime intid@protonmail.com
 */
@FunctionalInterface
public interface ActuatorHardware {

    public record JointState(List<String> joints, double[] positions, double[] velocities) {
        public JointState(List<String> joints, double[] positions) {
            this(joints, positions, new double[positions.length]);
        }

        /**
         * @return where positions[i] is position of i-th joint inside {@link #joints}
         */
        public double[] positions() {
            return positions;
        }

        @Override
        public String toString() {
            return XJson.asString(
                    "joints", joints,
                    "positions", positions,
                    "velocities", velocities);
        }
    }

    void update(JointState state);
}
