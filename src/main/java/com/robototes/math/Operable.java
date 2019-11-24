package com.robototes.math;

/**
 * 
 * @author OroArmor
 *
 * @param <T> The type to run operations on
 */
public interface Operable<T> {

	/**
	 * Adds two values
	 * 
	 * @param other Other value
	 * @return Added value
	 */
	T add(T other);

	/**
	 * Subtracts two values
	 * 
	 * @param other Other value
	 * @return Subtracted value
	 */
	T subtract(T other);

	/**
	 * Multiplies two values
	 * 
	 * @param other Other value
	 * @return Multiplied value
	 */
	T multiply(T other);

	/**
	 * Divides two values
	 * 
	 * @param other Other value
	 * @return Divided value
	 */
	T divide(T other);
}
