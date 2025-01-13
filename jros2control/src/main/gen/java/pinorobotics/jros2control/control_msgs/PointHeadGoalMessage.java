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

import id.jros2messages.geometry_msgs.PointStampedMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.Vector3Message;
import id.jrosmessages.primitives.Duration;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for control_msgs/PointHeadGoal */
@MessageMetadata(
        name = PointHeadGoalMessage.NAME,
        fields = {"target", "pointing_axis", "pointing_frame", "min_duration", "max_velocity"})
public class PointHeadGoalMessage implements Message {

    static final String NAME = "control_msgs/PointHeadGoal";

    public PointStampedMessage target = new PointStampedMessage();

    public Vector3Message pointing_axis = new Vector3Message();

    public StringMessage pointing_frame = new StringMessage();

    public Duration min_duration = new Duration();

    public double max_velocity;

    public PointHeadGoalMessage withTarget(PointStampedMessage target) {
        this.target = target;
        return this;
    }

    public PointHeadGoalMessage withPointingAxis(Vector3Message pointing_axis) {
        this.pointing_axis = pointing_axis;
        return this;
    }

    public PointHeadGoalMessage withPointingFrame(StringMessage pointing_frame) {
        this.pointing_frame = pointing_frame;
        return this;
    }

    public PointHeadGoalMessage withMinDuration(Duration min_duration) {
        this.min_duration = min_duration;
        return this;
    }

    public PointHeadGoalMessage withMaxVelocity(double max_velocity) {
        this.max_velocity = max_velocity;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(target, pointing_axis, pointing_frame, min_duration, max_velocity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PointHeadGoalMessage other)
            return Objects.equals(target, other.target)
                    && Objects.equals(pointing_axis, other.pointing_axis)
                    && Objects.equals(pointing_frame, other.pointing_frame)
                    && Objects.equals(min_duration, other.min_duration)
                    && max_velocity == other.max_velocity;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "target", target,
                "pointing_axis", pointing_axis,
                "pointing_frame", pointing_frame,
                "min_duration", min_duration,
                "max_velocity", max_velocity);
    }
}
