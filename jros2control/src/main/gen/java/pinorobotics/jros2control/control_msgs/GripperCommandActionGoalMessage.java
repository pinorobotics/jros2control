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
import pinorobotics.jros2actionlib.actionlib_msgs.Action2GoalIdMessage;
import pinorobotics.jros2actionlib.actionlib_msgs.Action2GoalMessage;

/** Definition for control_msgs/GripperCommand */
@MessageMetadata(
        name = GripperCommandActionGoalMessage.NAME,
        fields = {"goal_id", "goal"},
        interfaceType = RosInterfaceType.ACTION)
public class GripperCommandActionGoalMessage
        implements Action2GoalMessage<GripperCommandGoalMessage> {

    static final String NAME = "control_msgs/GripperCommandActionGoal";

    public Action2GoalIdMessage goal_id = new Action2GoalIdMessage();

    public GripperCommandGoalMessage goal = new GripperCommandGoalMessage();

    @Override
    public GripperCommandActionGoalMessage withGoalId(Action2GoalIdMessage goal_id) {
        this.goal_id = goal_id;
        return this;
    }

    @Override
    public GripperCommandActionGoalMessage withGoal(GripperCommandGoalMessage goal) {
        this.goal = goal;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goal_id, goal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GripperCommandActionGoalMessage other)
            return Objects.equals(goal_id, other.goal_id) && Objects.equals(goal, other.goal);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "goal_id", goal_id,
                "goal", goal);
    }

    @Override
    public GripperCommandGoalMessage getGoal() {
        return goal;
    }

    @Override
    public Action2GoalIdMessage getGoalId() {
        return goal_id;
    }
}
