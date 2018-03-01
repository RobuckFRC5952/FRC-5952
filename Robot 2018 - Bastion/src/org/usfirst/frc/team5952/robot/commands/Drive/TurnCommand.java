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
	private double _endAngle;
	private double _startAngle;
	
	public TurnCommand(double angle) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		
		_endAngle = angle;
		_startAngle = Robot.gyro.getAngle();
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.move(0.2, Math.signum(_endAngle));
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.gyro.getAngle() - _startAngle) >= _endAngle; 
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
