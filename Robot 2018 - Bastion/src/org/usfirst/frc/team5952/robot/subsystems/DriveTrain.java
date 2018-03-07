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
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	private DifferentialDrive drive;
	private Talon _leftMotor, _rightMotor;
	private Encoder _leftEncoder, _rightEncoder;
	
	public DriveTrain() {
		_leftMotor = new Talon(RobotMap.driveTrainMotorLeft);
		_rightMotor = new Talon(RobotMap.driveTrainMotorRight);
		
		_leftEncoder = new Encoder(RobotMap.driveTrainLeftEncoder1, RobotMap.driveTrainLeftEncoder2);
		_rightEncoder = new Encoder(RobotMap.driveTrainRightEncoder1, RobotMap.driveTrainRightEncoder2, true);
		
		_leftEncoder.setDistancePerPulse(RobotMap.distancePerPulse);
		_rightEncoder.setDistancePerPulse(RobotMap.distancePerPulse);
		
		drive = new DifferentialDrive(_leftMotor, _rightMotor);
	}
	
	public void initDefaultCommand() {
		
	}
	
	public void move(double speed, double angle) {
		drive.arcadeDrive(speed, angle);
	}
	
	public void stop() {
		drive.arcadeDrive(0, 0);
	}
	
	public double getDistance() {
		return _rightEncoder.getDistance();
	}
	
	public void reset() {
		_leftEncoder.reset();
		_rightEncoder.reset();
	}
	
	public void log() {
		SmartDashboard.putNumber("LeftMotorSpeed", _leftMotor.get());
		SmartDashboard.putNumber("RightMotorSpeed", _rightMotor.get());
		SmartDashboard.putNumber("RunDistance", getDistance());
		SmartDashboard.putNumber("LeftSpeed enc", _leftEncoder.getRate());
		SmartDashboard.putNumber("RightSpeed enc", _rightEncoder.getRate());
	}
}
