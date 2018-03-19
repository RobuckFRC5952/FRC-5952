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
public class TurnCommand extends Command {
	private double _targetAngle;
	private double _direction;
	private double _angle;
	
	public TurnCommand(double angle) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);	
		
		_angle = angle;
		_direction = Math.signum(_angle);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		_targetAngle = Robot.driveTrain.getHeading() + _angle;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.drive(RobotMap.movingSpeed, _direction * 0.5);
	}

	@Override
	protected boolean isFinished() {
		return _direction > 0 ? 
				Robot.driveTrain.getHeading() >= _targetAngle : 
				Robot.driveTrain.getHeading() <= _targetAngle; 
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
