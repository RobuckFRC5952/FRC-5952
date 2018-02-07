/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import org.usfirst.frc.team5952.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	public DifferentialDrive drive;
	private Spark _leftMotor, _rightMotor;
	public Encoder _leftEncoder, _rightEncoder;
	
	public DriveTrain(int port1, int port2) {
		_leftMotor = new Spark(port1);
		_rightMotor = new Spark(port2);
		
		_leftEncoder = new Encoder(RobotMap.leftEncoder1, RobotMap.leftEncoder2);
		_rightEncoder = new Encoder(RobotMap.rightEncoder1, RobotMap.rightEncoder2);
		
		_leftEncoder.setDistancePerPulse(RobotMap.distancePerPulse);
		_rightEncoder.setDistancePerPulse(RobotMap.distancePerPulse);
		
		drive = new DifferentialDrive(_leftMotor, _rightMotor);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public double getDistance() {
		return (_leftEncoder.getDistance() + _rightEncoder.getDistance())/2;
	}
	
	public void reset() {
		_leftEncoder.reset();
		_rightEncoder.reset();
	}
	
	public void log() {
		SmartDashboard.putNumber("RunDistance", getDistance());
		SmartDashboard.putNumber("LeftSpeed", _leftEncoder.getRate());
		SmartDashboard.putNumber("RightSpeed", _rightEncoder.getRate());
	}
}
