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
import pinorobotics.jros2actionlib.actionlib_msgs.Action2GetResultRequestMessage;
import pinorobotics.jros2actionlib.actionlib_msgs.Action2GoalIdMessage;

/** Definition for control_msgs/JointTrajectory */
@MessageMetadata(
        name = JointTrajectoryActionGetResultRequestMessage.NAME,
        interfaceType = RosInterfaceType.ACTION)
public class JointTrajectoryActionGetResultRequestMessage
        implements Action2GetResultRequestMessage {

    static final String NAME = "control_msgs/JointTrajectoryActionGetResult";

    public Action2GoalIdMessage goal_id = new Action2GoalIdMessage();

    @Override
    public JointTrajectoryActionGetResultRequestMessage withGoalId(Action2GoalIdMessage goal_id) {
        this.goal_id = goal_id;
        return this;
    }

    @Override
    public Action2GoalIdMessage getGoalId() {
        return goal_id;
    }
}
