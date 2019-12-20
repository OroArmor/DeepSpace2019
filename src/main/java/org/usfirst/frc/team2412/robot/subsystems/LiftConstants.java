package org.usfirst.frc.team2412.robot.subsystems;

import com.robototes.PIDControls.PIDConstants;
import com.robototes.control.Gearbox;
import com.robototes.motors.MotorRotations;
import com.robototes.units.Distance;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.Rotations;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;

public class LiftConstants {
	// Middle of lift gets a minimum of 19 inches above the ground
	public static Distance inchOffset = new Distance(19, DistanceUnits.INCH);

	// The radius of the output "gear" is 0.75 inches
	public static Distance outputGearRadius = new Distance(0.75, DistanceUnits.INCH);

	// The circumference of the output "gear" is 2*pi*radius
	public static Distance outputGearCircumference = outputGearRadius.multiply(new Distance(2 * Math.PI));

	// The gearbox for lift, with a ratio of 9.52
	public static Gearbox liftGearbox = new Gearbox(new MotorRotations.SparkMaxRotations(0), 1d / 9.52,
			new Rotations(0));

	// Ratios
	// One inch of string pulled by the pulley is two inches that lift moves
	public static InterUnitRatio<DistanceUnits, DistanceUnits> pullyRatio = new InterUnitRatio<DistanceUnits, DistanceUnits>(
			DistanceUnits.INCH, 2, DistanceUnits.INCH);

	// Each rotation of the output of the gearbox pulls the string by the
	// circumference of the output gear
	public static InterUnitRatio<RotationUnits, DistanceUnits> outputRotationsToOutputGearRadius = new InterUnitRatio<RotationUnits, DistanceUnits>(
			RotationUnits.ROTATION, outputGearCircumference.getValue(), DistanceUnits.INCH);

	// The output rotations to the inches lift moves
	public static InterUnitRatio<RotationUnits, DistanceUnits> outputRotationsToInches = new InterUnitRatio<RotationUnits, DistanceUnits>(
			outputRotationsToOutputGearRadius, pullyRatio);

	// The input rotations from the motor to the inches lift moves
	public static InterUnitRatio<RotationUnits, DistanceUnits> motorRotationsToInches = new InterUnitRatio<RotationUnits, DistanceUnits>(
			liftGearbox.getRatio(), outputRotationsToInches);

	// Motor Speeds
	public static double MAX_UP_SPEED = 1;
	public static double MAX_DOWN_SPEED = -1;

	// The PID constants used for lift
	static double P = 0.015;
	static double I = 0;
	static double D = 0;

	// kI_DAMP is set to zero as kI is not used
	public static PIDConstants motorConstants = new PIDConstants(P, I, D, 0);
}
