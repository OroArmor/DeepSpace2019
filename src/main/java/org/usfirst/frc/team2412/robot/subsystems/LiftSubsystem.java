package org.usfirst.frc.team2412.robot.subsystems;

import com.robototes.control.DistanceSubsystem;
import com.robototes.units.Distance;
import com.robototes.units.UnitTypes.DistanceUnits;

import edu.wpi.first.wpilibj.command.Subsystem;

// Subsystem that controls the Lift of the robot
public class LiftSubsystem extends Subsystem {

	// Subsystem
	// The subsystem in charge of PID control
	public DistanceSubsystem liftDistanceSubsystem;

	// Constructor, no parameters are needed
	public LiftSubsystem(DistanceSubsystem liftDistanceSubsystem) {
		this.liftDistanceSubsystem = liftDistanceSubsystem;
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
		double inches = liftDistanceSubsystem.getError().add(LiftConstants.inchOffset).convertTo(DistanceUnits.INCH);
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
