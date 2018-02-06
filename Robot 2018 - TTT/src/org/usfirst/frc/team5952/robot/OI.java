/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

import org.usfirst.frc.team5952.robot.commands.ExtendBrasCommand;
import org.usfirst.frc.team5952.robot.commands.PousserBallonCommand;
import org.usfirst.frc.team5952.robot.commands.CommandBras;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick stick = new Joystick(0);
	JoystickButton button = new JoystickButton(stick, 1);
	JoystickButton button2 = new JoystickButton(stick, 2);
	JoystickButton button3 = new JoystickButton(stick, 3);
	JoystickButton b6 = new JoystickButton(stick, 6);

	public OI () {
		button.toggleWhenPressed(new CommandBras(0));
		button2.toggleWhenPressed(new CommandBras(1));
		button3.toggleWhenPressed(new CommandBras(2));
		b6.toggleWhenPressed(new ExtendBrasCommand());
	}

	public Joystick getJoystick() {
		return this.stick;
	}
}
