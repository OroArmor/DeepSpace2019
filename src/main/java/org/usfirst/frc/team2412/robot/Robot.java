package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.CommandBase;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {

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
		m_oi = new OI();
		System.out.println(CommandBase.liftSubsystem.motorRotationsToInches);
		System.out.println(LiftSubsystem.LiftHeights.HATCH1.getInch());
		// Have the second lift motor follow the first motor
		RobotMap.liftMotors[1].follow(RobotMap.liftMotors[0]);
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
