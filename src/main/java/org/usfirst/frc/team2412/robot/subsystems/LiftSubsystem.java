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

// Subsystem that controls the Lift of the robot
public class LiftSubsystem extends Subsystem {

	// Some constants needed
	// Middle of lift gets a minimum of 19 inches above the ground
	public Distance inchOffset = new Distance(19, DistanceUnits.INCH);

	// The radius of the output "gear" is 0.75 inches
	public Distance outputGearRadius = new Distance(0.75, DistanceUnits.INCH);

	// The circumference of the output "gear" is 2*pi*radius
	public Distance outputGearCircumference = outputGearRadius.multiply(new Distance(2 * Math.PI));

	// The gearbox for lift, with a ratio of 9.52
	public Gearbox liftGearbox = new Gearbox(new MotorRotations.SparkMaxRotations(0), 1d / 9.52, new Rotations(0));

	// Ratios
	// One inch of string pulled by the pulley is two inches that lift moves
	public InterUnitRatio<DistanceUnits, DistanceUnits> pullyRatio = new InterUnitRatio<DistanceUnits, DistanceUnits>(
			DistanceUnits.INCH, 2, DistanceUnits.INCH);

	// Each rotation of the output of the gearbox pulls the string by the
	// circumference of the output gear
	public InterUnitRatio<RotationUnits, DistanceUnits> outputRotationsToOutputGearRadius = new InterUnitRatio<RotationUnits, DistanceUnits>(
			RotationUnits.ROTATION, outputGearCircumference.getValue(), DistanceUnits.INCH);

	// The output rotations to the inches lift moves
	public InterUnitRatio<RotationUnits, DistanceUnits> outputRotationsToInches = new InterUnitRatio<RotationUnits, DistanceUnits>(
			outputRotationsToOutputGearRadius, pullyRatio);

	// The input rotations from the motor to the inches lift moves
	public InterUnitRatio<RotationUnits, DistanceUnits> motorRotationsToInches = new InterUnitRatio<RotationUnits, DistanceUnits>(
			liftGearbox.getRatio(), outputRotationsToInches);

	// Subsystem
	// The subsystem in charge of PID control
	public DistanceSubsystem<PIDCanSparkMax> liftDistanceSubsystem = new DistanceSubsystem<PIDCanSparkMax>(
			RobotMap.liftMotors, motorRotationsToInches);

	// Constructor, no parameters are needed
	public LiftSubsystem() {
	}

	// Moves the lift up
	public void liftUp() {
		liftDistanceSubsystem.setMotorSpeed(1);
	}

	// Moves the lift down
	public void liftDown() {
		liftDistanceSubsystem.setMotorSpeed(-1);
	}

	// Stops the lift
	public void liftStop() {
		liftDistanceSubsystem.setMotorSpeed(0);
	}

	// Gets the number of inches from the ground lift currently is
	public double getInches() {
		double inches = liftDistanceSubsystem.getError().add(inchOffset).convertTo(DistanceUnits.INCH);
		return inches;
	}

	// Not used
	@Override
	protected void initDefaultCommand() {
	}

	// Different heights the lift can go to
	public static enum LiftHeights {
		// Bottom hatch level is 19 inches above the ground
		HATCH1(new Distance(19, DistanceUnits.INCH), 1), // Hatch level 1
		HATCH2(new Distance(19, DistanceUnits.INCH), 2), // Hatch level 2
		HATCH3(new Distance(19, DistanceUnits.INCH), 3), // Hatch level 3

		// Bottom cargo level is 27.5 inches above the ground
		CARGO1(new Distance(27.5, DistanceUnits.INCH), 1), // Cargo level 1
		CARGO2(new Distance(27.5, DistanceUnits.INCH), 2), // Cargo level 2
		CARGO3(new Distance(27.5, DistanceUnits.INCH), 3); // Cargo level 3

		// Both cargo and hatches have a distance of 28 inches between the different
		// levels
		private final Distance increment = new Distance(28, DistanceUnits.INCH);

		// Bottom level height
		public final Distance inch;

		// Level of the lift height
		public final int level;

		// Creates a new lift height based on the bottom height and level
		private LiftHeights(Distance inch, int level) {
			this.inch = inch;
			this.level = level;
		}

		// Returns the distance from the ground to the level
		public Distance getInch() {
			return inch.add(increment.multiply(new Distance(level - 1)));
		}
	}
}
