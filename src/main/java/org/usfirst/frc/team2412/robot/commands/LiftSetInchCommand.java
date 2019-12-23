package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.subsystems.LiftConstants;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem.LiftHeights;

import com.robototes.control.UsePIDSetCommand;
import com.robototes.units.Distance;

public class LiftSetInchCommand extends UsePIDSetCommand<Distance> {
	// Takes in a LiftHeight, and getting the inch value from that, making it hard
	// to break the robot
	public LiftSetInchCommand(LiftSubsystem liftSubsystem, LiftHeights setPositionUnit, double howCloseMustItBe) {
		super(liftSubsystem.liftDistanceSubsystem, setPositionUnit.getInch().subtract(LiftConstants.inchOffset),
				howCloseMustItBe);
	}

}
