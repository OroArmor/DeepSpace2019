package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {

	public static OI m_oi;

	CommandBase base = new CommandBase();

	public static long startTime = 0;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		RobotMap.liftMotors[1].follow(RobotMap.liftMotors[0]);
	}

	// Called periodically in sandstorm or teleop.
	public void controlledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		controlledPeriodic();
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		controlledPeriodic();
	}

}
