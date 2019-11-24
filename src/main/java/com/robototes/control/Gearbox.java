package com.robototes.control;

import com.robototes.units.InterUnitRatio;
import com.robototes.units.UnitTypes.RotationUnits;
import com.robototes.units.Rotations;

public class Gearbox {

	private InterUnitRatio<RotationUnits, RotationUnits> ratio;

	public Gearbox(Rotations inputRotations, double gearboxRatio, Rotations outputRotations) {
		ratio = new InterUnitRatio<RotationUnits, RotationUnits>(Rotations.mainUnit, gearboxRatio, Rotations.mainUnit);
	}

	public Gearbox(Gearbox one, Gearbox two) {
		ratio = new InterUnitRatio<RotationUnits, RotationUnits>(one.ratio, two.ratio);
	}

	public InterUnitRatio<RotationUnits, RotationUnits> getRatio() {
		return ratio;
	}

}
