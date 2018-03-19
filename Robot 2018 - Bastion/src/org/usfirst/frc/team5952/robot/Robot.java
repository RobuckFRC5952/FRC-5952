/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5952.robot.commands.Drive.AutonomousMiddleMode;
import org.usfirst.frc.team5952.robot.commands.Drive.AutonomousSideMode;
import org.usfirst.frc.team5952.robot.commands.Drive.AutonomousSideMode2;
import org.usfirst.frc.team5952.robot.subsystems.*;

public class Robot extends IterativeRobot {
	public static DriveTrain driveTrain;
	public static Lift lift;
	public static Clamp clamp;
	public static Light light;
	public static OI oi;
	
	public static boolean isAutonomous = false;
	public static double speedModifier = 1;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser;
	
	@Override
	public void robotInit() {
		light =	new Light(RobotMap.light);
		lift = new Lift();
		clamp = new Clamp(RobotMap.clampUpDown,
				  RobotMap.clampOpenClose);
		driveTrain = new DriveTrain();
		
		oi = new OI();
		
		CameraServer.getInstance().startAutomaticCapture();
		
		fullReset();
	}

	@Override
	public void disabledInit() {
		fullReset();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		fullLog();
	}

	@Override
	public void autonomousInit() {
		m_chooser = new SendableChooser<Command>();
		//m_chooser.addDefault("SideMode", new AutonomousSideMode());
		m_chooser.addDefault("MidleMode", new AutonomousMiddleMode());
		//m_chooser.addDefault("SideMode2", new AutonomousSideMode2());
		SmartDashboard.putData("Chooser", m_chooser);
		
		m_autonomousCommand = m_chooser.getSelected();
		isAutonomous = true;
		
		fullReset();		
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		fullLog();
	}

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		isAutonomous = false;
		
		fullReset();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.drive(-oi.getJoystick().getY(), oi.getJoystick().getX());
		
		fullLog();
	}

	@Override
	public void testPeriodic() {
	}
	
	private void fullLog() {
		driveTrain.log();
		//lift.log();
		clamp.log();
	}
	
	private void fullReset() {
		driveTrain.reset();
		lift.reset();
	}
}
