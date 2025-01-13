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
import id.jrosmessages.RosInterfaceType;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for control_msgs/QueryTrajectoryStateServiceResponse */
@MessageMetadata(
        name = QueryTrajectoryStateResponseMessage.NAME,
        interfaceType = RosInterfaceType.SERVICE,
        fields = {"success", "message", "name", "position", "velocity", "acceleration"})
public class QueryTrajectoryStateResponseMessage implements Message {

    static final String NAME = "control_msgs/QueryTrajectoryStateServiceResponse";

    /** indicate successful run of triggered service */
    public boolean success;

    /** informational, e.g. for error messages */
    public StringMessage message = new StringMessage();

    public StringMessage[] name = new StringMessage[0];

    public double[] position = new double[0];

    public double[] velocity = new double[0];

    public double[] acceleration = new double[0];

    public QueryTrajectoryStateResponseMessage withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public QueryTrajectoryStateResponseMessage withMessage(StringMessage message) {
        this.message = message;
        return this;
    }

    public QueryTrajectoryStateResponseMessage withName(StringMessage... name) {
        this.name = name;
        return this;
    }

    public QueryTrajectoryStateResponseMessage withPosition(double... position) {
        this.position = position;
        return this;
    }

    public QueryTrajectoryStateResponseMessage withVelocity(double... velocity) {
        this.velocity = velocity;
        return this;
    }

    public QueryTrajectoryStateResponseMessage withAcceleration(double... acceleration) {
        this.acceleration = acceleration;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                success,
                message,
                Arrays.hashCode(name),
                Arrays.hashCode(position),
                Arrays.hashCode(velocity),
                Arrays.hashCode(acceleration));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof QueryTrajectoryStateResponseMessage other)
            return success == other.success
                    && Objects.equals(message, other.message)
                    && Arrays.equals(name, other.name)
                    && Arrays.equals(position, other.position)
                    && Arrays.equals(velocity, other.velocity)
                    && Arrays.equals(acceleration, other.acceleration);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "success", success,
                "message", message,
                "name", name,
                "position", position,
                "velocity", velocity,
                "acceleration", acceleration);
    }
}
