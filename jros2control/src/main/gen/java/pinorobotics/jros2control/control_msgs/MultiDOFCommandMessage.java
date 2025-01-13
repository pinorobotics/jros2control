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

/**
 * Definition for control_msgs/MultiDOFCommand
 *
 * <p>The message defines command for multiple degrees of freedom (DoF) typically used by many
 * controllers. The message intentionally avoids 'joint' nomenclature because it can be generally
 * use for command with different semantic meanings, e.g., joints, Cartesian axes, or have abstract
 * meaning like GPIO interface.
 */
@MessageMetadata(
        name = MultiDOFCommandMessage.NAME,
        fields = {"dof_names", "values", "values_dot"})
public class MultiDOFCommandMessage implements Message {

    static final String NAME = "control_msgs/MultiDOFCommand";

    /** names of degrees of freedom */
    public StringMessage[] dof_names = new StringMessage[0];

    /** values used by most of the controller */
    public double[] values = new double[0];

    /**
     * First derivation of the values, e.g., velocity if values are positions. This is useful for
     * PID and similar controllers.
     */
    public double[] values_dot = new double[0];

    public MultiDOFCommandMessage withDofNames(StringMessage... dof_names) {
        this.dof_names = dof_names;
        return this;
    }

    public MultiDOFCommandMessage withValues(double... values) {
        this.values = values;
        return this;
    }

    public MultiDOFCommandMessage withValuesDot(double... values_dot) {
        this.values_dot = values_dot;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Arrays.hashCode(dof_names), Arrays.hashCode(values), Arrays.hashCode(values_dot));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MultiDOFCommandMessage other)
            return Arrays.equals(dof_names, other.dof_names)
                    && Arrays.equals(values, other.values)
                    && Arrays.equals(values_dot, other.values_dot);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "dof_names", dof_names,
                "values", values,
                "values_dot", values_dot);
    }
}
