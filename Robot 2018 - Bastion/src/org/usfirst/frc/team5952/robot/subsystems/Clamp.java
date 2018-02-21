/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import org.usfirst.frc.team5952.robot.Robot;
import org.usfirst.frc.team5952.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Clamp extends Subsystem {
	private Solenoid _clampUpDown;
	private Solenoid _clampOpenClose;
	
	public Clamp(int port1, int port2) {
		_clampUpDown = new Solenoid(port1);
		_clampOpenClose = new Solenoid(port2);
	}
	
	public void initDefaultCommand() {

	}
	
	public void open(boolean open) {
		_clampOpenClose.set(open);
	}
	
	public void enable(boolean on) {
		if(Robot.lift.getDistance() >= RobotMap.clampHeightEnableHigh || 
				Robot.lift.getDistance() <= RobotMap.clampHeightEnableLow ) {
			
		}
		_clampUpDown.set(on);
	}
	
	public void log() {
		SmartDashboard.putBoolean("ClampOpen", _clampOpenClose.get());
		SmartDashboard.putBoolean("ClampUp", _clampUpDown.get());
	}
}
