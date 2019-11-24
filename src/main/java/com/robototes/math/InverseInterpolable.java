package com.robototes.math;

/**
 * 
 * @author OroArmor
 *
 * @param <T> The type to be Interpolated with
 */
public interface InverseInterpolable<T> {

	/**
	 * Finds the percent of interpolation
	 * 
	 * @param upper Upper value to calculate with
	 * @param query Value used to find percentage of interpolation
	 * @return The percent of interpolation of query between upper and this
	 */
	double inverseInterpolate(T upper, T query);
}
