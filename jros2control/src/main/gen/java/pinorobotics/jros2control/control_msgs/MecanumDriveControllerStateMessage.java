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

import id.jros2messages.std_msgs.HeaderMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.TwistMessage;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for control_msgs/MecanumDriveControllerState */
@MessageMetadata(
        name = MecanumDriveControllerStateMessage.NAME,
        fields = {
            "header",
            "front_left_wheel_velocity",
            "back_left_wheel_velocity",
            "back_right_wheel_velocity",
            "front_right_wheel_velocity",
            "reference_velocity"
        })
public class MecanumDriveControllerStateMessage implements Message {

    static final String NAME = "control_msgs/MecanumDriveControllerState";

    public HeaderMessage header = new HeaderMessage();

    public double front_left_wheel_velocity;

    public double back_left_wheel_velocity;

    public double back_right_wheel_velocity;

    public double front_right_wheel_velocity;

    public TwistMessage reference_velocity = new TwistMessage();

    public MecanumDriveControllerStateMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public MecanumDriveControllerStateMessage withFrontLeftWheelVelocity(
            double front_left_wheel_velocity) {
        this.front_left_wheel_velocity = front_left_wheel_velocity;
        return this;
    }

    public MecanumDriveControllerStateMessage withBackLeftWheelVelocity(
            double back_left_wheel_velocity) {
        this.back_left_wheel_velocity = back_left_wheel_velocity;
        return this;
    }

    public MecanumDriveControllerStateMessage withBackRightWheelVelocity(
            double back_right_wheel_velocity) {
        this.back_right_wheel_velocity = back_right_wheel_velocity;
        return this;
    }

    public MecanumDriveControllerStateMessage withFrontRightWheelVelocity(
            double front_right_wheel_velocity) {
        this.front_right_wheel_velocity = front_right_wheel_velocity;
        return this;
    }

    public MecanumDriveControllerStateMessage withReferenceVelocity(
            TwistMessage reference_velocity) {
        this.reference_velocity = reference_velocity;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header,
                front_left_wheel_velocity,
                back_left_wheel_velocity,
                back_right_wheel_velocity,
                front_right_wheel_velocity,
                reference_velocity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MecanumDriveControllerStateMessage other)
            return Objects.equals(header, other.header)
                    && front_left_wheel_velocity == other.front_left_wheel_velocity
                    && back_left_wheel_velocity == other.back_left_wheel_velocity
                    && back_right_wheel_velocity == other.back_right_wheel_velocity
                    && front_right_wheel_velocity == other.front_right_wheel_velocity
                    && Objects.equals(reference_velocity, other.reference_velocity);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "front_left_wheel_velocity", front_left_wheel_velocity,
                "back_left_wheel_velocity", back_left_wheel_velocity,
                "back_right_wheel_velocity", back_right_wheel_velocity,
                "front_right_wheel_velocity", front_right_wheel_velocity,
                "reference_velocity", reference_velocity);
    }
}
