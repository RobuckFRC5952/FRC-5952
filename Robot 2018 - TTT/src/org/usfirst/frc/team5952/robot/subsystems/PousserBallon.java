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
public class PousserBallon extends Subsystem {
	private Solenoid _piston;
	
	public PousserBallon (int port) { 
		_piston = new Solenoid(port);
	}	
	
	public void retracter() {
		_piston.set(false);
	}
	
	public void etendre() {
		_piston.set(true);
	}

	public boolean isOpen() {
		return _piston.get(); 
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
