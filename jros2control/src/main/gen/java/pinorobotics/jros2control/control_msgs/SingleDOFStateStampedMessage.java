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
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for control_msgs/SingleDOFStateStamped
 *
 * <p>This message presents current controller state of one degree of freedom. This message presents
 * current controller state of one degree of freedom.
 *
 * <p>Header timestamp should be update time of controller state
 */
@MessageMetadata(
        name = SingleDOFStateStampedMessage.NAME,
        fields = {"header", "dof_state"})
public class SingleDOFStateStampedMessage implements Message {

    static final String NAME = "control_msgs/SingleDOFStateStamped";

    public HeaderMessage header = new HeaderMessage();

    public SingleDOFStateMessage dof_state = new SingleDOFStateMessage();

    public SingleDOFStateStampedMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public SingleDOFStateStampedMessage withDofState(SingleDOFStateMessage dof_state) {
        this.dof_state = dof_state;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, dof_state);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SingleDOFStateStampedMessage other)
            return Objects.equals(header, other.header)
                    && Objects.equals(dof_state, other.dof_state);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "dof_state", dof_state);
    }
}
