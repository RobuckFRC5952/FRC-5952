/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands.Lift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5952.robot.Robot;
import org.usfirst.frc.team5952.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class LiftCommand extends Command {
	private double _speed;
	private double _currentDistance;
	private double _targetDistance;
	
	public LiftCommand(double speed) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lift);
		requires(Robot.cableWinch);
		
		_speed = speed;
	}
	
	public LiftCommand(double speed, double distance, boolean reset) {
		this(speed);
		
		if(reset) {
			Robot.lift.reset();
		}
		
		_currentDistance = Robot.lift.getDistance();
		_targetDistance = _currentDistance + (distance * (speed > 0 ? 1 : -1));
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.light.reverse();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.lift.move(_speed);
		Robot.cableWinch.move(_speed * RobotMap.cableWinchSpeedAjustement);
		_currentDistance = Robot.lift.getDistance();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return _targetDistance != 0 && (
				(_currentDistance <= _targetDistance && _speed > 0) ||
				(_currentDistance >= _targetDistance && _speed < 0));
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.light.open();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.light.open();
	}
}
