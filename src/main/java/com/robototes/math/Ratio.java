package com.robototes.math;

/**
 * 
 * @author OroArmor
 *
 * @param <T> The type of the ratio
 */
public interface Ratio<T> {

	/**
	 * 
	 * @return The double value of the ratio
	 */
	public double getRatio();

	/**
	 * 
	 * @return The label of the from
	 */
	public String getFrom();

	/**
	 * 
	 * @return label of the to
	 */
	public String getTo();

	/**
	 * With the ratio from:to, it calculates the to
	 * 
	 * @param from Left side of the ratio
	 * @return The right side of the ratio
	 */
	public double calculateRatio(T from);

	/**
	 * With the ratio from:to, it calculates the to
	 * 
	 * @param from left side of the ratio as a pure double value
	 * @return right side of the ratio
	 */
	public double calculateRatio(double from);

	/**
	 * With the ratio from:to, it calculates the from
	 * 
	 * @param to right side of the ratio
	 * @return left side of the ratio
	 */
	public double calculateReverseRatio(T to);

	/**
	 * With the ratio from:to, it calculates the from
	 * 
	 * @param to right side of the ratio as a pure double value
	 * @return left side of the ratio
	 */
	public double calculateReverseRatio(double to);

	/**
	 * 
	 * @return The inverse of the ratio
	 */
	public Ratio<T> getInverseRatio();
}
