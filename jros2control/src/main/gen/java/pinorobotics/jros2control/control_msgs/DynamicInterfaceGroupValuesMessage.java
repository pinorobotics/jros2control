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

/** Definition for control_msgs/DynamicInterfaceGroupValues */
@MessageMetadata(
        name = DynamicInterfaceGroupValuesMessage.NAME,
        fields = {"header", "interface_groups", "interface_values"})
public class DynamicInterfaceGroupValuesMessage implements Message {

    static final String NAME = "control_msgs/DynamicInterfaceGroupValues";

    public HeaderMessage header = new HeaderMessage();

    /** List of interface group names , e.g. ["flange_analog_IOs", "flange_vacuum"] */
    public StringMessage[] interface_groups = new StringMessage[0];

    /**
     * Key-value pairs representing interfaces and their corresponding values for each interface
     * group listed in `interface_groups`
     */
    public InterfaceValueMessage[] interface_values = new InterfaceValueMessage[0];

    public DynamicInterfaceGroupValuesMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public DynamicInterfaceGroupValuesMessage withInterfaceGroups(
            StringMessage... interface_groups) {
        this.interface_groups = interface_groups;
        return this;
    }

    public DynamicInterfaceGroupValuesMessage withInterfaceValues(
            InterfaceValueMessage... interface_values) {
        this.interface_values = interface_values;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header, Arrays.hashCode(interface_groups), Arrays.hashCode(interface_values));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DynamicInterfaceGroupValuesMessage other)
            return Objects.equals(header, other.header)
                    && Arrays.equals(interface_groups, other.interface_groups)
                    && Arrays.equals(interface_values, other.interface_values);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "interface_groups", interface_groups,
                "interface_values", interface_values);
    }
}
