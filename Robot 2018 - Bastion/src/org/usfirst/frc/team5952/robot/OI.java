/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

import org.usfirst.frc.team5952.robot.commands.Foward10Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick stick = new Joystick(0);
	JoystickButton b1 = new JoystickButton(stick, 1);
	JoystickButton b2 = new JoystickButton(stick, 2);
	JoystickButton b3 = new JoystickButton(stick, 3);
	JoystickButton b4 = new JoystickButton(stick, 4);
	JoystickButton b5 = new JoystickButton(stick, 5);
	JoystickButton b6 = new JoystickButton(stick, 6);
	JoystickButton b7 = new JoystickButton(stick, 7);
	JoystickButton b8 = new JoystickButton(stick, 8);
	JoystickButton b9 = new JoystickButton(stick, 9);
	JoystickButton b10 = new JoystickButton(stick, 10);
	JoystickButton b11 = new JoystickButton(stick, 11);
	JoystickButton b12 = new JoystickButton(stick, 12);

	public OI () {
		b1.toggleWhenPressed(new Foward10Command());		
	}

	public Joystick getJoystick() {
		return this.stick;
	}
}
