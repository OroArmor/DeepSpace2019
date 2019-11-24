package com.robototes.units;

import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.TimeUnits;
import com.robototes.utils.StringUtils;

/**
 * A representation of time in the program
 * 
 * @author OroArmor
 *
 */
public class Time implements IUnit<Time> {

	/**
	 * The time unit
	 */
	public double time;

	/**
	 * The main unit for time
	 */
	public static TimeUnits mainUnit = TimeUnits.SECOND;

	/**
	 * 
	 * @param value Creates a Time with a number of seconds
	 */
	public Time(double value) {
		this.time = value;
	}

	/**
	 * Creates time with a given unit
	 * 
	 * @param value    The value of the time
	 * @param unitType the type of time
	 */
	public Time(double value, TimeUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Time add(Time other) {
		return new Time(this.time + other.time);
	}

	@Override
	public Time subtract(Time other) {
		return new Time(this.time - other.time);
	}

	@Override
	public double getValue() {
		return time;
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public Time divide(Time other) {
		return new Time(this.time / other.time);
	}

	@Override
	public Time multiply(Time other) {
		return new Time(this.time * other.time);

	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(time);
	}

	public String toString() {
		return StringUtils.getFormattedValue(getValue(), 4) + this.getUnit();
	}

}
