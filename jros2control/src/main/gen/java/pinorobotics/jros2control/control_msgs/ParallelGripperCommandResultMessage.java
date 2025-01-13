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

import id.jros2messages.sensor_msgs.JointStateMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for control_msgs/ParallelGripperCommandResult */
@MessageMetadata(
        name = ParallelGripperCommandResultMessage.NAME,
        fields = {"state", "stalled", "reached_goal"})
public class ParallelGripperCommandResultMessage implements Message {

    static final String NAME = "control_msgs/ParallelGripperCommandResult";

    /** The current gripper state. */
    public JointStateMessage state = new JointStateMessage();

    /**
     * position of each joint (radians or meters) optional: velocity of each joint (radians or
     * meters / second) optional: effort of each joint (Newtons or Newton-meters) True if the
     * gripper is exerting max effort and not moving
     */
    public boolean stalled;

    /** True if the gripper position has reached the commanded setpoint */
    public boolean reached_goal;

    public ParallelGripperCommandResultMessage withState(JointStateMessage state) {
        this.state = state;
        return this;
    }

    public ParallelGripperCommandResultMessage withStalled(boolean stalled) {
        this.stalled = stalled;
        return this;
    }

    public ParallelGripperCommandResultMessage withReachedGoal(boolean reached_goal) {
        this.reached_goal = reached_goal;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, stalled, reached_goal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ParallelGripperCommandResultMessage other)
            return Objects.equals(state, other.state)
                    && stalled == other.stalled
                    && reached_goal == other.reached_goal;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "state", state,
                "stalled", stalled,
                "reached_goal", reached_goal);
    }
}
