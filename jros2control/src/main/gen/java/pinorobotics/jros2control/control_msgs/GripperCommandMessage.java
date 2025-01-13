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
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for control_msgs/GripperCommand */
@MessageMetadata(
        name = GripperCommandMessage.NAME,
        fields = {"position", "max_effort"})
public class GripperCommandMessage implements Message {

    static final String NAME = "control_msgs/GripperCommand";

    public double position;

    public double max_effort;

    public GripperCommandMessage withPosition(double position) {
        this.position = position;
        return this;
    }

    public GripperCommandMessage withMaxEffort(double max_effort) {
        this.max_effort = max_effort;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, max_effort);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GripperCommandMessage other)
            return position == other.position && max_effort == other.max_effort;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "position", position,
                "max_effort", max_effort);
    }
}
