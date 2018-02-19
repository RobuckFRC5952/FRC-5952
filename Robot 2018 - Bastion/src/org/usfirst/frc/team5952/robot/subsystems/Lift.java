/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Lift extends SingleMotor {
	private LimitSwitch _topSwitch;
	private LimitSwitch _bottomSwitch;
	
	public Lift(String name, int motorPort, int encoderPort1, int encoderPort2, double distancePerPulse, int topLimitSwitchChannel, int bottomlimitSwitchChannel) {
		super(name, motorPort, encoderPort1, encoderPort2, distancePerPulse);
		
		_topSwitch =  new LimitSwitch(topLimitSwitchChannel);
		_bottomSwitch =  new LimitSwitch(bottomlimitSwitchChannel);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void move(boolean direction) {
		if(direction && !_topSwitch.isSwitchActive()) {
			getMotor().set(0.3);
		}
		
		if(!direction && !_bottomSwitch.isSwitchActive()) {
			getMotor().set(-0.3);
		}
	}

    public void log() {
    	super.log();
    	    	
    	SmartDashboard.putBoolean("topSwitch", _topSwitch.isTriggered());
    	SmartDashboard.putBoolean("bottomSwitch", _bottomSwitch.isTriggered());
    }
}
