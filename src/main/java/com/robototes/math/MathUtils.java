package com.robototes.math;

import static java.lang.Math.*;

/**
 * 
 * @author OroArmor
 *
 */
public class MathUtils {

	/**
	 * Prevents an instance of this class
	 */
	private MathUtils() {
	};

	/**
	 * Constrains a value between two other values
	 * 
	 * @param value    Value to be constrained
	 * @param minValue minimun value allowed
	 * @param maxValue maximun value allowed
	 * @return The value constrained between minValue and maxValue
	 */
	public static double constrain(double value, double minValue, double maxValue) {
		return min(max(value, minValue), maxValue);
	}

	/**
	 * 
	 * @param value          The value to map
	 * @param minInputValue  Lower bound of the input range
	 * @param maxInputValue  Upper bound of the input range
	 * @param minOutputValue Lower bound of the output range
	 * @param maxOutputValue Upper bound of the output range
	 * @return The value mapped from the input range to the output range
	 */
	public static double map(double value, double minInputValue, double maxInputValue, double minOutputValue,
			double maxOutputValue) {

		return (value - minInputValue) / (maxInputValue - minInputValue) * (maxOutputValue - minOutputValue)
				+ minOutputValue;

	}

	/**
	 * Cubes a value
	 * 
	 * @param value Value to be cubed
	 * @return Cubed value
	 */
	public static double cube(double value) {
		return cube.compute(value);
	}

	/**
	 * Cubes an array of values
	 * 
	 * @param values list of values to cube
	 * @return list of cubed values
	 */
	public static double[] cubeValues(double[] values) {
		return runFunction(values, cube);
	}

	/**
	 * Runs a MathFunction on a list of values, allowing for easier ways to
	 * manipulate many values
	 * 
	 * @param input    The list of values
	 * @param function The function to compute with the values
	 * @return The outputs of the function
	 */
	public static double[] runFunction(double[] input, MathFunction function) {
		double[] output = new double[input.length];

		for (int i = 0; i < output.length; i++) {
			output[i] = function.compute(input[i]);
		}
		return output;
	}

	/**
	 * 
	 * @author OroArmor
	 *
	 */
	public static interface MathFunction {
		/**
		 * 
		 * @param i Input
		 * @return Output
		 */
		public double compute(double i);
	}

	private static MathFunction cube = (i) -> pow(i, 3);

	/**
	 * Calclates the distance from the origin in any number of dimensions
	 * 
	 * @param values List of values
	 * @return The distance from the origin
	 */
	public static double distance(double... values) {
		double total = 0;
		for (double value : values) {
			total += pow(value, 2);
		}
		return sqrt(total);
	}
}
