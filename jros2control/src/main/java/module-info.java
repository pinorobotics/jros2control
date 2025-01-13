/**
 * Java module with ROS2 controllers (Robot Operating System).
 *
 * <p>See {@link pinorobotics.jros2control.joint_trajectory_controller.JointTrajectorySubscriber}
 * for usage information on creating ROS Joint Trajectory Controller nodes.
 *
 * @author lambdaprime intid@protonmail.com
 */
module jros2control {
    requires transitive jros2client;
    requires transitive jrosclient;
    requires transitive jroscommon;
    requires jros2messages;
    requires id.xfunction;
    requires jros2actionlib;
    requires jrosservices;

    exports pinorobotics.jros2control.joint_trajectory_controller;
    exports pinorobotics.jros2control.control_msgs to
            jros2actionlib,
            id.kineticstreamer;
}
