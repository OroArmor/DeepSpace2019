package org.usfirst.frc.team2412.robot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revrobotics.CANSparkMax;
import com.robototes.units.Distance;

import edu.wpi.first.wpilibj.Talon;

public class PIDCanSparkMaxTest {

	static {
		System.loadLibrary("ntcorejni");
	}

	@Test
	public void testPIDCanSparkMax() {
		System.out.println("Asdf");

		try (Talon motor = mock(Talon.class);) {
//			motor.setSpeed(1);
//			verify(motor, times(1)).setSpeed(1);
			System.out.println("asdf");
		} catch (Exception e) {
//			e.printStackTrace();
		}
		System.out.println("asdf");
	}

//	@Test
//	public void testAddRotationsRotations() {
//	}
//
//	@Test
//	public void testAddRotationsSparkMaxRotations() {
//	}
//
//	@Test
//	public void testGetRotations() {
//	}
//
//	@Test
//	public void testSetRotationsRotations() {
//	}
//
//	@Test
//	public void testSetRotationsSparkMaxRotations() {
//	}
//
//	@Test
//	public void testSetSpeed() {
//	}
//
//	@Test
//	public void testUsePIDOutput() {
//	}
//
//	@Test
//	public void testUsePIDOutputTime() {
//	}

}
