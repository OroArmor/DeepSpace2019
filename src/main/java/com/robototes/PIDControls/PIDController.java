package com.robototes.PIDControls;

import com.robototes.math.MathUtils;

/**
 * A calculator for a PID system.
 * 
 * @author OroArmor
 *
 */
public class PIDController {

	/*
	 * The sum of the error, used with I
	 */
	public double errorSum;

	/**
	 * The past error, used with D
	 */
	public double pastError;

	/**
	 * The minimum value for the output
	 */
	public double minOutput = Double.MIN_VALUE;

	/**
	 * Maximum value for the output
	 */
	public double maxOutput = Double.MAX_VALUE;

	/**
	 * The constants for the PID Controller
	 */
	public PIDConstants constants;

	/**
	 * 
	 * @param constants PID Constants for the Controller
	 */
	public PIDController(PIDConstants constants) {
		this.constants = constants;
	}

	/**
	 * 
	 * @return The constants used for the PID Controller
	 */
	public PIDConstants getConstants() {
		return this.constants;
	}

	/**
	 * 
	 * @param constants Sets the constants of the controller
	 */
	public void setConstants(PIDConstants constants) {
		this.constants = constants;
	}

	/**
	 * Sets the output range
	 * 
	 * @param min Minimum output
	 * @param max Maximum output
	 */
	public void setMinMax(double min, double max) {

		if (max < min) {
			throw new IllegalArgumentException("Min cannot be greater than max");
		}

		minOutput = min;
		maxOutput = max;
	}

	/**
	 * Calculated the output of the PID function with the constants
	 * 
	 * @param error    The error of the PID System
	 * @param timestep The timestep between two calculations
	 * @return A double value for the output of the function
	 */
	public double getOutput(double error, double timestep) {

		double outP = error * constants.getK_P(); // really simple, multiply the error by a set value to get outP

		errorSum += error;
		double outI = errorSum * constants.getK_I();
		errorSum *= constants.getK_IDamp(); // multiply errorSum after calculating outI to not sink the value of outI.
		// dampen the value to make sure that error doesnt build up too much over time

		double deltaError = (error - pastError) / timestep;
		double outD = deltaError * constants.getK_D();

		double output = outP + outI + outD; // sum all the outputs together to get the output value

		output = MathUtils.constrain(output, minOutput, maxOutput); // make sure the output value is within the range of
																	// values

		pastError = error; // set values for the next calculation

		return output;
	}

}
