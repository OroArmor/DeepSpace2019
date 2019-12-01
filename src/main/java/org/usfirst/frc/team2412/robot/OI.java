/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2412.robot;

import org.usfirst.frc.team2412.robot.commands.LiftSetInchCommand;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem.LiftHeights;

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
		cargo1.whenPressed(new LiftSetInchCommand(LiftHeights.CARGO1, 0.1));
		cargo2.whenPressed(new LiftSetInchCommand(LiftHeights.CARGO2, 0.1));
		cargo3.whenPressed(new LiftSetInchCommand(LiftHeights.CARGO3, 0.1));

		hatch1.whenPressed(new LiftSetInchCommand(LiftHeights.HATCH1, 0.1));
		hatch2.whenPressed(new LiftSetInchCommand(LiftHeights.HATCH2, 0.1));
		hatch3.whenPressed(new LiftSetInchCommand(LiftHeights.HATCH3, 0.1));
	}

}
