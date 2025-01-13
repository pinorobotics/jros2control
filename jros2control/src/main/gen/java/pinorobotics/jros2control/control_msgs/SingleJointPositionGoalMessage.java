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
import id.jrosmessages.primitives.Duration;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for control_msgs/SingleJointPositionGoal */
@MessageMetadata(
        name = SingleJointPositionGoalMessage.NAME,
        fields = {"position", "min_duration", "max_velocity"})
public class SingleJointPositionGoalMessage implements Message {

    static final String NAME = "control_msgs/SingleJointPositionGoal";

    public double position;

    public Duration min_duration = new Duration();

    public double max_velocity;

    public SingleJointPositionGoalMessage withPosition(double position) {
        this.position = position;
        return this;
    }

    public SingleJointPositionGoalMessage withMinDuration(Duration min_duration) {
        this.min_duration = min_duration;
        return this;
    }

    public SingleJointPositionGoalMessage withMaxVelocity(double max_velocity) {
        this.max_velocity = max_velocity;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, min_duration, max_velocity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SingleJointPositionGoalMessage other)
            return position == other.position
                    && Objects.equals(min_duration, other.min_duration)
                    && max_velocity == other.max_velocity;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "position", position,
                "min_duration", min_duration,
                "max_velocity", max_velocity);
    }
}
