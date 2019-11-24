package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.Command;

public class PIDSetCommand<T extends PIDMotorController<?>, K extends IUnit<K>> extends Command {
	private PIDSubsystem<T, K> PIDSubsystem;
	private K setPositionUnit;
	private double howCloseMustItBe;

	public PIDSetCommand(PIDSubsystem<T, K> PIDSubsystem, K setPositionUnit, double howCloseMustItBe) {
		this.PIDSubsystem = PIDSubsystem;
		this.setPositionUnit = setPositionUnit;
		this.howCloseMustItBe = howCloseMustItBe;
	}

	@Override
	protected void initialize() {
		PIDSubsystem.setReference(setPositionUnit);
	}

	@Override
	public void execute() {
		PIDSubsystem.usePID();
	}

	@Override
	protected boolean isFinished() {
		return (PIDSubsystem.getError().subtract(setPositionUnit).getValue() < howCloseMustItBe);
	}
}
