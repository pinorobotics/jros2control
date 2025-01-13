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
import id.jrosmessages.std_msgs.StringMessage;
import id.jrosmessages.trajectory_msgs.JointTrajectoryPointMessage;
import id.jrosmessages.trajectory_msgs.MultiDOFJointTrajectoryPointMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for control_msgs/JointTrajectoryControllerState
 *
 * <p>This message presents current controller state of JTC
 */
@MessageMetadata(
        name = JointTrajectoryControllerStateMessage.NAME,
        fields = {
            "header",
            "joint_names",
            "reference",
            "feedback",
            "error",
            "output",
            "desired",
            "actual",
            "multi_dof_joint_names",
            "multi_dof_reference",
            "multi_dof_feedback",
            "multi_dof_error",
            "multi_dof_output",
            "multi_dof_desired",
            "multi_dof_actual"
        })
public class JointTrajectoryControllerStateMessage implements Message {

    static final String NAME = "control_msgs/JointTrajectoryControllerState";

    /** Header timestamp should be update time of controller state */
    public HeaderMessage header = new HeaderMessage();

    public StringMessage[] joint_names = new StringMessage[0];

    /** The set point, that is, desired state. */
    public JointTrajectoryPointMessage reference = new JointTrajectoryPointMessage();

    /** Current value of the process (ie: latest sensor measurement on the controlled value). */
    public JointTrajectoryPointMessage feedback = new JointTrajectoryPointMessage();

    /**
     * The error of the controlled value, essentially reference - feedback (for a regular PID
     * implementation).
     */
    public JointTrajectoryPointMessage error = new JointTrajectoryPointMessage();

    /** Current output of the controller. */
    public JointTrajectoryPointMessage output = new JointTrajectoryPointMessage();

    /** -- deprecated -- */
    public JointTrajectoryPointMessage desired = new JointTrajectoryPointMessage();

    public JointTrajectoryPointMessage actual = new JointTrajectoryPointMessage();

    public StringMessage[] multi_dof_joint_names = new StringMessage[0];

    /** The set point, that is, desired state. */
    public MultiDOFJointTrajectoryPointMessage multi_dof_reference =
            new MultiDOFJointTrajectoryPointMessage();

    /** Current value of the process (ie: latest sensor measurement on the controlled value). */
    public MultiDOFJointTrajectoryPointMessage multi_dof_feedback =
            new MultiDOFJointTrajectoryPointMessage();

    /**
     * The error of the controlled value, essentially reference - feedback (for a regular PID
     * implementation).
     */
    public MultiDOFJointTrajectoryPointMessage multi_dof_error =
            new MultiDOFJointTrajectoryPointMessage();

    /** Current output of the controller. */
    public MultiDOFJointTrajectoryPointMessage multi_dof_output =
            new MultiDOFJointTrajectoryPointMessage();

    /** -- deprecated -- */
    public MultiDOFJointTrajectoryPointMessage multi_dof_desired =
            new MultiDOFJointTrajectoryPointMessage();

    public MultiDOFJointTrajectoryPointMessage multi_dof_actual =
            new MultiDOFJointTrajectoryPointMessage();

    public JointTrajectoryControllerStateMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public JointTrajectoryControllerStateMessage withJointNames(StringMessage... joint_names) {
        this.joint_names = joint_names;
        return this;
    }

    public JointTrajectoryControllerStateMessage withReference(
            JointTrajectoryPointMessage reference) {
        this.reference = reference;
        return this;
    }

    public JointTrajectoryControllerStateMessage withFeedback(
            JointTrajectoryPointMessage feedback) {
        this.feedback = feedback;
        return this;
    }

    public JointTrajectoryControllerStateMessage withError(JointTrajectoryPointMessage error) {
        this.error = error;
        return this;
    }

    public JointTrajectoryControllerStateMessage withOutput(JointTrajectoryPointMessage output) {
        this.output = output;
        return this;
    }

    public JointTrajectoryControllerStateMessage withDesired(JointTrajectoryPointMessage desired) {
        this.desired = desired;
        return this;
    }

    public JointTrajectoryControllerStateMessage withActual(JointTrajectoryPointMessage actual) {
        this.actual = actual;
        return this;
    }

    public JointTrajectoryControllerStateMessage withMultiDofJointNames(
            StringMessage... multi_dof_joint_names) {
        this.multi_dof_joint_names = multi_dof_joint_names;
        return this;
    }

    public JointTrajectoryControllerStateMessage withMultiDofReference(
            MultiDOFJointTrajectoryPointMessage multi_dof_reference) {
        this.multi_dof_reference = multi_dof_reference;
        return this;
    }

    public JointTrajectoryControllerStateMessage withMultiDofFeedback(
            MultiDOFJointTrajectoryPointMessage multi_dof_feedback) {
        this.multi_dof_feedback = multi_dof_feedback;
        return this;
    }

    public JointTrajectoryControllerStateMessage withMultiDofError(
            MultiDOFJointTrajectoryPointMessage multi_dof_error) {
        this.multi_dof_error = multi_dof_error;
        return this;
    }

    public JointTrajectoryControllerStateMessage withMultiDofOutput(
            MultiDOFJointTrajectoryPointMessage multi_dof_output) {
        this.multi_dof_output = multi_dof_output;
        return this;
    }

    public JointTrajectoryControllerStateMessage withMultiDofDesired(
            MultiDOFJointTrajectoryPointMessage multi_dof_desired) {
        this.multi_dof_desired = multi_dof_desired;
        return this;
    }

    public JointTrajectoryControllerStateMessage withMultiDofActual(
            MultiDOFJointTrajectoryPointMessage multi_dof_actual) {
        this.multi_dof_actual = multi_dof_actual;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header,
                Arrays.hashCode(joint_names),
                reference,
                feedback,
                error,
                output,
                desired,
                actual,
                Arrays.hashCode(multi_dof_joint_names),
                multi_dof_reference,
                multi_dof_feedback,
                multi_dof_error,
                multi_dof_output,
                multi_dof_desired,
                multi_dof_actual);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof JointTrajectoryControllerStateMessage other)
            return Objects.equals(header, other.header)
                    && Arrays.equals(joint_names, other.joint_names)
                    && Objects.equals(reference, other.reference)
                    && Objects.equals(feedback, other.feedback)
                    && Objects.equals(error, other.error)
                    && Objects.equals(output, other.output)
                    && Objects.equals(desired, other.desired)
                    && Objects.equals(actual, other.actual)
                    && Arrays.equals(multi_dof_joint_names, other.multi_dof_joint_names)
                    && Objects.equals(multi_dof_reference, other.multi_dof_reference)
                    && Objects.equals(multi_dof_feedback, other.multi_dof_feedback)
                    && Objects.equals(multi_dof_error, other.multi_dof_error)
                    && Objects.equals(multi_dof_output, other.multi_dof_output)
                    && Objects.equals(multi_dof_desired, other.multi_dof_desired)
                    && Objects.equals(multi_dof_actual, other.multi_dof_actual);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "joint_names", joint_names,
                "reference", reference,
                "feedback", feedback,
                "error", error,
                "output", output,
                "desired", desired,
                "actual", actual,
                "multi_dof_joint_names", multi_dof_joint_names,
                "multi_dof_reference", multi_dof_reference,
                "multi_dof_feedback", multi_dof_feedback,
                "multi_dof_error", multi_dof_error,
                "multi_dof_output", multi_dof_output,
                "multi_dof_desired", multi_dof_desired,
                "multi_dof_actual", multi_dof_actual);
    }
}
