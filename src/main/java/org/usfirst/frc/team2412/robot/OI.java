/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.LiftSetInchCommand;

import com.robototes.units.Distance;
import com.robototes.units.UnitTypes.DistanceUnits;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	Joystick driver = new Joystick(0);
	Button trigger = new JoystickButton(driver, 0);

	public OI() {
		trigger.whenPressed(new LiftSetInchCommand(new Distance(30, DistanceUnits.INCH), 0.1));
	}

}
