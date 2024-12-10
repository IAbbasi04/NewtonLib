package org.team8592.newtonlib.hardware.swerve;

public class SwerveSpeedConstants {
    public final double MAX_TRANSLATIONAL_VELOCITY_METERS_PER_SECOND;
    public final double MAX_ROTATIONAL_VELOCITY_RADIANS_PER_SECOND;
    public final double SIMULATED_STEER_INERTIA = 0.00001;
    public final double SIMULATED_DRIVE_INERTIA = 0.06;
    public final double SIMULATION_LOOP_PERIOD = 0.005;

    public SwerveSpeedConstants(double maxTranslate, double maxRotate) {
        this.MAX_TRANSLATIONAL_VELOCITY_METERS_PER_SECOND = maxTranslate;
        this.MAX_ROTATIONAL_VELOCITY_RADIANS_PER_SECOND = maxRotate;
    }
}
