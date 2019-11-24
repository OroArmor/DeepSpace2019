package com.robototes.units;

import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.utils.StringUtils;

/**
 * A representation of distance in the program. Default unit is the meter.
 * 
 * @author OroArmor
 *
 */
public class Distance implements IUnit<Distance> {

	/**
	 * distance of the unit
	 */
	public double distance;
	/**
	 * the main unit
	 */
	public static DistanceUnits mainUnit = DistanceUnits.METER;

	/**
	 * Creates a distance with a meter value
	 * 
	 * @param value the length of the meter distance
	 */
	public Distance(double value) {
		this.distance = value;
	}

	/**
	 * Creates a distance with any unit
	 * 
	 * @param value    length of the unit
	 * @param unitType type of the unit
	 */
	public Distance(double value, DistanceUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Distance add(Distance other) {
		return new Distance(this.distance + other.distance);
	}

	@Override
	public Distance subtract(Distance other) {
		return new Distance(this.distance - other.distance);
	}

	@Override
	public Distance multiply(Distance other) {
		return new Distance(this.distance * other.distance);
	}

	@Override
	public Distance divide(Distance other) {
		return new Distance(this.distance / other.distance);
	}

	@Override
	public double getValue() {
		return distance;
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(distance);
	}

	public String toString() {
		return StringUtils.getFormattedValue(getValue(), 4) + this.getUnit();
	}
}
