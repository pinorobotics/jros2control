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

import id.jros2messages.trajectory_msgs.JointTrajectoryMessage;
import id.xfunction.logging.XLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pinorobotics.jros2control.joint_trajectory_controller.ActuatorHardware;
import pinorobotics.jros2control.joint_trajectory_controller.ActuatorHardware.JointState;

/**
 * @author lambdaprime intid@protonmail.com
 */
public class JointTrajectoryProcessor {
    private static final XLogger LOGGER = XLogger.getLogger(JointTrajectoryProcessor.class);
    private final List<ActuatorHardware> actuatorHardwareList;
    private final Map<String, Integer> jointsMap;
    private final List<String> joints;
    private double[] cachedPositions;

    public JointTrajectoryProcessor(
            List<String> joints, List<ActuatorHardware> actuatorHardwareList) {
        this.joints = joints;
        this.actuatorHardwareList = actuatorHardwareList;
        this.jointsMap =
                IntStream.range(0, joints.size())
                        .boxed()
                        .collect(Collectors.toMap(i -> joints.get(i), i -> i));
        this.cachedPositions = new double[joints.size()];
    }

    public void process(JointTrajectoryMessage trajectory) {
        for (var p : trajectory.points) {
            for (int i = 0; i < p.positions.length; i++) {
                if (!Double.isFinite(p.positions[i])) continue;
                var jointName = trajectory.joint_names[i].data;
                var jointId = jointsMap.get(jointName);
                if (jointId == null) {
                    LOGGER.warning("Unknown joint with name {0}, ignoring...", jointName);
                    continue;
                }
                cachedPositions[jointId] = p.positions[i];
            }
            updatePositions(cachedPositions);
        }
        if (LOGGER.isLoggable(Level.FINE))
            LOGGER.fine("Final position: {0}", Arrays.toString(cachedPositions));
    }

    private void updatePositions(double[] positions) {
        actuatorHardwareList.forEach(
                listener -> {
                    try {
                        listener.update(new JointState(joints, positions, new double[0]));
                    } catch (Exception e) {
                        LOGGER.severe("Actuator update error", e);
                    }
                });
    }
}
