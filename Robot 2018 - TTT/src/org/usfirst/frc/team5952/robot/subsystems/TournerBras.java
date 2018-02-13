package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class TournerBras extends Subsystem {
	private Talon _brasMotor;

	public TournerBras(int port) {
		_brasMotor = new Talon(port);
	}

	public void monter() {
		_brasMotor.set(0.2);
	}
	public void arreter() {
		_brasMotor.set(0);
	}
	public void descendre() {
		_brasMotor.set(-0.2);
	}

	public void initDefaultCommand() { }
}
