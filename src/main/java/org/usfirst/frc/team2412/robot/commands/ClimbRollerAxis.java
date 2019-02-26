package org.usfirst.frc.team2412.robot.commands;

import org.usfirst.frc.team2412.robot.OI;
import org.usfirst.frc.team2412.robot.Robot;
import org.usfirst.frc.team2412.robot.RobotMap;

public class ClimbRollerAxis extends CommandBase {

	public ClimbRollerAxis() {
		requires(climbRoller);
	}

	public void execute() {
		// Check if climb mode is enabled - if it is, drive with the main joystick.
		// If not, use the codriver board.
		// This way, it doesn't matter who starts the command as long as we're in the right mode.
		if(RobotMap.CLIMB_MODE) {
			int forwardAxis = 1; // The joystick's y axis - moving the joystick forward will spin the roller forward
			climbRoller.ClimbRollerAxis(Robot.m_oi.stick, forwardAxis);
		} else {
			climbRoller.ClimbRollerAxis(Robot.m_oi.coDriver, OI.MANUAL_AXIS);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		climbRoller.ClimbRollerStop();
	}
}