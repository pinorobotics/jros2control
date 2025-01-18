/**
 * Joint Trajectory Controller
 *
 * <p>There are two mechanisms for sending trajectories to ROS2 joint_trajectory_controller:
 *
 * <ul>
 *   <li>via action server (see {@link
 *       pinorobotics.jros2control.control_msgs.FollowJointTrajectoryActionDefinition})
 *   <li>via topic listener (see {@link id.jros2messages.trajectory_msgs.JointTrajectoryMessage})
 * </ul>
 *
 * <b>jros2control</b> version of joint_trajectory_controller supports both of these mechanisms.
 * Additionally <b>jros2control</b> implements {@link
 * pinorobotics.jros2control.joint_trajectory_controller.JointStateBroadcaster} which allows to
 * report current position of the joints to all ROS2 nodes.
 *
 * <p>Every time <b>jros2control</b> receives new trajectory from ROS nodes (either through internal
 * action server or topic listener), it process all the states through which joints must travel to
 * execute such trajectory. Each of these states are sent to {@link ActuatorHardware} in same order
 * as they present in the trajectory.
 *
 * <p>Difference between <b>jros2control</b> joint_trajectory_controller and ROS2 standard
 * joint_trajectory_controller:
 *
 * <ul>
 *   <li>No interpolation of waypoints in time
 *   <li>Supports only positions (velocities, accelerations, efforts are ignored)
 * </ul>
 *
 * <h2>Usage
 *
 * <p>To use <b>jros2control</b> joint_trajectory_controller users need to:
 *
 * <ul>
 *   <li>start {@link pinorobotics.jros2control.joint_trajectory_controller.JointStateBroadcaster}
 *   <li>start {@link
 *       pinorobotics.jros2control.joint_trajectory_controller.JointTrajectoryController}
 * </ul>
 *
 * @see https://github.com/pinorobotics/r2d2_control jros2control usage example (Joint Trajectory
 *     Controller implementation for Dorna2 robotic arm)
 * @author lambdaprime intid@protonmail.com
 */
package pinorobotics.jros2control.joint_trajectory_controller;
