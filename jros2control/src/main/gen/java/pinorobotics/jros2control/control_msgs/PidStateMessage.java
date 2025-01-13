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
import id.jrosmessages.primitives.Duration;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for control_msgs/PidState */
@MessageMetadata(
        name = PidStateMessage.NAME,
        fields = {
            "header",
            "timestep",
            "error",
            "error_dot",
            "p_error",
            "i_error",
            "d_error",
            "p_term",
            "i_term",
            "d_term",
            "i_max",
            "i_min",
            "output"
        })
public class PidStateMessage implements Message {

    static final String NAME = "control_msgs/PidState";

    public HeaderMessage header = new HeaderMessage();

    public Duration timestep = new Duration();

    public double error;

    public double error_dot;

    public double p_error;

    public double i_error;

    public double d_error;

    public double p_term;

    public double i_term;

    public double d_term;

    public double i_max;

    public double i_min;

    public double output;

    public PidStateMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public PidStateMessage withTimestep(Duration timestep) {
        this.timestep = timestep;
        return this;
    }

    public PidStateMessage withError(double error) {
        this.error = error;
        return this;
    }

    public PidStateMessage withErrorDot(double error_dot) {
        this.error_dot = error_dot;
        return this;
    }

    public PidStateMessage withPError(double p_error) {
        this.p_error = p_error;
        return this;
    }

    public PidStateMessage withIError(double i_error) {
        this.i_error = i_error;
        return this;
    }

    public PidStateMessage withDError(double d_error) {
        this.d_error = d_error;
        return this;
    }

    public PidStateMessage withPTerm(double p_term) {
        this.p_term = p_term;
        return this;
    }

    public PidStateMessage withITerm(double i_term) {
        this.i_term = i_term;
        return this;
    }

    public PidStateMessage withDTerm(double d_term) {
        this.d_term = d_term;
        return this;
    }

    public PidStateMessage withIMax(double i_max) {
        this.i_max = i_max;
        return this;
    }

    public PidStateMessage withIMin(double i_min) {
        this.i_min = i_min;
        return this;
    }

    public PidStateMessage withOutput(double output) {
        this.output = output;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header, timestep, error, error_dot, p_error, i_error, d_error, p_term, i_term,
                d_term, i_max, i_min, output);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PidStateMessage other)
            return Objects.equals(header, other.header)
                    && Objects.equals(timestep, other.timestep)
                    && error == other.error
                    && error_dot == other.error_dot
                    && p_error == other.p_error
                    && i_error == other.i_error
                    && d_error == other.d_error
                    && p_term == other.p_term
                    && i_term == other.i_term
                    && d_term == other.d_term
                    && i_max == other.i_max
                    && i_min == other.i_min
                    && output == other.output;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "timestep", timestep,
                "error", error,
                "error_dot", error_dot,
                "p_error", p_error,
                "i_error", i_error,
                "d_error", d_error,
                "p_term", p_term,
                "i_term", i_term,
                "d_term", d_term,
                "i_max", i_max,
                "i_min", i_min,
                "output", output);
    }
}
