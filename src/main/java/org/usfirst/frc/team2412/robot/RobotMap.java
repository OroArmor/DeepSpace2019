package org.usfirst.frc.team2412.robot;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.robototes.PIDControls.PIDConstants;
import com.robototes.motors.PIDCanSparkMax;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {

	static double P = 0.015;
	static double I = 0;
	static double D = 0;

	static PIDConstants liftConstants = new PIDConstants(P, I, D, 0);

	public static int[] liftMotorIndexes = { 7, 8 };

	public static PIDCanSparkMax[] liftMotors = {
			new PIDCanSparkMax(liftMotorIndexes[0], MotorType.kBrushless, liftConstants),
			new PIDCanSparkMax(liftMotorIndexes[1], MotorType.kBrushless, liftConstants) };

}
