/*
 * Copyright 2024 jroscontrol project
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
package pinorobotics.jros2control;

import id.jros2messages.sensor_msgs.JointStateMessage;
import id.jros2messages.std_msgs.HeaderMessage;
import id.jrosclient.JRosClient;
import id.jrosclient.TopicSubmissionPublisher;
import id.jrosmessages.primitives.Time;
import id.xfunction.logging.XLogger;
import id.xfunction.util.IdempotentService;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

/**
 * Joint State Broadcaster
 *
 * <p>In ROS control framework broadcasters are used to publish data from the hardware.
 *
 * <p>This implementation of Joint State Broadcaster let users to publish any updates which happened
 * with joint states in hardware to all ROS components:
 *
 * <ul>
 *   <li>When state of joints is changed in hardware users send them to the broadcaster with update
 *       methods ( {@link #updatePositions(double...)}, ...).
 *   <li>Broadcaster periodically publishes the latest state available to it to /joint_states topic
 * </ul>
 *
 * <p>Alternatively users can provide {@link Supplier} which will be used by the {@link
 * JointStateBroadcaster} to obtain current joint state.
 *
 * @see <a
 *     href="https://control.ros.org/master/doc/ros2_controllers/doc/controllers_index.html#broadcasters">ROS
 *     controllers</a>
 * @author lambdaprime intid@protonmail.com
 */
public class JointStateBroadcaster extends IdempotentService implements JointStateListener {
    private static final XLogger LOGGER = XLogger.getLogger(JointStateBroadcaster.class);
    private ScheduledExecutorService scheduledExecutor =
            Executors.newSingleThreadScheduledExecutor();
    private JRosClient client;
    private JointStateMessage jointStateMessage;
    private Duration rate;
    private Optional<Supplier<JointState>> stateSupplier;
    private JointState state;

    /**
     * @param joints list of joints which states will be published. It can be taken from
     *     ros2_controllers.yaml which is usually generated by MoveIt Setup Assistant
     * @param rate how often states are published
     */
    public JointStateBroadcaster(
            JRosClient client,
            List<String> joints,
            Optional<Supplier<JointState>> stateSupplier,
            Duration rate) {
        this.client = client;
        this.rate = rate;
        int numOfJoints = joints.size();
        state = new JointState(new double[numOfJoints], new double[numOfJoints]);
        jointStateMessage =
                new JointStateMessage()
                        .withHeader(new HeaderMessage().withStamp(Time.now()))
                        .withNames(joints.toArray(new String[0]))
                        .withEfforts(
                                DoubleStream.generate(() -> Double.NaN)
                                        .limit(numOfJoints)
                                        .toArray());
        this.stateSupplier = stateSupplier;
    }

    @Override
    protected void onClose() {
        scheduledExecutor.shutdown();
    }

    @Override
    protected void onStart() {
        LOGGER.info("Starting");
        var publisher = new TopicSubmissionPublisher<>(JointStateMessage.class, "joint_states");
        // register a new publisher for a new topic with ROS
        client.publish(publisher);
        scheduledExecutor.scheduleAtFixedRate(
                () -> {
                    try {
                        jointStateMessage.header.stamp = Time.now();

                        stateSupplier.ifPresent(getter -> state = getter.get());

                        LOGGER.fine("Submitting current joint state: " + state);
                        jointStateMessage.withPositions(state.positions());
                        jointStateMessage.withVelocities(state.velocities());
                        publisher.submit(jointStateMessage);
                    } catch (Exception e) {
                        LOGGER.severe(e);
                    }
                },
                0,
                rate.toMillis(),
                TimeUnit.MILLISECONDS);
    }

    @Override
    public void update(JointState state) {
        this.state = state;
    }
}