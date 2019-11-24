package com.robototes.units;

import com.robototes.math.Ratio;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.utils.StringUtils;

/**
 * A ratio between different types of the same unit
 * 
 * @author OroArmor
 *
 * @param <T> The Unit for the ratio
 */
public class UnitRatio<T extends IUnit<?>> implements Ratio<IUnit<?>> {

	/**
	 * The ratio between units
	 */
	public double ratio;

	/**
	 * the from unit
	 */
	public String from;

	/**
	 * the to unit
	 */
	public String to;

	/**
	 * 
	 * Creates a ratio between the two different unit types
	 * 
	 * @param ratio value of the ratio
	 * @param from  the from unit
	 * @param to    the to unit
	 */
	public <K extends IUnitType<?>> UnitRatio(double ratio, IUnitType<K> from, IUnitType<K> to) {
		this.ratio = ratio;
		this.from = from.getUnit();
		this.to = to.getUnit();
	}

	/**
	 * 
	 * Creates a ratio between the two different unit labels
	 * 
	 * @param ratio value of the ratio
	 * @param from  the from unit
	 * @param to    the to unit
	 */
	public UnitRatio(double ratio, String from, String to) {
		this.ratio = ratio;
		this.from = from;
		this.to = to;
	}

	/**
	 * Creates a ratio between two different ratios
	 * 
	 * @param firstRatio First ratio
	 * @param ratio2     Second Ratio
	 */
	public UnitRatio(UnitRatio<?> firstRatio, Ratio<IUnit<?>> ratio2) {
		this.ratio = 1d / (firstRatio.ratio * ratio2.getRatio());
		this.from = firstRatio.from;
		this.to = ratio2.getTo();
	}

	@Override
	public double calculateRatio(IUnit<?> from) {
		return from.getValue() * ratio;
	}

	@Override
	public double calculateRatio(double from) {
		return from * ratio;
	}

	@Override
	public double calculateReverseRatio(IUnit<?> to) {
		return to.getValue() * (1d / ratio);
	}

	@Override
	public double calculateReverseRatio(double to) {
		return to * (1d / ratio);
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
	public Ratio<IUnit<?>> getInverseRatio() {
		return new UnitRatio<T>(1d / ratio, to, from);
	}
}
