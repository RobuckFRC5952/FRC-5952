/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands.Drive;

import org.usfirst.frc.team5952.robot.commands.Clamp.ClampCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An example command.  You can replace me with your own command.
 */
public class AutonomousMiddleMode extends CommandGroup {
	public AutonomousMiddleMode() {
		addSequential(new DriveCommand(110));
		addSequential(new LiftCommand());
		//addSequential(new ClampCommand(true));
		//addSequential(new DriveCommand(SmartDashboard.getNumber("Move2", 40)));
		//addSequential(new TurnCommand(SmartDashboard.getNumber("Turn2", 90)));
		//addSequential(new DriveCommand(SmartDashboard.getNumber("Move3", 120)));
	}
}
