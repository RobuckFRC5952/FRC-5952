/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands.Lift;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5952.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class LiftCommand extends Command {
	private boolean _direction;
	private double _distance;
	
	public LiftCommand(boolean direction) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.lift);
		requires(Robot.light);
		
		_direction = direction;
	}
	
	public LiftCommand(boolean direction, double distance, boolean reset) {
		_distance = Robot.lift.getDistance();
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.light.reverse();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.lift.move(_direction);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.light.close();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.light.close();
	}
}
