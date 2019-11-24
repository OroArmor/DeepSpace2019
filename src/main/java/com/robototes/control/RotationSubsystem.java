package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.RotationUnits;

public class RotationSubsystem<T extends PIDMotorController<?>> implements PIDSubsystem<T, Rotations> {

	private T[] motors;
	private InterUnitRatio<RotationUnits, RotationUnits> rotationsToDistance;
	private Rotations currentReference = new Rotations(0);

	RotationSubsystem(T[] motors, InterUnitRatio<RotationUnits, RotationUnits> ratio) {
		this.motors = motors;
		this.rotationsToDistance = ratio;
	}

	@Override
	public void setReference(Rotations reference) {
		currentReference = reference;
		Rotations rotationReference = new Rotations(rotationsToDistance.calculateReverseRatio(reference));
		for (T motor : motors) {
			motor.setRotations(rotationReference);
		}
	}

	@Override
	public Rotations getError() {
		Rotations totalDistance = new Rotations(0);
		for (T motor : motors) {
			totalDistance.add(new Rotations(rotationsToDistance.calculateReverseRatio(motor.getRotations())));
		}
		totalDistance.divide(new Rotations(motors.length));
		return currentReference.subtract(totalDistance);
	}

	@Override
	public T[] getMotors() {
		return motors;
	}

	@Override
	public void addRefecence(Rotations addRefernce) {
		currentReference = currentReference.add(addRefernce);
		Rotations rotationReference = new Rotations(rotationsToDistance.calculateReverseRatio(currentReference));
		for (T motor : motors) {
			motor.setRotations(rotationReference);
		}
	}

	@Override
	public void usePID() {
		for (T motor : motors) {
			motor.usePIDOutput();
		}
	}

	@Override
	public void setMotorSpeed(double speed) {
		for (T motor : motors) {
			motor.setSpeed(speed);
		}
	}
}
