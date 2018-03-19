/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5952.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Lift extends Subsystem {
	private Talon _motor;
	public Encoder _encoder;
	
	public Lift() {
		_motor = new Talon(RobotMap.liftMotor);
		_encoder = new Encoder(RobotMap.liftEncoder1, RobotMap.liftEncoder2);
		
		_encoder.setDistancePerPulse(RobotMap.distancePerPulse);
	}
	
	public void initDefaultCommand() {
	}
	
	public void move(double speed) {
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
    }
}
