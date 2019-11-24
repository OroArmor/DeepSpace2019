package com.robototes.motors;

import com.robototes.units.Rotations;
import com.robototes.units.Time;

public interface PIDMotorController<T extends MotorRotations> {

	public double usePIDOutput();

	public double usePIDOutput(Time timestep);

	public T getRotations();

	public void setRotations(Rotations rotationReference);

	public void setRotations(T rotations);

	public void addRotations(Rotations rotationReference);

	public void addRotations(T rotations);

	public void setSpeed(double speed);
}
