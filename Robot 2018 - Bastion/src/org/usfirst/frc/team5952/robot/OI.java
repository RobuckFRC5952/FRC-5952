/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

import org.usfirst.frc.team5952.robot.commands.RobotShutdown;
import org.usfirst.frc.team5952.robot.commands.RobotStart;
import org.usfirst.frc.team5952.robot.commands.Clamp.ClampCommand;
import org.usfirst.frc.team5952.robot.commands.Clamp.ClampEnableCommand;
import org.usfirst.frc.team5952.robot.commands.Drive.MoveCommand;
import org.usfirst.frc.team5952.robot.commands.Lift.LiftCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		b1.whileHeld(new ClampCommand(true));
		b1.whenReleased(new ClampCommand(false));
		b3.whileHeld(new LiftCommand(0.7));
		b3.whenReleased(new LiftCommand(0));
		b2.whileHeld(new LiftCommand(-0.3));
		b2.whenReleased(new LiftCommand(0));
		b6.toggleWhenPressed(new ClampEnableCommand(true));
		b7.toggleWhenPressed(new ClampEnableCommand(false));
		
		b4.whileHeld(new LiftCommand(0.2));
		b5.whileHeld(new LiftCommand(-1));
		//SmartDashboard.putData(new RobotStart());
		//SmartDashboard.putData(new RobotShutdown());
		
		SmartDashboard.putData("Open", new ClampCommand(true));
		SmartDashboard.putData("Close", new ClampCommand(false));
		SmartDashboard.putData("UP", new ClampEnableCommand(true));
		SmartDashboard.putData("Down", new ClampEnableCommand(false));
//		
//		SmartDashboard.putData("Lift up", new LiftCommand(0.5));
//		SmartDashboard.putData("Lift down", new LiftCommand(-0.3));
//		SmartDashboard.putData("Lift stop", new LiftCommand(0));
	}

	public Joystick getJoystick() {
		return this.stick;
	}
}
