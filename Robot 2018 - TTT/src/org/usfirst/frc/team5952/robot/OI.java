/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

import org.usfirst.frc.team5952.robot.commands.ExtendBrasCommand;
import org.usfirst.frc.team5952.robot.commands.PousserBallonCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick stick = new Joystick(0);
	JoystickButton b6 = new JoystickButton(stick, 6);
	JoystickButton b1 = new JoystickButton(stick, 1);

	public OI () {
		b6.toggleWhenPressed(new ExtendBrasCommand());
		b1.toggleWhenPressed(new PousserBallonCommand());
	}

	public Joystick getJoystick() {
		return this.stick;
	}
}
