package com.robototes.units;

import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.RotationUnits;
import com.robototes.utils.StringUtils;

/**
 * A representation of rotations in the program
 * 
 * @author OroArmor
 *
 */
public class Rotations implements IUnit<Rotations> {

	/**
	 * The number of rotations
	 */
	public double rotations;

	/**
	 * The main rotation unit
	 */
	public static RotationUnits mainUnit = RotationUnits.ROTATION;

	/**
	 * 
	 * @param value Creates a Rotation with a number of rotations
	 */
	public Rotations(double value) {
		this.rotations = value;
	}

	/**
	 * Creates a Rotation with a given type
	 * 
	 * @param value    Value for the type
	 * @param unitType the type of rotation unit
	 */
	public Rotations(double value, RotationUnits unitType) {
		this(unitType.getRatio().calculateRatio(value));
	}

	@Override
	public Rotations add(Rotations other) {
		return new Rotations(this.rotations + other.rotations);
	}

	@Override
	public Rotations subtract(Rotations other) {
		return new Rotations(this.rotations - other.rotations);
	}

	@Override
	public double getValue() {
		return rotations;
	}

	@Override
	public String getUnit() {
		return mainUnit.getUnit();
	}

	@Override
	public Rotations divide(Rotations other) {
		return new Rotations(this.rotations / other.rotations);
	}

	@Override
	public Rotations multiply(Rotations other) {
		return new Rotations(this.rotations * other.rotations);

	}

	@Override
	public <K extends IUnitType<K>> double convertTo(K unitType) {
		return unitType.getRatio().calculateReverseRatio(rotations);
	}

	public String toString() {
		return StringUtils.getFormattedValue(getValue(), 4) + this.getUnit();
	}
}
