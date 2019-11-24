package com.robototes.units;

import com.robototes.units.UnitTypes.IUnitType;
import com.robototes.units.UnitTypes.VoltageUnits;
import com.robototes.utils.StringUtils;

public class UsefulUnits {
	/**
	 * Representation of volts in the program
	 * 
	 * @author OroArmor
	 *
	 */
	public static class Voltage implements IUnit<Voltage> {

		/**
		 * voltage of the unit
		 */
		public double voltage;
		/**
		 * the main unit
		 */
		public static VoltageUnits mainUnit = VoltageUnits.VOLTS;

		/**
		 * Creates a voltage with a volt value
		 * 
		 * @param value the voltage
		 */
		public Voltage(double value) {
			this.voltage = value;
		}

		/**
		 * Creates a voltage with any unit
		 * 
		 * @param value    volts of the unit
		 * @param unitType type of the unit
		 */
		public Voltage(double value, VoltageUnits unitType) {
			this(unitType.getRatio().calculateRatio(value));
		}

		@Override
		public Voltage add(Voltage other) {
			return new Voltage(this.voltage + other.voltage);
		}

		@Override
		public Voltage subtract(Voltage other) {
			return new Voltage(this.voltage - other.voltage);
		}

		@Override
		public double getValue() {
			return voltage;
		}

		@Override
		public String getUnit() {
			return mainUnit.getUnit();
		}

		@Override
		public Voltage divide(Voltage other) {
			return new Voltage(this.voltage / other.voltage);
		}

		@Override
		public Voltage multiply(Voltage other) {
			return new Voltage(this.voltage * other.voltage);
		}

		@Override
		public <K extends IUnitType<K>> double convertTo(K unitType) {
			return unitType.getRatio().calculateReverseRatio(this);
		}

		public String toString() {
			return StringUtils.getFormattedValue(getValue(), 4) + this.getUnit();
		}

	}
}
