package org.usfirst.frc.team2412.robot.commands.climb;

import org.usfirst.frc.team2412.robot.commands.CommandBase;

public class ClimbLiftReverse extends CommandBase {

	public ClimbLiftReverse() {
		requires(climbLift);
	}

	public void execute() {
		climbLift.ClimbLiftReverse();
		System.out.println("Climb Reverse");
	}

	@Override
	protected boolean isFinished() {
		return climbLift.limitSwitchClimbReverse();
	}

	protected void end() {
		climbLift.ClimbLiftStop();
	}
}
