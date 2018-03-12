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
public class TurnCommand extends Command {
	private double _targetAngle;
	private double _direction;
	public TurnCommand(double angle) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);	
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		_direction = Math.signum(angle);
		_targetAngle = Robot.gyro.getAngle() + angle;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.moveAuto(0.1, _direction);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return _direction > 0 ? 
				Robot.gyro.getAngle() >= _targetAngle : 
				Robot.gyro.getAngle() <= _targetAngle; 
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
