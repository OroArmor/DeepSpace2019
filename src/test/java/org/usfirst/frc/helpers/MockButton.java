package org.usfirst.frc.helpers;

import edu.wpi.first.wpilibj.buttons.Button;

public class MockButton extends Button {

	private boolean pushed = false;

	@Override
	public boolean get() {
		// TODO Auto-generated method stub
		return pushed;
	}

	public void push() {
		pushed = true;
	}

	public void release() {
		pushed = false;
	}
}
