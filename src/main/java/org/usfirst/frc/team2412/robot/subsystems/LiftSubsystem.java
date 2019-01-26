package org.usfirst.frc.team2412.robot.subsystems;

import org.usfirst.frc.team2412.robot.RobotMap;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {

	// other vars that are useful

	double inchOffset = 19; // this is the offset for the lift, as it doesnt go lower than the top hatch,
							// and this makes the robot go to x inches above the ground

	double topLimit = 100; // this will prevent the robot from going too high
	
	// inches
	double outputGearRadius = 6;
	double outputGearCircumference = outputGearRadius * 2 * Math.PI;
	double pullyRatio = 1; // one inch on string moves the lift up x inches

	// rotations
	double gearboxRatio = 10; // how many motor rotations are one output rotation

	double motorRotationsToInches = outputGearCircumference * pullyRatio / gearboxRatio;

	CANSparkMax liftMotorLeader = RobotMap.liftMotors[0]; // Motors from RobotMap
	CANPIDController PIDController = liftMotorLeader.getPIDController();
	CANEncoder motorEncoder = liftMotorLeader.getEncoder();

	double P = 1;
	double I = 0;
	double D = 0;

	public LiftSubsystem() {
		PIDController.setP(P);
		PIDController.setI(I);
		PIDController.setD(D);
		PIDController.setOutputRange(-1, 1);
	}

	@Override
	protected void initDefaultCommand() {

	}

	public double getRotationsFromInch(double inches) {
		return inches / motorRotationsToInches;
	}

	public void liftUp() {
		if(motorEncoder.getPosition() > topLimit) {
			liftMotorLeader.set(0);
			return;
		}
		liftMotorLeader.set(0.5);
	}

	public void liftDown() {
		if(motorEncoder.getPosition() < 0) {
			liftMotorLeader.set(0);
			return;
		}
		liftMotorLeader.set(-0.5);
	}

	// These will use a PID (loop? idk what exactly it is) to quickly get the lift
	// to the best position

	public void hatch1() { // bottom hatch
		PIDController.setReference(getRotationsFromInch(19 - inchOffset), ControlType.kPosition);
	}

	public void hatch2() { // middle hatch
		PIDController.setReference(getRotationsFromInch(47 - inchOffset), ControlType.kPosition);
	}

	public void hatch3() { // top hatch
		PIDController.setReference(getRotationsFromInch(75 - inchOffset), ControlType.kPosition);
	}

	public void cargo1() { // bottom cargo
		PIDController.setReference(getRotationsFromInch(27.5 - inchOffset), ControlType.kPosition);
	}

	public void cargo2() { // middle cargo (maybe cargoship)
		PIDController.setReference(getRotationsFromInch(55.5 - inchOffset), ControlType.kPosition);
	}

	public void cargo3() { // top cargo
		PIDController.setReference(getRotationsFromInch(83.5 - inchOffset), ControlType.kPosition);
	}
}
