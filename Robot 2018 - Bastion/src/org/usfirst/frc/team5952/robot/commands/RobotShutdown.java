/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5952.robot.commands.Clamp.ClampCommand;
import org.usfirst.frc.team5952.robot.commands.Clamp.ClampEnableCommand;
import org.usfirst.frc.team5952.robot.commands.Lift.LiftCommand;

/**
 * An example command.  You can replace me with your own command.
 */
public class RobotShutdown extends CommandGroup {
	
	public RobotShutdown() {
		addSequential(new ClampEnableCommand(true));
		addParallel(new ClampCommand(true));
		addParallel(new LiftCommand(-0.3));
		addParallel(new LightCommand(false));
	}
}
