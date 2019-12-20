package org.usfirst.frc.team2412.robot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc.team2412.robot.subsystems.LiftConstants;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;

import com.robototes.control.DistanceSubsystem;
import com.robototes.math.MathUtils;
import com.robototes.motors.MotorRotations;
import com.robototes.units.Distance;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;

public class LiftSubsystemTest {

	static {
		System.loadLibrary("ntcorejni");
	}

	LiftSubsystem liftSubsystem;

	@Before
	public void setupTest() {
		liftSubsystem = new LiftSubsystem(mock(DistanceSubsystem.class));
	}

	@Test
	public void testLiftSubsystemRatio() {

		// Old Lift values and ratio
		double outputGearRadius = 0.75 * 2.54 / 100;
		double outputGearCircumference = outputGearRadius * 2 * Math.PI;
		double pullyRatio = 2;
		double gearboxRatio = 9.52;
		double motorRotationsToInches = outputGearCircumference * pullyRatio / gearboxRatio;

		// Ratio
		InterUnitRatio<RotationUnits, DistanceUnits> correctRatio = new InterUnitRatio<RotationUnits, DistanceUnits>(
				RotationUnits.ROTATION, motorRotationsToInches, DistanceUnits.INCH);

		// Setting the correct unit for the ratio
		correctRatio.from = new MotorRotations.SparkMaxRotations(0).getUnit();

		assertEquals("Make sure that lift ratio is correct", correctRatio, LiftConstants.motorRotationsToInches);

	}

	@Test
	public void setLiftSubsystemSetsCorrectBasicSpeeds() {
		// Make sure that the basic calls to speed are set correctly
		liftSubsystem.liftUp();
		liftSubsystem.liftDown();
		liftSubsystem.liftStop();

		// Lift up
		verify(liftSubsystem.liftDistanceSubsystem, times(1)).setMotorSpeed(LiftConstants.MAX_UP_SPEED);
		// Lift down
		verify(liftSubsystem.liftDistanceSubsystem, times(1)).setMotorSpeed(LiftConstants.MAX_DOWN_SPEED);
		// Lift stop
		verify(liftSubsystem.liftDistanceSubsystem, times(1)).setMotorSpeed(0);
	}

	@Test
	public void testLiftGetsCorrectInches() {
		Distance fakeLiftDistance = new Distance(30, DistanceUnits.INCH);

		when(liftSubsystem.liftDistanceSubsystem.getError()).thenReturn(fakeLiftDistance);

		assertEquals("Lift returns correct distance", fakeLiftDistance.getValue(),
				liftSubsystem.getInches() - LiftConstants.inchOffset.getValue(), MathUtils.EPSILON);

		liftSubsystem.close();
	}

}
