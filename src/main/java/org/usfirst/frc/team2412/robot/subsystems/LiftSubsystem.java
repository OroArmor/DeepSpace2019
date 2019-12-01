package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.robototes.control.DistanceSubsystem;
import com.robototes.control.Gearbox;
import com.robototes.motors.MotorRotations;
import com.robototes.motors.PIDCanSparkMax;
import com.robototes.units.Distance;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {

	Distance inchOffset = new Distance(19, DistanceUnits.INCH);
	Distance outputGearRadius = new Distance(0.75, DistanceUnits.INCH);
	Distance outputGearCircumference = outputGearRadius.multiply(new Distance(2 * Math.PI));

	Gearbox liftGearbox = new Gearbox(new MotorRotations.SparkMaxRotations(0), 9.52, new Rotations(0));

	// Ratios
	InterUnitRatio<DistanceUnits, DistanceUnits> pullyRatio = new InterUnitRatio<DistanceUnits, DistanceUnits>(
			DistanceUnits.INCH, 1, DistanceUnits.INCH);

	InterUnitRatio<RotationUnits, DistanceUnits> outputRotationsToOutputGearRadius = new InterUnitRatio<RotationUnits, DistanceUnits>(
			RotationUnits.ROTATION, outputGearCircumference.getValue(), DistanceUnits.INCH);

	InterUnitRatio<RotationUnits, DistanceUnits> outputRotationsToInches = new InterUnitRatio<RotationUnits, DistanceUnits>(
			outputRotationsToOutputGearRadius, pullyRatio);

	public InterUnitRatio<RotationUnits, DistanceUnits> motorRotationsToInches = new InterUnitRatio<RotationUnits, DistanceUnits>(
			liftGearbox.getRatio(), outputRotationsToInches);

	// Subsystem
	public DistanceSubsystem<PIDCanSparkMax> liftDistanceSubsystem = new DistanceSubsystem<PIDCanSparkMax>(
			RobotMap.liftMotors, motorRotationsToInches);

	public LiftSubsystem() {
	}

	public void liftUp() {
		liftDistanceSubsystem.setMotorSpeed(1);
	}

	public void liftDown() {
		liftDistanceSubsystem.setMotorSpeed(-1);
	}

	public void liftStop() {
		liftDistanceSubsystem.setMotorSpeed(0);
	}

	public double getInches() {
		double inches = liftDistanceSubsystem.getError().add(inchOffset).getValue();
		return inches;
	}

	@Override
	protected void initDefaultCommand() {
	}

	public static enum LiftHeights {
		HATCH1(new Distance(19, DistanceUnits.INCH), 1), //
		HATCH2(new Distance(19, DistanceUnits.INCH), 2), //
		HATCH3(new Distance(19, DistanceUnits.INCH), 3), //
		CARGO1(new Distance(27.5, DistanceUnits.INCH), 1), //
		CARGO2(new Distance(27.5, DistanceUnits.INCH), 2), //
		CARGO3(new Distance(27.5, DistanceUnits.INCH), 3); //

		private final Distance increment = new Distance(28, DistanceUnits.INCH);

		public final Distance inch;
		public final int level;

		private LiftHeights(Distance inch, int level) {
			this.inch = inch;
			this.level = level;
		}

		public Distance getInch() {
			return inch.add(increment.multiply(new Distance(level - 1)));
		}
	}
}
