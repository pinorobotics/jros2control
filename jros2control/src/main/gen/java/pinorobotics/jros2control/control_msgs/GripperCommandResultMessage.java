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

/** Definition for control_msgs/GripperCommandResult */
@MessageMetadata(
        name = GripperCommandResultMessage.NAME,
        fields = {"position", "effort", "stalled", "reached_goal"})
public class GripperCommandResultMessage implements Message {

    static final String NAME = "control_msgs/GripperCommandResult";

    /** The current gripper gap size (in meters) */
    public double position;

    /** The current effort exerted (in Newtons) */
    public double effort;

    /** True iff the gripper is exerting max effort and not moving */
    public boolean stalled;

    /** True iff the gripper position has reached the commanded setpoint */
    public boolean reached_goal;

    public GripperCommandResultMessage withPosition(double position) {
        this.position = position;
        return this;
    }

    public GripperCommandResultMessage withEffort(double effort) {
        this.effort = effort;
        return this;
    }

    public GripperCommandResultMessage withStalled(boolean stalled) {
        this.stalled = stalled;
        return this;
    }

    public GripperCommandResultMessage withReachedGoal(boolean reached_goal) {
        this.reached_goal = reached_goal;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, effort, stalled, reached_goal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GripperCommandResultMessage other)
            return position == other.position
                    && effort == other.effort
                    && stalled == other.stalled
                    && reached_goal == other.reached_goal;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "position", position,
                "effort", effort,
                "stalled", stalled,
                "reached_goal", reached_goal);
    }
}
