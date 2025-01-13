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

import id.jros2messages.std_msgs.HeaderMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for control_msgs/DynamicJointState */
@MessageMetadata(
        name = DynamicJointStateMessage.NAME,
        fields = {"header", "joint_names", "interface_values"})
public class DynamicJointStateMessage implements Message {

    static final String NAME = "control_msgs/DynamicJointState";

    public HeaderMessage header = new HeaderMessage();

    /** List of resource names, e.g. ["arm_joint_1", "arm_joint_2", "gripper_joint"] */
    public StringMessage[] joint_names = new StringMessage[0];

    /**
     * Key-value pairs representing interfaces and their corresponding values for each joint listed
     * in `joint_names`
     */
    public InterfaceValueMessage[] interface_values = new InterfaceValueMessage[0];

    public DynamicJointStateMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public DynamicJointStateMessage withJointNames(StringMessage... joint_names) {
        this.joint_names = joint_names;
        return this;
    }

    public DynamicJointStateMessage withInterfaceValues(InterfaceValueMessage... interface_values) {
        this.interface_values = interface_values;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header, Arrays.hashCode(joint_names), Arrays.hashCode(interface_values));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DynamicJointStateMessage other)
            return Objects.equals(header, other.header)
                    && Arrays.equals(joint_names, other.joint_names)
                    && Arrays.equals(interface_values, other.interface_values);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "joint_names", joint_names,
                "interface_values", interface_values);
    }
}
