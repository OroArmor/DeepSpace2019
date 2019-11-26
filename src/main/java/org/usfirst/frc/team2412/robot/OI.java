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
	Button trigger = new JoystickButton(driver, 1);

	Button cargo1 = new JoystickButton(driver, 11);
	Button cargo2 = new JoystickButton(driver, 9);
	Button cargo3 = new JoystickButton(driver, 7);
	
	Button hatch1 = new JoystickButton(driver, 12);
	Button hatch2 = new JoystickButton(driver, 10);
	Button hatch3 = new JoystickButton(driver, 8);

	public OI() {
		// trigger.whenPressed(new LiftSetInchCommand(new Distance(65, DistanceUnits.INCH), 0.01));

		cargo1.whenPressed(new LiftSetInchCommand(new Distance(27.5, DistanceUnits.INCH), 0.01));
		cargo2.whenPressed(new LiftSetInchCommand(new Distance(27.5+28*2, DistanceUnits.INCH), 0.01));
		cargo3.whenPressed(new LiftSetInchCommand(new Distance(27.5+28*3, DistanceUnits.INCH), 0.01));

		hatch1.whenPressed(new LiftSetInchCommand(new Distance(19, DistanceUnits.INCH), 0.01));
		hatch2.whenPressed(new LiftSetInchCommand(new Distance(19+28*2, DistanceUnits.INCH), 0.01));
		hatch3.whenPressed(new LiftSetInchCommand(new Distance(19+28*3, DistanceUnits.INCH), 0.01));
	}

}
