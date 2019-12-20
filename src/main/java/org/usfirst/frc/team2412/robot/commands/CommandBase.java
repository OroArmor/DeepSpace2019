package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.RobotMap;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;

import com.robototes.control.DistanceSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class CommandBase extends Command {
	// Lift subsystem
	public static LiftSubsystem liftSubsystem = new LiftSubsystem(new DistanceSubsystem(RobotMap.liftMotors, null));

	@Override
	protected boolean isFinished() {
		return false;
	}
}
