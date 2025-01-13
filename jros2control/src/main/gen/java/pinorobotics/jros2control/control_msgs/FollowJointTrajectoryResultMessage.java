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

/** Definition for control_msgs/FollowJointTrajectoryResult */
@MessageMetadata(
        name = FollowJointTrajectoryResultMessage.NAME,
        fields = {"error_code", "error_string"})
public class FollowJointTrajectoryResultMessage implements Message {

    static final String NAME = "control_msgs/FollowJointTrajectoryResult";

    public enum ErrorType {
        SUCCESSFUL,
        INVALID_GOAL,
        INVALID_JOINTS,
        OLD_HEADER_TIMESTAMP,
        PATH_TOLERANCE_VIOLATED,
        GOAL_TOLERANCE_VIOLATED
    };

    public int error_code;

    /**
     * Human readable description of the error code. Contains complementary information that is
     * especially useful when execution fails, for instance: - INVALID_GOAL: The reason for the
     * invalid goal (e.g., the requested trajectory is in the past). - INVALID_JOINTS: The mismatch
     * between the expected controller joints and those provided in the goal. -
     * PATH_TOLERANCE_VIOLATED and GOAL_TOLERANCE_VIOLATED: Which joint violated which tolerance,
     * and by how much.
     */
    public StringMessage error_string = new StringMessage();

    public FollowJointTrajectoryResultMessage withErrorCode(ErrorType error_code) {
        this.error_code = error_code.ordinal();
        return this;
    }

    public FollowJointTrajectoryResultMessage withErrorString(StringMessage error_string) {
        this.error_string = error_string;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(error_code, error_string);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FollowJointTrajectoryResultMessage other)
            return Objects.equals(error_code, other.error_code)
                    && Objects.equals(error_string, other.error_string);
        return false;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "error_code", error_code,
                "error_string", error_string);
    }
}
