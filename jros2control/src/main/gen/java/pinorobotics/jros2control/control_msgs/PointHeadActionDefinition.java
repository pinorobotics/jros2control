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

import id.jrosmessages.MessageDescriptor;
import pinorobotics.jros2actionlib.actionlib_msgs.Action2Definition;
import pinorobotics.jros2actionlib.actionlib_msgs.Action2GetResultRequestMessage;
import pinorobotics.jros2actionlib.actionlib_msgs.Action2GoalMessage;
import pinorobotics.jros2actionlib.actionlib_msgs.Action2ResultMessage;

/** Definition for control_msgs/action/PointHead */
public class PointHeadActionDefinition
        implements Action2Definition<PointHeadGoalMessage, PointHeadResultMessage> {

    @Override
    public MessageDescriptor<? extends Action2GoalMessage<PointHeadGoalMessage>>
            getActionGoalMessage() {
        return new MessageDescriptor<>(PointHeadActionGoalMessage.class);
    }

    @Override
    public MessageDescriptor<? extends Action2ResultMessage<PointHeadResultMessage>>
            getActionResultMessage() {
        return new MessageDescriptor<>(PointHeadActionResultMessage.class);
    }

    @Override
    public MessageDescriptor<? extends Action2GetResultRequestMessage>
            getActionResultRequestMessage() {
        return new MessageDescriptor<>(PointHeadActionGetResultRequestMessage.class);
    }
}
