/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class CableWinch extends Subsystem {
	private Spark _motor;
	public Encoder _encoder;

	public CableWinch(int motorPort, int encoderPort1, int encoderPort2, double distancePerPulse) {
		_motor = new Spark(motorPort);
		_encoder = new Encoder(encoderPort1, encoderPort2);
		
		_encoder.setDistancePerPulse(distancePerPulse);
	}
	
	public double getSpeed() {
		return _motor.get();
	}
	
	public void move(double speed) {
		_motor.set(speed);
	}
		
	public void stop() {
		_motor.set(0);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public double getDistance() {
		return _encoder.getDistance();
	}
	
	public void reset() {
		_encoder.reset();
	}
	
	public void log() {
		SmartDashboard.putNumber("Cable Distance", getDistance());
		SmartDashboard.putNumber("Cable Speed", _encoder.getRate());
	}
}
