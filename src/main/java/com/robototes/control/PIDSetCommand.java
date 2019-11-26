package com.robototes.control;

import com.robototes.motors.PIDMotorController;
import com.robototes.units.IUnit;
import com.robototes.units.Distance;

import edu.wpi.first.wpilibj.command.Command;

public class PIDSetCommand<T extends PIDMotorController<?>, K extends IUnit<K>> extends Command {
	private PIDSubsystem<T, K> PIDSubsystem;
	private K setPositionUnit;
	private double howCloseMustItBe;

	public PIDSetCommand(PIDSubsystem<T, K> PIDSubsystem, K setPositionUnit, double howCloseMustItBe) {
		this.PIDSubsystem = PIDSubsystem;
		this.setPositionUnit = setPositionUnit;
		this.howCloseMustItBe = howCloseMustItBe;
		System.out.println("created");
	}

	@Override
	protected void initialize() {
		System.out.println("init");
		PIDSubsystem.setReference(setPositionUnit);
	}

	@Override
	public void execute() {
		System.out.println("execute");
		PIDSubsystem.usePID();
	}

	public void end(){
		PIDSubsystem.setMotorSpeed(0);
	}

	@Override
	protected boolean isFinished() {
		K error = PIDSubsystem.getError();
		boolean finished = (Math.abs(error.subtract(setPositionUnit).getValue()) < howCloseMustItBe);
		return finished;
	}
}
