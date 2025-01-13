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

import id.jros2messages.trajectory_msgs.JointTrajectoryMessage;
import id.jros2messages.trajectory_msgs.MultiDOFJointTrajectoryMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.primitives.Duration;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for control_msgs/FollowJointTrajectoryGoal */
@MessageMetadata(
        name = FollowJointTrajectoryGoalMessage.NAME,
        fields = {
            "trajectory",
            "multi_dof_trajectory",
            "path_tolerance",
            "component_path_tolerance",
            "goal_tolerance",
            "component_goal_tolerance",
            "goal_time_tolerance"
        })
public class FollowJointTrajectoryGoalMessage implements Message {

    static final String NAME = "control_msgs/FollowJointTrajectoryGoal";

    /** The trajectory for all revolute, continuous or prismatic joints */
    public JointTrajectoryMessage trajectory = new JointTrajectoryMessage();

    /**
     * The trajectory for all planar or floating joints (i.e. individual joints with more than one
     * DOF)
     */
    public MultiDOFJointTrajectoryMessage multi_dof_trajectory =
            new MultiDOFJointTrajectoryMessage();

    /**
     * Tolerances for the trajectory. If the measured joint values fall outside the tolerances the
     * trajectory goal is aborted. Any tolerances that are not specified (by being omitted or set to
     * 0) are set to the defaults for the action server (often taken from the parameter server).
     * Tolerances applied to the joints as the trajectory is executed. If violated, the goal aborts
     * with error_code set to PATH_TOLERANCE_VIOLATED.
     */
    public JointToleranceMessage[] path_tolerance = new JointToleranceMessage[0];

    public JointComponentToleranceMessage[] component_path_tolerance =
            new JointComponentToleranceMessage[0];

    /**
     * To report success, the joints must be within goal_tolerance of the final trajectory value.
     * The goal must be achieved by time the trajectory ends plus goal_time_tolerance.
     * (goal_time_tolerance allows some leeway in time, so that the trajectory goal can still
     * succeed even if the joints reach the goal some time after the precise end time of the
     * trajectory).
     *
     * <p>If the joints are not within goal_tolerance after "trajectory finish time" +
     * goal_time_tolerance, the goal aborts with error_code set to GOAL_TOLERANCE_VIOLATED
     */
    public JointToleranceMessage[] goal_tolerance = new JointToleranceMessage[0];

    public JointComponentToleranceMessage[] component_goal_tolerance =
            new JointComponentToleranceMessage[0];

    public Duration goal_time_tolerance = new Duration();

    public FollowJointTrajectoryGoalMessage withTrajectory(JointTrajectoryMessage trajectory) {
        this.trajectory = trajectory;
        return this;
    }

    public FollowJointTrajectoryGoalMessage withMultiDofTrajectory(
            MultiDOFJointTrajectoryMessage multi_dof_trajectory) {
        this.multi_dof_trajectory = multi_dof_trajectory;
        return this;
    }

    public FollowJointTrajectoryGoalMessage withPathTolerance(
            JointToleranceMessage... path_tolerance) {
        this.path_tolerance = path_tolerance;
        return this;
    }

    public FollowJointTrajectoryGoalMessage withComponentPathTolerance(
            JointComponentToleranceMessage... component_path_tolerance) {
        this.component_path_tolerance = component_path_tolerance;
        return this;
    }

    public FollowJointTrajectoryGoalMessage withGoalTolerance(
            JointToleranceMessage... goal_tolerance) {
        this.goal_tolerance = goal_tolerance;
        return this;
    }

    public FollowJointTrajectoryGoalMessage withComponentGoalTolerance(
            JointComponentToleranceMessage... component_goal_tolerance) {
        this.component_goal_tolerance = component_goal_tolerance;
        return this;
    }

    public FollowJointTrajectoryGoalMessage withGoalTimeTolerance(Duration goal_time_tolerance) {
        this.goal_time_tolerance = goal_time_tolerance;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                trajectory,
                multi_dof_trajectory,
                Arrays.hashCode(path_tolerance),
                Arrays.hashCode(component_path_tolerance),
                Arrays.hashCode(goal_tolerance),
                Arrays.hashCode(component_goal_tolerance),
                goal_time_tolerance);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FollowJointTrajectoryGoalMessage other)
            return Objects.equals(trajectory, other.trajectory)
                    && Objects.equals(multi_dof_trajectory, other.multi_dof_trajectory)
                    && Arrays.equals(path_tolerance, other.path_tolerance)
                    && Arrays.equals(component_path_tolerance, other.component_path_tolerance)
                    && Arrays.equals(goal_tolerance, other.goal_tolerance)
                    && Arrays.equals(component_goal_tolerance, other.component_goal_tolerance)
                    && Objects.equals(goal_time_tolerance, other.goal_time_tolerance);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "trajectory", trajectory,
                "multi_dof_trajectory", multi_dof_trajectory,
                "path_tolerance", path_tolerance,
                "component_path_tolerance", component_path_tolerance,
                "goal_tolerance", goal_tolerance,
                "component_goal_tolerance", component_goal_tolerance,
                "goal_time_tolerance", goal_time_tolerance);
    }
}
