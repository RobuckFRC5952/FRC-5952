/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExtendBras extends Subsystem {
	private Solenoid _extendBras;

	public ExtendBras(int port) {
		_extendBras = new Solenoid(port);
	}
	
	public void initDefaultCommand(){
	}
	
	public void extend() {
		_extendBras.set(true);
	}
	
	public void retract() {
		_extendBras.set(false);
	}
	
	public boolean isOpen() {
		return _extendBras.get();
	}
}
