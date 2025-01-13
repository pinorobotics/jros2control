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
import java.util.Arrays;
import java.util.Objects;

/** Definition for control_msgs/InterfaceValue */
@MessageMetadata(
        name = InterfaceValueMessage.NAME,
        fields = {"interface_names", "values"})
public class InterfaceValueMessage implements Message {

    static final String NAME = "control_msgs/InterfaceValue";

    /** List of resource interface names */
    public StringMessage[] interface_names = new StringMessage[0];

    /**
     * Values corresponding to the list of interfaces in `interface_names`, [1.0, 0.0] for example
     */
    public double[] values = new double[0];

    public InterfaceValueMessage withInterfaceNames(StringMessage... interface_names) {
        this.interface_names = interface_names;
        return this;
    }

    public InterfaceValueMessage withValues(double... values) {
        this.values = values;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(interface_names), Arrays.hashCode(values));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof InterfaceValueMessage other)
            return Arrays.equals(interface_names, other.interface_names)
                    && Arrays.equals(values, other.values);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "interface_names", interface_names,
                "values", values);
    }
}
