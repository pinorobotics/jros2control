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

/** Definition for control_msgs/GripperCommandGoal */
@MessageMetadata(name = GripperCommandGoalMessage.NAME)
public class GripperCommandGoalMessage implements Message {

    static final String NAME = "control_msgs/GripperCommandGoal";

    public GripperCommandMessage command = new GripperCommandMessage();

    public GripperCommandGoalMessage withCommand(GripperCommandMessage command) {
        this.command = command;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(command);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GripperCommandGoalMessage other)
            return Objects.equals(command, other.command);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString("command", command);
    }
}
