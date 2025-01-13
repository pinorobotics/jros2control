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

import id.jros2messages.geometry_msgs.TransformStampedMessage;
import id.jros2messages.geometry_msgs.TwistStampedMessage;
import id.jros2messages.geometry_msgs.WrenchStampedMessage;
import id.jros2messages.sensor_msgs.JointStateMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.QuaternionMessage;
import id.jrosmessages.std_msgs.Float64MultiArrayMessage;
import id.jrosmessages.std_msgs.Int8MultiArrayMessage;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/** Definition for control_msgs/AdmittanceControllerState */
@MessageMetadata(
        name = AdmittanceControllerStateMessage.NAME,
        fields = {
            "mass",
            "damping",
            "stiffness",
            "rot_base_control",
            "ref_trans_base_ft",
            "selected_axes",
            "ft_sensor_frame",
            "admittance_position",
            "admittance_acceleration",
            "admittance_velocity",
            "wrench_base",
            "joint_state"
        })
public class AdmittanceControllerStateMessage implements Message {

    static final String NAME = "control_msgs/AdmittanceControllerState";

    /** Admittance parameters 6-vector of mass terms used in the admittance calculation */
    public Float64MultiArrayMessage mass = new Float64MultiArrayMessage();

    /** 6-vector of damping terms used in the admittance calculation */
    public Float64MultiArrayMessage damping = new Float64MultiArrayMessage();

    /** 6-vector of stiffness terms used in the admittance calculation */
    public Float64MultiArrayMessage stiffness = new Float64MultiArrayMessage();

    /** Frame information quaternion describing the orientation of the control frame */
    public QuaternionMessage rot_base_control = new QuaternionMessage();

    /** force torque sensor transform at the reference joint configuration */
    public TransformStampedMessage ref_trans_base_ft = new TransformStampedMessage();

    /**
     * 6-vector of 0/1 describing if admittance is enable in the corresponding control frame axis
     */
    public Int8MultiArrayMessage selected_axes = new Int8MultiArrayMessage();

    /** name of the force torque frame */
    public StringMessage ft_sensor_frame = new StringMessage();

    /** State information calculated admittance position in cartesian space */
    public TransformStampedMessage admittance_position = new TransformStampedMessage();

    /** calculated admittance acceleration in cartesian space */
    public TwistStampedMessage admittance_acceleration = new TwistStampedMessage();

    /** calculated admittance velocity in cartesian space */
    public TwistStampedMessage admittance_velocity = new TwistStampedMessage();

    /** wrench used in the admittance calculation */
    public WrenchStampedMessage wrench_base = new WrenchStampedMessage();

    /** calculated admittance offsets in joint space */
    public JointStateMessage joint_state = new JointStateMessage();

    public AdmittanceControllerStateMessage withMass(Float64MultiArrayMessage mass) {
        this.mass = mass;
        return this;
    }

    public AdmittanceControllerStateMessage withDamping(Float64MultiArrayMessage damping) {
        this.damping = damping;
        return this;
    }

    public AdmittanceControllerStateMessage withStiffness(Float64MultiArrayMessage stiffness) {
        this.stiffness = stiffness;
        return this;
    }

    public AdmittanceControllerStateMessage withRotBaseControl(QuaternionMessage rot_base_control) {
        this.rot_base_control = rot_base_control;
        return this;
    }

    public AdmittanceControllerStateMessage withRefTransBaseFt(
            TransformStampedMessage ref_trans_base_ft) {
        this.ref_trans_base_ft = ref_trans_base_ft;
        return this;
    }

    public AdmittanceControllerStateMessage withSelectedAxes(Int8MultiArrayMessage selected_axes) {
        this.selected_axes = selected_axes;
        return this;
    }

    public AdmittanceControllerStateMessage withFtSensorFrame(StringMessage ft_sensor_frame) {
        this.ft_sensor_frame = ft_sensor_frame;
        return this;
    }

    public AdmittanceControllerStateMessage withAdmittancePosition(
            TransformStampedMessage admittance_position) {
        this.admittance_position = admittance_position;
        return this;
    }

    public AdmittanceControllerStateMessage withAdmittanceAcceleration(
            TwistStampedMessage admittance_acceleration) {
        this.admittance_acceleration = admittance_acceleration;
        return this;
    }

    public AdmittanceControllerStateMessage withAdmittanceVelocity(
            TwistStampedMessage admittance_velocity) {
        this.admittance_velocity = admittance_velocity;
        return this;
    }

    public AdmittanceControllerStateMessage withWrenchBase(WrenchStampedMessage wrench_base) {
        this.wrench_base = wrench_base;
        return this;
    }

    public AdmittanceControllerStateMessage withJointState(JointStateMessage joint_state) {
        this.joint_state = joint_state;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                mass,
                damping,
                stiffness,
                rot_base_control,
                ref_trans_base_ft,
                selected_axes,
                ft_sensor_frame,
                admittance_position,
                admittance_acceleration,
                admittance_velocity,
                wrench_base,
                joint_state);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AdmittanceControllerStateMessage other)
            return Objects.equals(mass, other.mass)
                    && Objects.equals(damping, other.damping)
                    && Objects.equals(stiffness, other.stiffness)
                    && Objects.equals(rot_base_control, other.rot_base_control)
                    && Objects.equals(ref_trans_base_ft, other.ref_trans_base_ft)
                    && Objects.equals(selected_axes, other.selected_axes)
                    && Objects.equals(ft_sensor_frame, other.ft_sensor_frame)
                    && Objects.equals(admittance_position, other.admittance_position)
                    && Objects.equals(admittance_acceleration, other.admittance_acceleration)
                    && Objects.equals(admittance_velocity, other.admittance_velocity)
                    && Objects.equals(wrench_base, other.wrench_base)
                    && Objects.equals(joint_state, other.joint_state);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "mass", mass,
                "damping", damping,
                "stiffness", stiffness,
                "rot_base_control", rot_base_control,
                "ref_trans_base_ft", ref_trans_base_ft,
                "selected_axes", selected_axes,
                "ft_sensor_frame", ft_sensor_frame,
                "admittance_position", admittance_position,
                "admittance_acceleration", admittance_acceleration,
                "admittance_velocity", admittance_velocity,
                "wrench_base", wrench_base,
                "joint_state", joint_state);
    }
}
