package com.robototes.math;

/**
 * 
 * @author OroArmor
 *
 * @param <T> The type to be interpolated
 */
public interface Interpolable<T> {
	/**
	 * Interpolates between two values with a given percentage.
	 * 
	 * @param other Value to interpolate
	 * @param t     Percent of interpolation
	 * @return Interpolated value.
	 */
	T interpolate(T other, double t);
}
