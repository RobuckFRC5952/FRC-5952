/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import org.usfirst.frc.team5952.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	public DifferentialDrive drive;
	private Talon _leftMotor;
	private Talon _rightMotor;

	public DriveTrain(int port1, int port2) {
		_leftMotor = new Talon(port1);
		_rightMotor = new Talon(port2);
		drive = new DifferentialDrive(_leftMotor, _rightMotor);
	}
	
	public void initDefaultCommand() {
	}
}
