package org.usfirst.frc.team2412.robot.commands;

import com.robototes.control.DistanceSubsystem;
import com.robototes.control.PIDSetCommand;
import com.robototes.motors.PIDCanSparkMax;
import com.robototes.units.Distance;

public class LiftSetInchCommand extends PIDSetCommand<Distance> {
	static DistanceSubsystem<PIDCanSparkMax> PIDSubsystem = CommandBase.liftSubsystem.liftDistanceSubsystem;

	public LiftSetInchCommand(Distance setPositionUnit, double howCloseMustItBe) {
		super(PIDSubsystem, setPositionUnit, howCloseMustItBe);
	}

}
