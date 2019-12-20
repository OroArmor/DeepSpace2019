package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.subsystems.LiftConstants;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.robototes.motors.PIDCanSparkMax;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	// Can IDs of the lift motors
	public static int[] liftMotorIndexes = { 7, 8 };

	// Lift motors
	public static PIDCanSparkMax[] liftMotors = {
			new PIDCanSparkMax(liftMotorIndexes[0], MotorType.kBrushless, LiftConstants.motorConstants),
			new PIDCanSparkMax(liftMotorIndexes[1], MotorType.kBrushless, LiftConstants.motorConstants) };

}
