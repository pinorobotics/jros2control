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
package pinorobotics.jros2control.control_msgs;

import id.jrosmessages.MessageMetadata;
import id.jrosmessages.RosInterfaceType;
import id.xfunction.XJson;
import java.util.Objects;
import pinorobotics.jros2actionlib.actionlib_msgs.Action2ResultMessage;
import pinorobotics.jros2actionlib.actionlib_msgs.StatusType;

/** Definition for control_msgs/GripperCommand */
@MessageMetadata(
        name = GripperCommandActionResultMessage.NAME,
        fields = {"status", "result"},
        interfaceType = RosInterfaceType.ACTION)
public class GripperCommandActionResultMessage
        implements Action2ResultMessage<GripperCommandResultMessage> {

    static final String NAME = "control_msgs/GripperCommandActionResult";

    public byte status;

    public GripperCommandResultMessage result = new GripperCommandResultMessage();

    public GripperCommandActionResultMessage withStatus(byte status) {
        this.status = status;
        return this;
    }

    @Override
    public GripperCommandActionResultMessage withResult(GripperCommandResultMessage result) {
        this.result = result;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, result);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GripperCommandActionResultMessage other)
            return Objects.equals(status, other.status) && Objects.equals(result, other.result);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "status", status,
                "result", result);
    }

    @Override
    public StatusType getStatus() {
        return StatusType.values()[status];
    }

    @Override
    public GripperCommandResultMessage getResult() {
        return result;
    }

    @Override
    public Action2ResultMessage<GripperCommandResultMessage> withStatus(StatusType status) {
        this.status = (byte) status.ordinal();
        return null;
    }
}
