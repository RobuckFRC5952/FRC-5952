/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5952.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class MoveBrasCommand extends Command {
	private int m_direction;
	public MoveBrasCommand(int direction) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.kMoveBras);
		m_direction = direction;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		switch (m_direction) {
		case 0:
			Robot.kMoveBras.arreter();
			break;
		case 1:
			if(!Robot.m_limitSwitchBack.isTriggered()) {
				Robot.kMoveBras.monter();
				Robot.m_limitSwitchFront.resetCounter();
			}
			
			break;
		case 2:
			if(!Robot.m_limitSwitchFront.isTriggered()) {
				Robot.kMoveBras.descendre();
				Robot.m_limitSwitchBack.resetCounter();
			}
			
			break;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.kMoveBras.arreter();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
