package com.robototes.control;

import com.robototes.units.IUnit;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A Command Class that allows for easier use of PIDSubsystems, this command
 * uses the .addReference() method of PIDSubsyste,
 * 
 * @author OroArmor
 *
 * @param <T> Unit of the Subsystem
 */
public class PIDAddCommand<T extends IUnit<T>> extends Command {
	private PIDSubsystem<?, T> PIDSubsystem;
	private T addPositionUnit;
	private T initialUnitPosition;
	private double howCloseMustItBe;

	public PIDAddCommand(PIDSubsystem<?, T> PIDSubsystem, T addPositionUnit, double howCloseMustItBe) {
		this.PIDSubsystem = PIDSubsystem;
		this.addPositionUnit = addPositionUnit;
		this.howCloseMustItBe = howCloseMustItBe;
	}

	@Override
	protected void initialize() {
		initialUnitPosition = PIDSubsystem.getError();
		PIDSubsystem.addRefecence(addPositionUnit);
	}

	@Override
	public void execute() {
		PIDSubsystem.usePID();
	}

	@Override
	protected boolean isFinished() {
		return (PIDSubsystem.getError().subtract(initialUnitPosition.add(addPositionUnit))
				.getValue() < howCloseMustItBe);
	}
}
