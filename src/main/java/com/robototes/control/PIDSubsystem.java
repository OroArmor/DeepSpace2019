package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.IUnit;

public interface PIDSubsystem<T extends PIDMotorController<?>, K extends IUnit<K>> {

	public void setReference(K reference);

	public void addRefecence(K addRefernce);

	public K getError();

	public T[] getMotors();

	public void usePID();

	public void setMotorSpeed(double speed);
}
