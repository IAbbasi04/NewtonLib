package org.team8592.newtonlib.utils;

import com.choreo.lib.Choreo;

import edu.wpi.first.math.geometry.Pose2d;

public final class ChoreoUtils {
    /**
     * The initial pose for the given Choreo path
     */
    public static Pose2d getStartPoseFromTrajectory(String file) {
        return Choreo.getTrajectory(file).getInitialPose();
    }
}
