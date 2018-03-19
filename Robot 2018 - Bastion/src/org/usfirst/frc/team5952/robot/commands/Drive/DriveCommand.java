/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5952.robot.Robot;
import org.usfirst.frc.team5952.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class DriveCommand extends Command {
	private double _distance;
	private double _targetDistance;
	private double _currentAngle;
	
	public DriveCommand(double targetDistance) {
		requires(Robot.driveTrain);
		_targetDistance = targetDistance;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		_distance = Robot.driveTrain.getDistance();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {		
		Robot.driveTrain.drive(RobotMap.movingSpeed, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		boolean _continue = true;
		
		if(Math.signum(_targetDistance) > 0) {
			_continue = Robot.driveTrain.getDistance() >= (_distance + _targetDistance);
		} else {
			_continue = Robot.driveTrain.getDistance() <= (_distance + _targetDistance);
		}
		
		return _continue;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.driveTrain.stop();
	}
}
