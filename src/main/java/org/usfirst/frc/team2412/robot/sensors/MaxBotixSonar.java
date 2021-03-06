package org.usfirst.frc.team2412.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

public class MaxBotixSonar extends SendableBase {

	private AnalogInput channel;
	private static final double RAW_TO_INCHES = 1.0 / 0.0227511;

	public MaxBotixSonar(int port) {
		channel = new AnalogInput(port);
	}

	@Override
	public void initSendable(SendableBuilder builder) {
	}

	public double getRawDistance() {
		return channel.getVoltage();
	}

	public double getInches() {
		return getRawDistance() * RAW_TO_INCHES + 0.0336679;
	}

	public void close() {
		channel.close();
	}
}
