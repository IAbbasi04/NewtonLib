package org.team8592.newtonlib;

import edu.wpi.first.math.controller.*;
import edu.wpi.first.math.trajectory.TrapezoidProfile.Constraints;

public class PIDGainsProfile {
    public int pidSlot = 0;

    public double kP = 0;
    public double kI = 0;
    public double kD = 0;
    public double kFF = 0;
    public double kS = 0;
    public double kA = 0;
    public double kV = 0;
    public double kG = 0;


    public double maxAcceleration = Double.POSITIVE_INFINITY;
    public double maxVelocity = Double.POSITIVE_INFINITY;

    public double tolerance = 0;

    public boolean continuousInput = false;
    public double continuousMin = Double.NEGATIVE_INFINITY;
    public double continuousMax = Double.POSITIVE_INFINITY;

    public boolean softLimit = false;
    public double softLimitMin = Double.NEGATIVE_INFINITY;
    public double softLimitMax = Double.POSITIVE_INFINITY;

    public double scale = 1.0;

    public int currentLimit = -1;

    public boolean useSmartMotion = false;

    public PIDGainsProfile() {}

    public PIDGainsProfile setP(double gain) {
        kP = gain;
        return this;
    }

    public double getP() {
        return kP;
    }

    public PIDGainsProfile setI(double gain) {
        kI = gain;
        return this;
    }

    public double getI() {
        return kI;
    }

    public PIDGainsProfile setD(double gain) {
        kD = gain;
        return this;
    }

    public double getD() {
        return kD;
    }

    public PIDGainsProfile setFF(double gain) {
        kFF = gain;
        return this;
    }

    public double getFF() {
        return kFF;
    }

    public PIDGainsProfile setV(double gain) {
        this.kV = gain;
        return this;
    }

    public double getV() {
        return kV;
    }

    public PIDGainsProfile setA(double gain) {
        this.kA = gain;
        return this;
    }

    public double getA() {
        return kA;
    }

    public PIDGainsProfile setS(double gain) {
        this.kS = gain;
        return this;
    }

    public double getS() {
        return kS;
    }

    public PIDGainsProfile setG(double gain) {
        this.kG = gain;
        return this;
    }

    public double getG() {
        return kG;
    }

    public PIDGainsProfile setMaxAcceleration(double gain) {
        maxAcceleration = gain;
        useSmartMotion = true;
        return this;
    }

    public double getMaxAcceleration() {
        return maxAcceleration;
    }

    public PIDGainsProfile setMaxVelocity(double gain) {
        maxVelocity = gain;
        useSmartMotion = true;
        return this;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }

    public PIDGainsProfile setSlot(int slot) {
        pidSlot = slot;
        return this;
    }

    public int getSlot() {
        return pidSlot;
    }

    public PIDGainsProfile setTolerance(double tolerance) {
        this.tolerance = tolerance;
        return this;
    }

    public double getTolerance() {
        return tolerance;
    }

    /**
     * Useful for continually rotating mechanisms
     */
    public PIDGainsProfile setContinuousInput(double min, double max) {
        this.continuousMin = min;
        this.continuousMax = max;
        this.continuousInput = true;
        return this;
    }

    public boolean isContinuousInput() {
        return continuousInput;
    }

    /**
     * Currently only works for neo motors
     */
    public PIDGainsProfile setSoftLimits(double min, double max) {
        this.softLimitMin = min;
        this.softLimitMax = max;
        this.softLimit = true;
        return this;
    }

    public boolean hasSoftLimits() {
        return softLimit;
    }

    /**
     * Double array returns both min and max -> [minimum input, maximum input]
     */
    public float[] getSoftLimits() {
        return new float[] {(float)softLimitMin, (float)softLimitMax};
    }

    /**
     * Sets a scaling factor for the output
     */
    public PIDGainsProfile setScalingFactor(double scale) {
        this.scale = scale;
        return this;
    }

    /**
     * Returns the scaling factor
     */
    public double getScalingFactor() {
        return scale;
    }

    /**
     * Sets a maximum current limit
     */
    public PIDGainsProfile setCurrentLimit(int limit) {
        this.currentLimit = limit;
        return this;
    }

    /**
     * Returns the maximum current limit
     */
    public int getCurrentLimit() {
        return currentLimit;
    }

    /**
     * If smart motion and/or smart velocity should be applied
     */
    public boolean isSmartMotion() {
        return useSmartMotion;
    }

    /**
     * Creates a PID controller with the specified constants and configurations
     */
    public ProfiledPIDController toProfiledPIDController() {
        ProfiledPIDController pidCtrl = new ProfiledPIDController(kP, kI, kD, new Constraints(maxVelocity * scale, maxAcceleration * scale));
        pidCtrl.setTolerance(tolerance);
        if (continuousInput) {
            pidCtrl.enableContinuousInput(continuousMin, continuousMax);
        }
        return pidCtrl;
    }

    /**
     * Creates a PID controller with the specified constants and configurations
     */
    public PIDController toPIDController() {
        PIDController pidCtrl = new PIDController(kP, kI, kD);
        pidCtrl.setTolerance(tolerance);
        if (continuousInput) {
            pidCtrl.enableContinuousInput(continuousMin, continuousMax);
        }
        return pidCtrl;
    }
}