package org.usfirst.frc.team2412.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
	// Lift subsystem
//	public static LiftSubsystem liftSubsystem = new LiftSubsystem(new DistanceSubsystem(RobotMap.liftMotors, null));

	@Override
	protected boolean isFinished() {
		return false;
	}
}
