/**
 * Java module with ROS2 controllers (Robot Operating System).
 *
 * <p>Supported controllers:
 *
 * <ul>
 *   <li>joint_trajectory_controller (see {@link
 *       pinorobotics.jros2control.joint_trajectory_controller.JointTrajectoryControllerFactory})
 * </ul>
 *
 * @author lambdaprime intid@protonmail
 */
module jros2control {
    requires transitive jros2client;
    requires transitive jrosclient;
    requires transitive jroscommon;
    requires jros2messages;
    requires id.xfunction;
    requires jros2actionlib;
    requires jrosservices;
    requires java.logging;

    exports pinorobotics.jros2control.joint_trajectory_controller;
    exports pinorobotics.jros2control.control_msgs to
            jros2actionlib,
            id.kineticstreamer;
}
