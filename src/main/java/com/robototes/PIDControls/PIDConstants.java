package com.robototes.PIDControls;

/**
 * 
 * A wrapper class for a list of PID Constants, making it easy to apply the same
 * constants in many places, or switch during run time.
 * 
 * @author OroArmor
 * 
 * 
 */
public class PIDConstants {
	/**
	 * The P value
	 */
	public double k_P = 0;
	/**
	 * The I value
	 */
	public double k_I = 0;

	/**
	 * The D value
	 */
	public double k_D = 0;

	/**
	 * The Integral Dampening value
	 */
	public double k_IDamp = 1;

	/**
	 * Creates a PIDConstants with just a P value
	 * 
	 * @param k_P P value
	 */
	public PIDConstants(double k_P) {
		this.k_P = k_P;
	}

	/**
	 * Creates a PIDConstants with all values
	 * 
	 * @param k_P     P value
	 * @param k_I     I value
	 * @param k_D     D value
	 * @param k_IDamp Integral Dampening value
	 */
	public PIDConstants(double k_P, double k_I, double k_D, double k_IDamp) {
		this.k_P = k_P;
		this.k_I = k_I;
		this.k_D = k_D;
		this.k_IDamp = k_IDamp;
	}

	/**
	 * Creates a PIDConstants with P, I, and D values
	 * 
	 * @param k_P P value
	 * @param k_I I value
	 * @param k_D D value
	 */
	public PIDConstants(double k_P, double k_I, double k_D) {
		this.k_P = k_P;
		this.k_I = k_I;
		this.k_D = k_D;
	}

	/**
	 * Creates a PIDConstants with P and D values
	 * 
	 * @param k_P P value
	 * @param k_D D value
	 */
	public PIDConstants(double k_P, double k_D) {
		this.k_P = k_P;
		this.k_D = k_D;
	}

	/**
	 * 
	 * @return The P value
	 */
	public double getK_P() {
		return k_P;
	}

	/**
	 * 
	 * @param k_P Sets the P value
	 */
	public void setK_P(double k_P) {
		this.k_P = k_P;
	}

	/**
	 * 
	 * @return The I value
	 */
	public double getK_I() {
		return k_I;
	}

	/**
	 * 
	 * @param k_I Sets the I value
	 */
	public void setK_I(double k_I) {
		this.k_I = k_I;
	}

	/**
	 * 
	 * @return The D value
	 */
	public double getK_D() {
		return k_D;
	}

	/**
	 * 
	 * @param k_D Sets the D value
	 */
	public void setK_D(double k_D) {
		this.k_D = k_D;
	}

	/**
	 * 
	 * @return The Integral Dampening value
	 */
	public double getK_IDamp() {
		return k_IDamp;
	}

	/**
	 * 
	 * @param k_IDamp Sets the Integral Dampening value
	 */
	public void setK_IDamp(double k_IDamp) {
		this.k_IDamp = k_IDamp;
	}

}
