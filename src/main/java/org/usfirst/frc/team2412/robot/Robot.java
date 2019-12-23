package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.CommandBase;
import org.usfirst.frc.team2412.robot.subsystems.LiftConstants;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;

import com.robototes.control.DistanceSubsystem;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {

	public static LiftSubsystem liftSubsystem;

	// OI for the robot
	public static OI m_oi;

	// Create a command base to house instances of each subsystem
	CommandBase base = new CommandBase();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		// Create an new OI

		liftSubsystem = new LiftSubsystem(
				new DistanceSubsystem(RobotMap.liftMotors, LiftConstants.motorRotationsToInches));

		m_oi = new OI();
	}

	// Called periodically in sandstorm or teleop.
	public void controlledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		controlledPeriodic();
	}
}
