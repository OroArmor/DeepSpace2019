package com.robototes.motors;

import com.robototes.units.Rotations;

public abstract class MotorRotations extends Rotations {
	public MotorRotations(double value) {
		super(value);
	}

	public MotorRotations(Rotations rotations) {
		super(rotations.getValue());
	}

	public static class SparkMaxRotations extends MotorRotations {
		public SparkMaxRotations(double value) {
			super(value);
		}

		public SparkMaxRotations(Rotations rotations) {
			super(rotations);
		}
	}
}
