/**
 * Java module with ROS2 controllers (Robot Operating System).
 *
 * <p>See {@link pinorobotics.jros2control.JointTrajectoryController} for usage information on
 * creating ROS Joint Trajectory Controller nodes.
 *
 * @author lambdaprime intid@protonmail.com
 */
module jros2control {
    requires jros2client;
    requires jros2messages;
    requires id.xfunction;
    requires transitive jrosclient;

    exports pinorobotics.jros2control;
}
