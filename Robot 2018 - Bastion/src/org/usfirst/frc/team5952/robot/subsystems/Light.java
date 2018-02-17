/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import org.usfirst.frc.team5952.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Light extends Subsystem {
	private Relay _light;
	
	public Light(int lightPort) {
		_light = new Relay(lightPort);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void open(){
		_light.set(Relay.Value.kForward);
    }
	
	public void reverse(){
		_light.set(Relay.Value.kReverse);
    }
    
    public void close(){
    	_light.set(Relay.Value.kOff);
    }
}
