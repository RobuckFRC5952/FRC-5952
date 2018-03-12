/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5952.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveCommand extends Command {
	private double _distance;
	private double _targetDistance;
	private double _currentAngle;
	
	public MoveCommand(double targetDistance) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		_targetDistance = targetDistance;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		_distance = Robot.driveTrain.getDistance();
		_currentAngle = Robot.gyro.getAngle();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double direction = Robot.gyro.getAngle() - _currentAngle;
		
		Robot.driveTrain.move(0.4, 0.1 * direction);
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
