/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class SingleMotor extends Subsystem {
	private String _name;
	private Spark _motor;
	public Encoder _encoder;

	public SingleMotor(String name, int motorPort, int encoderPort1, int encoderPort2, double distancePerPulse) {
		_name = name;
		_motor = new Spark(motorPort);
		_encoder = new Encoder(encoderPort1, encoderPort2);
		
		_encoder.setDistancePerPulse(distancePerPulse);
	}
	
	protected Spark getMotor() {
		return _motor;
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
		SmartDashboard.putNumber(_name + "Distance", getDistance());
		SmartDashboard.putNumber(_name + "Speed", _encoder.getRate());
	}
}
