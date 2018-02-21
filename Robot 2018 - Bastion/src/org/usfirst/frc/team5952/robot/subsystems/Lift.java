/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Lift extends Subsystem {
	private DigitalInput _topSwitch;
	private DigitalInput _bottomSwitch;
	private Talon _motor;
	public Encoder _encoder;
	
	public Lift(int motorPort, 
			int encoderPort1, 
			int encoderPort2, 
			double distancePerPulse, 
			int topLimitSwitchChannel, 
			int bottomlimitSwitchChannel) {
		
		_motor = new Talon(motorPort);
		_encoder = new Encoder(encoderPort1, encoderPort2);
		
		_encoder.setDistancePerPulse(distancePerPulse);
		
		_topSwitch =  new DigitalInput(topLimitSwitchChannel);
		_bottomSwitch =  new DigitalInput(bottomlimitSwitchChannel);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void move(double speed) {
		if(_topSwitch.get() || _bottomSwitch.get())
		{
			stop();
			return;
		}

		_motor.set(speed);
	}
	
	public void stop() {
		_motor.set(0);
	}

	public double getDistance() {
		return _encoder.getDistance();
	}
	
	public void reset() {
		_encoder.reset();
	}
	
    public void log() {
		SmartDashboard.putNumber("Lift Distance", getDistance());
		SmartDashboard.putNumber("Lift Speed", _encoder.getRate());
    	SmartDashboard.putBoolean("Lift Max", _topSwitch.get());
    	SmartDashboard.putBoolean("Lift Min", _bottomSwitch.get());
    }
}
