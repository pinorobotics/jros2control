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
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for control_msgs/SteeringControllerStatus */
@MessageMetadata(
        name = SteeringControllerStatusMessage.NAME,
        fields = {
            "header",
            "traction_wheels_position",
            "traction_wheels_velocity",
            "steer_positions",
            "linear_velocity_command",
            "steering_angle_command"
        })
public class SteeringControllerStatusMessage implements Message {

    static final String NAME = "control_msgs/SteeringControllerStatus";

    public HeaderMessage header = new HeaderMessage();

    /** positions of traction wheels if the robot is controlled by position */
    public double[] traction_wheels_position = new double[0];

    /** velocities of traction wheels if the robot is controlled by velocity */
    public double[] traction_wheels_velocity = new double[0];

    /** positions of steering joints */
    public double[] steer_positions = new double[0];

    /** value commanded to tractions joint */
    public double[] linear_velocity_command = new double[0];

    /** values commanded to steering joints */
    public double[] steering_angle_command = new double[0];

    public SteeringControllerStatusMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public SteeringControllerStatusMessage withTractionWheelsPosition(
            double... traction_wheels_position) {
        this.traction_wheels_position = traction_wheels_position;
        return this;
    }

    public SteeringControllerStatusMessage withTractionWheelsVelocity(
            double... traction_wheels_velocity) {
        this.traction_wheels_velocity = traction_wheels_velocity;
        return this;
    }

    public SteeringControllerStatusMessage withSteerPositions(double... steer_positions) {
        this.steer_positions = steer_positions;
        return this;
    }

    public SteeringControllerStatusMessage withLinearVelocityCommand(
            double... linear_velocity_command) {
        this.linear_velocity_command = linear_velocity_command;
        return this;
    }

    public SteeringControllerStatusMessage withSteeringAngleCommand(
            double... steering_angle_command) {
        this.steering_angle_command = steering_angle_command;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header,
                Arrays.hashCode(traction_wheels_position),
                Arrays.hashCode(traction_wheels_velocity),
                Arrays.hashCode(steer_positions),
                Arrays.hashCode(linear_velocity_command),
                Arrays.hashCode(steering_angle_command));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SteeringControllerStatusMessage other)
            return Objects.equals(header, other.header)
                    && Arrays.equals(traction_wheels_position, other.traction_wheels_position)
                    && Arrays.equals(traction_wheels_velocity, other.traction_wheels_velocity)
                    && Arrays.equals(steer_positions, other.steer_positions)
                    && Arrays.equals(linear_velocity_command, other.linear_velocity_command)
                    && Arrays.equals(steering_angle_command, other.steering_angle_command);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "traction_wheels_position", traction_wheels_position,
                "traction_wheels_velocity", traction_wheels_velocity,
                "steer_positions", steer_positions,
                "linear_velocity_command", linear_velocity_command,
                "steering_angle_command", steering_angle_command);
    }
}
