/*
 * Copyright 2021 jroscontrol project
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
package pinorobotics.jros2control.control_msgs;

import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for control_msgs/JointTolerance
 *
 * <p>The tolerances specify the amount the position, velocity, and accelerations can vary from the
 * setpoints. For example, in the case of trajectory control, when the actual position varies beyond
 * (desired position + position tolerance), the trajectory goal may abort.
 *
 * <p>There are two special values for tolerances: * 0 - The tolerance is unspecified and will
 * remain at whatever the default is * -1 - The tolerance is "erased". If there was a default, the
 * joint will be allowed to move without restriction. The tolerances specify the amount the
 * position, velocity, and accelerations can vary from the setpoints. For example, in the case of
 * trajectory control, when the actual position varies beyond (desired position + position
 * tolerance), the trajectory goal may abort.
 *
 * <p>There are two special values for tolerances: * 0 - The tolerance is unspecified and will
 * remain at whatever the default is * -1 - The tolerance is "erased". If there was a default, the
 * joint will be allowed to move without restriction.
 */
@MessageMetadata(
        name = JointToleranceMessage.NAME,
        fields = {"name", "position", "velocity", "acceleration"})
public class JointToleranceMessage implements Message {

    static final String NAME = "control_msgs/JointTolerance";

    public StringMessage name = new StringMessage();

    /** in radians or meters (for a revolute or prismatic joint, respectively) */
    public double position;

    /** in rad/sec or m/sec */
    public double velocity;

    /** in rad/sec^2 or m/sec^2 */
    public double acceleration;

    public JointToleranceMessage withName(StringMessage name) {
        this.name = name;
        return this;
    }

    public JointToleranceMessage withPosition(double position) {
        this.position = position;
        return this;
    }

    public JointToleranceMessage withVelocity(double velocity) {
        this.velocity = velocity;
        return this;
    }

    public JointToleranceMessage withAcceleration(double acceleration) {
        this.acceleration = acceleration;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, velocity, acceleration);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JointToleranceMessage other)
            return Objects.equals(name, other.name)
                    && position == other.position
                    && velocity == other.velocity
                    && acceleration == other.acceleration;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "name", name,
                "position", position,
                "velocity", velocity,
                "acceleration", acceleration);
    }
}
