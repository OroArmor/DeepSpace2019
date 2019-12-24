package org.usfirst.frc.helpers;

import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * Extend this class when your test requires commands or command groups to be
 * exercised with the full WPI scheduler. Use
 * {@link SchedulerPumpHelper#runForDuration(int, int...)} to pump the
 * scheduler.
 */
public class TestWithScheduler {

	public static void schedulerStart() {
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().enable();
	}

	public static void schedulerClear() {
		Scheduler.getInstance().removeAll();
	}

	public static void schedulerDestroy() {
		Scheduler.getInstance().disable();
		Scheduler.getInstance().close();
	}
}