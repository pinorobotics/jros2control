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
package pinorobotics.jros2control.joint_trajectory_controller;

/**
 * <b>jros2control</b> version of joint_trajectory_controller
 *
 * @see JointTrajectoryControllerFactory Different implementations of {@link
 *     JointTrajectoryController}
 * @author lambdaprime intid@protonmail.com
 */
public interface JointTrajectoryController extends AutoCloseable {

    void start();

    @Override
    void close();
}
