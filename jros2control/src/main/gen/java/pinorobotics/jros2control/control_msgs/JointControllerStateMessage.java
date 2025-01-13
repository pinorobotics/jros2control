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
import java.util.Objects;

/**
 * Definition for control_msgs/JointControllerState
 *
 * <p>This message presents current controller state of one joint.
 */
@MessageMetadata(
        name = JointControllerStateMessage.NAME,
        fields = {
            "header",
            "set_point",
            "process_value",
            "process_value_dot",
            "error",
            "time_step",
            "command",
            "p",
            "i",
            "d",
            "i_clamp",
            "antiwindup"
        })
public class JointControllerStateMessage implements Message {

    static final String NAME = "control_msgs/JointControllerState";

    /**
     * It is deprecated as of Humble in favor of SingleDOFStateStamped.msg Header timestamp should
     * be update time of controller state
     */
    public HeaderMessage header = new HeaderMessage();

    /** The set point, that is, desired state. */
    public double set_point;

    /** Current value of the process (ie: latest sensor measurement on the controlled value). */
    public double process_value;

    /** First time-derivative of the process value. */
    public double process_value_dot;

    /**
     * The error of the controlled value, essentially process_value - set_point (for a regular PID
     * implementation).
     */
    public double error;

    /** Time between two consecutive updates/execution of the control law. */
    public double time_step;

    /** Current output of the controller. */
    public double command;

    /** Current PID parameters of the controller. */
    public double p;

    public double i;

    public double d;

    public double i_clamp;

    public boolean antiwindup;

    public JointControllerStateMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public JointControllerStateMessage withSetPoint(double set_point) {
        this.set_point = set_point;
        return this;
    }

    public JointControllerStateMessage withProcessValue(double process_value) {
        this.process_value = process_value;
        return this;
    }

    public JointControllerStateMessage withProcessValueDot(double process_value_dot) {
        this.process_value_dot = process_value_dot;
        return this;
    }

    public JointControllerStateMessage withError(double error) {
        this.error = error;
        return this;
    }

    public JointControllerStateMessage withTimeStep(double time_step) {
        this.time_step = time_step;
        return this;
    }

    public JointControllerStateMessage withCommand(double command) {
        this.command = command;
        return this;
    }

    public JointControllerStateMessage withP(double p) {
        this.p = p;
        return this;
    }

    public JointControllerStateMessage withI(double i) {
        this.i = i;
        return this;
    }

    public JointControllerStateMessage withD(double d) {
        this.d = d;
        return this;
    }

    public JointControllerStateMessage withIClamp(double i_clamp) {
        this.i_clamp = i_clamp;
        return this;
    }

    public JointControllerStateMessage withAntiwindup(boolean antiwindup) {
        this.antiwindup = antiwindup;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header,
                set_point,
                process_value,
                process_value_dot,
                error,
                time_step,
                command,
                p,
                i,
                d,
                i_clamp,
                antiwindup);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JointControllerStateMessage other)
            return Objects.equals(header, other.header)
                    && set_point == other.set_point
                    && process_value == other.process_value
                    && process_value_dot == other.process_value_dot
                    && error == other.error
                    && time_step == other.time_step
                    && command == other.command
                    && p == other.p
                    && i == other.i
                    && d == other.d
                    && i_clamp == other.i_clamp
                    && antiwindup == other.antiwindup;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "set_point", set_point,
                "process_value", process_value,
                "process_value_dot", process_value_dot,
                "error", error,
                "time_step", time_step,
                "command", command,
                "p", p,
                "i", i,
                "d", d,
                "i_clamp", i_clamp,
                "antiwindup", antiwindup);
    }
}
