package com.robototes.math;

import com.robototes.utils.StringUtils;

/**
 * 
 * @author OroArmor
 *
 */
public class DoubleRatio implements Ratio<Double> {

	/**
	 * Ratio between the two sides
	 */
	public double ratio;

	/**
	 * label for the from type
	 */
	public String from;

	/**
	 * label for the to type
	 */
	public String to;

	/**
	 * Creates a double ratio from a conversion value
	 * 
	 * @param ratio Value of the ratio
	 * @param from  From type
	 * @param to    To type
	 */
	public DoubleRatio(double ratio, String from, String to) {
		this.ratio = ratio;
		this.from = from;
		this.to = to;
	}

	/**
	 * Creates a double ratio based on two other ratios
	 * 
	 * @param firstRatio  First ratio
	 * @param secondRatio Second Ratio
	 */
	public DoubleRatio(Ratio<?> firstRatio, Ratio<?> secondRatio) {
		this.ratio = 1d / (firstRatio.getRatio() * secondRatio.getRatio());
		this.from = firstRatio.getFrom();
		this.to = secondRatio.getTo();
	}

	@Override
	public double calculateRatio(Double from) {
		return from * ratio;
	}

	@Override
	public double calculateRatio(double from) {
		return from * ratio;
	}

	@Override
	public double calculateReverseRatio(Double to) {
		return 1d / ratio * to;
	}

	@Override
	public double calculateReverseRatio(double to) {
		return 1d / ratio * to;
	}

	@Override
	public double getRatio() {
		return ratio;
	}

	@Override
	public String getFrom() {
		return from;
	}

	@Override
	public String getTo() {
		return to;
	}

	@Override
	public String toString() {
		return StringUtils.getFormattedValue(getRatio(), 5) + getFrom() + ":1" + getTo();
	}

	@Override
	public Ratio<Double> getInverseRatio() {
		return new DoubleRatio(1d / ratio, to, from);
	}
}
