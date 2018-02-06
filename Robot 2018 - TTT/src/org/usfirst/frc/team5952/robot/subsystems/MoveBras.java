/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5952.robot.Robot;
import edu.wpi.first.wpilibj.Talon;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class MoveBras extends Subsystem {
	private Talon _brasMotor;
	
	public MoveBras(int port) {
		_brasMotor = new Talon(port);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void monter() {
		_brasMotor.set(1);
	}
	public void arreter() {
		_brasMotor.set(0);
	}
	public void descendre() {
		_brasMotor.set(-1);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
