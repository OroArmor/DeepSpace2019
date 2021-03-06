package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;
import org.usfirst.frc.team2412.robot.commands.climb.ClimbLiftJoystick;
import org.usfirst.frc.team2412.robot.sensors.MaxBotixSonar;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimbLiftSubsystem extends Subsystem {

	private MaxBotixSonar ultraSoundRadar = RobotMap.ultraSoundRadar;
	private DigitalInput limitSwitchClimbForward = RobotMap.limitSwitchClimbForward;
	private DigitalInput limitSwitchClimbReverse = RobotMap.limitSwitchClimbReverse;
	private VictorSP victorSP1 = RobotMap.victorSP1;
	private VictorSP victorSP2 = RobotMap.victorSP2;

	public double liftSpeed = 1;
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ClimbLiftJoystick());
	}

	public void ClimbLiftForward() {
		System.out.println("foward");
		victorSP1.set(liftSpeed);
		victorSP2.set(liftSpeed);
	}

	public void ClimbLiftReverse() {
		System.out.println("reverse");
		victorSP1.set(-liftSpeed);
		victorSP2.set(-liftSpeed);
	}

	public void ClimbLiftStop() {
		System.out.println("Released");
		victorSP1.set(0);
		victorSP2.set(0);
	}

	public void ClimbLiftJoystick(Joystick stick, int axis) {
		System.out.println("Climb lift joystick...");
		double LiftSpeed = stick.getRawAxis(axis);
		victorSP1.set(LiftSpeed);
		victorSP1.set(LiftSpeed);
	}

	public double ultraSoundRadar() {
		return ultraSoundRadar.getInches();
	}

	public boolean limitSwitchClimbReverse() {
		return limitSwitchClimbReverse.get();
	}

	public boolean limitSwitchClimbForward() {
		return limitSwitchClimbForward.get();
	}
}