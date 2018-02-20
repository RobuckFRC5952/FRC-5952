/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Lift extends SingleMotor {
	private DigitalInput _topSwitch;
	private DigitalInput _bottomSwitch;
	
	public Lift(String name, int motorPort, int encoderPort1, int encoderPort2, double distancePerPulse, int topLimitSwitchChannel, int bottomlimitSwitchChannel) {
		super(name, motorPort, encoderPort1, encoderPort2, distancePerPulse);
		
		_topSwitch =  new DigitalInput(topLimitSwitchChannel);
		_bottomSwitch =  new DigitalInput(bottomlimitSwitchChannel);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	@Override
	public void move(double speed) {
		if(_topSwitch.get() || _bottomSwitch.get())
		{
			stop();
			return;
		}

		super.move(speed);
	}

    public void log() {
    	super.log();
    	    	
    	SmartDashboard.putBoolean("topSwitch", _topSwitch.get());
    	SmartDashboard.putBoolean("bottomSwitch", _bottomSwitch.get());
    }
}
