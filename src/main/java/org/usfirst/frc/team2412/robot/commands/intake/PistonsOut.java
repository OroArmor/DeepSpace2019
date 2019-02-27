package org.usfirst.frc.team2412.robot.commands.intake;

import org.usfirst.frc.team2412.robot.commands.CommandBase;

public class PistonsOut extends CommandBase {
	public PistonsOut() {
		requires(pistonMove);
	}

	public void execute() {
		pistonMove.pistonDown();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
