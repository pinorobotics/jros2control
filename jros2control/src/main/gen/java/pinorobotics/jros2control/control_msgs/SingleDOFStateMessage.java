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
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for control_msgs/SingleDOFState
 *
 * <p>This message presents current controller state of one degree of freedom.
 */
@MessageMetadata(
        name = SingleDOFStateMessage.NAME,
        fields = {
            "name",
            "reference",
            "feedback",
            "feedback_dot",
            "error",
            "error_dot",
            "time_step",
            "output"
        })
public class SingleDOFStateMessage implements Message {

    static final String NAME = "control_msgs/SingleDOFState";

    /** DoF name, e.g., joint or Cartesian axis name */
    public StringMessage name = new StringMessage();

    /** The set point, that is, desired state. */
    public double reference;

    /** Current value of the process (ie: latest sensor measurement on the controlled value). */
    public double feedback;

    /** First time-derivative of the process value. E.g., velocity. */
    public double feedback_dot;

    /**
     * The error of the controlled value, essentially process_value - set_point (for a regular PID
     * implementation).
     */
    public double error;

    /** First time-derivative of the error of the controlled value. */
    public double error_dot;

    /** Time between two consecutive updates/execution of the control law. */
    public double time_step;

    /** Current output of the controller. */
    public double output;

    public SingleDOFStateMessage withName(StringMessage name) {
        this.name = name;
        return this;
    }

    public SingleDOFStateMessage withReference(double reference) {
        this.reference = reference;
        return this;
    }

    public SingleDOFStateMessage withFeedback(double feedback) {
        this.feedback = feedback;
        return this;
    }

    public SingleDOFStateMessage withFeedbackDot(double feedback_dot) {
        this.feedback_dot = feedback_dot;
        return this;
    }

    public SingleDOFStateMessage withError(double error) {
        this.error = error;
        return this;
    }

    public SingleDOFStateMessage withErrorDot(double error_dot) {
        this.error_dot = error_dot;
        return this;
    }

    public SingleDOFStateMessage withTimeStep(double time_step) {
        this.time_step = time_step;
        return this;
    }

    public SingleDOFStateMessage withOutput(double output) {
        this.output = output;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name, reference, feedback, feedback_dot, error, error_dot, time_step, output);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SingleDOFStateMessage other)
            return Objects.equals(name, other.name)
                    && reference == other.reference
                    && feedback == other.feedback
                    && feedback_dot == other.feedback_dot
                    && error == other.error
                    && error_dot == other.error_dot
                    && time_step == other.time_step
                    && output == other.output;
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "name", name,
                "reference", reference,
                "feedback", feedback,
                "feedback_dot", feedback_dot,
                "error", error,
                "error_dot", error_dot,
                "time_step", time_step,
                "output", output);
    }
}
