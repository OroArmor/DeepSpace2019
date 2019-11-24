package com.robototes.control;

import com.robototes.math.MathUtils;

import edu.wpi.first.wpilibj.Joystick;

public class JoystickUtils {

	private JoystickUtils() {
	}

	/**
	 * Cubes the values of the joystick
	 * 
	 * @param stick The joystick
	 * @return an array, [X, Y, Twist]
	 */
	public static double[] cubeValues(Joystick stick) {
		return MathUtils.cubeValues(new double[] { stick.getX(), stick.getY(), stick.getTwist() });
	}

}
