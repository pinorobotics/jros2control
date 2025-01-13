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
 * Definition for control_msgs/JointComponentTolerance
 *
 * <p>Version of JointTolerance.msg with added component field for joints with multiple degrees of
 * freedom The difference between two MultiDOFJointTrajectoryPoint cannot be represented as a single
 * number, hence we use the component field to represent how to calculate the difference in a way
 * that can be represented as a single number. Version of JointTolerance.msg with added component
 * field for joints with multiple degrees of freedom The difference between two
 * MultiDOFJointTrajectoryPoint cannot be represented as a single number, hence we use the component
 * field to represent how to calculate the difference in a way that can be represented as a single
 * number.
 *
 * <p>Since each joint has multiple degrees of freedom, there can be multiple tolerances for each
 * joint, each looking at different components.
 *
 * <p>If the component is X_AXIS, Y_AXIS, or Z_AXIS, then the tolerance is only applied for the
 * specific axis. However, if the component is TRANSLATION, then the tolerance is for the overall
 * Euclidean distance. For these components, the units are meters, meters/sec and meters/sec^2.
 * Z_AXIS is only valid with a floating joint, not planar.
 *
 * <p>If the component is ROTATION the tolerance is measured in radians, radians/sec and
 * radians/sec^2, computed between the difference in quaternions.
 */
@MessageMetadata(
        name = JointComponentToleranceMessage.NAME,
        fields = {"joint_name", "component", "position", "velocity", "acceleration"})
public class JointComponentToleranceMessage implements Message {

    static final String NAME = "control_msgs/JointComponentTolerance";

    public static final short X_AXIS = 1;

    public static final short Y_AXIS = 2;

    public static final short Z_AXIS = 3;

    public static final short TRANSLATION = 4;

    public static final short ROTATION = 5;

    public StringMessage joint_name = new StringMessage();

    public short component;

    public double position;

    public double velocity;

    public double acceleration;

    public JointComponentToleranceMessage withJointName(StringMessage joint_name) {
        this.joint_name = joint_name;
        return this;
    }

    public JointComponentToleranceMessage withComponent(short component) {
        this.component = component;
        return this;
    }

    public JointComponentToleranceMessage withPosition(double position) {
        this.position = position;
        return this;
    }

    public JointComponentToleranceMessage withVelocity(double velocity) {
        this.velocity = velocity;
        return this;
    }

    public JointComponentToleranceMessage withAcceleration(double acceleration) {
        this.acceleration = acceleration;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(joint_name, component, position, velocity, acceleration);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JointComponentToleranceMessage other)
            return Objects.equals(joint_name, other.joint_name)
                    && component == other.component
                    && position == other.position
                    && velocity == other.velocity
                    && acceleration == other.acceleration;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "joint_name", joint_name,
                "component", component,
                "position", position,
                "velocity", velocity,
                "acceleration", acceleration);
    }
}
