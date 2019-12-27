package org.usfirst.frc.team2412.robot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.usfirst.frc.helpers.MockButton;
import org.usfirst.frc.helpers.MockHardwareExtension;
import org.usfirst.frc.helpers.TestWithScheduler;
import org.usfirst.frc.team2412.robot.commands.LiftSetInchCommand;
import org.usfirst.frc.team2412.robot.subsystems.LiftConstants;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem;
import org.usfirst.frc.team2412.robot.subsystems.LiftSubsystem.LiftHeights;

import com.robototes.control.DistanceSubsystem;
import com.robototes.math.MathUtils;
import com.robototes.motors.MotorRotations;
import com.robototes.units.Distance;
import com.robototes.units.InterUnitRatio;
import com.robototes.units.UnitTypes.DistanceUnits;
import com.robototes.units.UnitTypes.RotationUnits;

import edu.wpi.first.wpilibj.command.Scheduler;

public class LiftSubsystemTest extends TestWithScheduler {

	static {
		System.loadLibrary("ntcorejni");
	}

	LiftSubsystem liftSubsystem;

	@Before
	public void setupTest() {
		MockHardwareExtension.beforeAll();
		schedulerStart();
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
	public void testSetLiftSubsystemSetsCorrectBasicSpeeds() {
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

		assertEquals("Lift returns correct distance", fakeLiftDistance.convertTo(DistanceUnits.INCH),
				liftSubsystem.getInches() - LiftConstants.inchOffset.convertTo(DistanceUnits.INCH), MathUtils.EPSILON);
	}

	@Test
	public void testCorrectLiftHeights() {

		// Check if all the heights are correct

		assertEquals("Lift Height cargo 1 is correct", new Distance(27.5, DistanceUnits.INCH),
				LiftHeights.CARGO1.getInch());
		assertEquals("Lift Height cargo 2 is correct", new Distance(55.5, DistanceUnits.INCH),
				LiftHeights.CARGO2.getInch());
		assertEquals("Lift Height cargo 3 is correct", new Distance(83.5, DistanceUnits.INCH),
				LiftHeights.CARGO3.getInch());
		assertEquals("Lift Height hatch 1 is correct", new Distance(19, DistanceUnits.INCH),
				LiftHeights.HATCH1.getInch());
		assertEquals("Lift Height hatch 2 is correct", new Distance(47, DistanceUnits.INCH),
				LiftHeights.HATCH2.getInch());
		assertEquals("Lift Height hatch 3 is correct", new Distance(75, DistanceUnits.INCH),
				LiftHeights.HATCH3.getInch());
	}

	@Test
	public void testLiftSetInchCommand() throws InterruptedException {
		for (LiftHeights height : LiftHeights.values()) { // Loop through all the different set heights

			try (LiftSetInchCommand liftSetCommand = new LiftSetInchCommand(liftSubsystem, height, 0.1);
					MockButton mockButton = new MockButton();) { // Create the button and command in a try so they auto
																	// close

				// Initialize the button and start the command so they actually run
				liftSetCommand.start();
				mockButton.whenPressed(liftSetCommand);

				// "Push" the button and run the Scheduler
				mockButton.push();
				Scheduler.getInstance().run();

				// "Release" the button and run the Scheduler
				mockButton.release();
				Scheduler.getInstance().run();

				// Check if the setReference method was called
				verify(liftSubsystem.liftDistanceSubsystem, times(1))
						.setReference(height.getInch().subtract(LiftConstants.inchOffset));

				// Check if usePID was called
				verify(liftSubsystem.liftDistanceSubsystem, times(1)).usePID();

				// Cancel the command and reset the mock for the next loop
				liftSetCommand.cancel();
				reset(liftSubsystem.liftDistanceSubsystem);
			}
		}
	}

	@After
	public void close() {
		liftSubsystem.close();
		schedulerDestroy();
		MockHardwareExtension.afterAll();
	}
}
