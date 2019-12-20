package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem.LiftHeights;

import com.robototes.control.DistanceSubsystem;
import com.robototes.control.UsePIDSetCommand;
import com.robototes.units.Distance;

public class LiftSetInchCommand extends UsePIDSetCommand<Distance> {

	// The PID subsystem of the lift subsystem
	static DistanceSubsystem PIDSubsystem = CommandBase.liftSubsystem.liftDistanceSubsystem;

	// Takes in a LiftHeight, and getting the inch value from that, making it hard
	// to break the robot
	public LiftSetInchCommand(LiftHeights setPositionUnit, double howCloseMustItBe) {
		super(PIDSubsystem, setPositionUnit.getInch(), howCloseMustItBe);
	}
}
