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
	private double _currentSpeed;
	private double _split;
	
	public LiftCommand(double speed) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lift);
		
		_speed = speed;
	}
	
	public LiftCommand(double speed, double distance, boolean reset) {
		this(speed);
		
		if(reset) {
			Robot.lift.reset();
		}
		
		_currentDistance = Robot.lift.getDistance();
		_targetDistance = _currentDistance + (distance * Math.signum(speed));
	}
	
	@Override
	protected void initialize() {
		Robot.light.reverse();
	}

	@Override
	protected void execute() {
		Robot.lift.move(_speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {		
		return false;
		
		//_targetDistance != 0 && (
		//		(Robot.lift.getDistance() <= _targetDistance && _speed > 0) ||
		//		(Robot.lift.getDistance() >= _targetDistance && _speed < 0));
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
