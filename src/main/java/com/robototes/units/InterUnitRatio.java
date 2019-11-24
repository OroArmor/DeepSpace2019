package com.robototes.units;

import com.robototes.math.Ratio;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.utils.StringUtils;

/**
 * 
 * Forms a ratio between two different unit types, ie rotations to meters
 * 
 * @author OroArmor
 *
 * @param <K> Unit type one
 * @param <V> Unit type two
 */
public class InterUnitRatio<K extends IUnitType<?>, V extends IUnitType<?>> implements Ratio<IUnit<?>> {

	public double ratio;
	public String from;
	public String to;

	public K fromType;
	public V toType;

	/**
	 * Creates a ratio based on two types
	 * 
	 * @param fromType From type
	 * @param ratio    ratio between the two types
	 * @param toType   To type
	 */
	public InterUnitRatio(K fromType, double ratio, V toType) {
		this.fromType = fromType;
		this.from = fromType.getUnit();
		this.ratio = ratio;
		this.to = toType.getUnit();
		this.toType = toType;
	}

	/**
	 * Creates a ratio based on two other interunit ratios, ie rotations:meters and
	 * meters:time -> rotations:time
	 * 
	 * @param ratioOne First ratio
	 * @param ratioTwo Second Ratio
	 */
	public <E extends IUnitType<?>> InterUnitRatio(InterUnitRatio<K, E> ratioOne, InterUnitRatio<E, V> ratioTwo) {

		this.from = ratioOne.getFrom();
		this.fromType = ratioOne.fromType;

		this.ratio = (ratioOne.ratio * ratioTwo.ratio);

		this.toType = ratioTwo.toType;
		this.to = ratioTwo.getTo();

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
	public double calculateRatio(IUnit<?> from) {
		return ratio * fromType.getRatio().calculateReverseRatio(from);
	}

	@Override
	public double calculateRatio(double from) {
		return ratio * from;
	}

	@Override
	public double calculateReverseRatio(IUnit<?> to) {
		return 1d / ratio * toType.getRatio().calculateReverseRatio(to);
	}

	@Override
	public double calculateReverseRatio(double to) {
		return 1d / ratio * to;
	}

	@Override
	public String toString() {
		return StringUtils.getFormattedValue(getRatio(), 5) + getFrom() + ":1" + getTo();
	}

	@Override
	public Ratio<IUnit<?>> getInverseRatio() {
		return new InterUnitRatio<V, K>(toType, 1d / ratio, fromType);
	}
}
