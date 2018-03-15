/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5952.robot.commands.Drive.MiddleMode;
import org.usfirst.frc.team5952.robot.commands.Drive.MoveCommand;
import org.usfirst.frc.team5952.robot.commands.Drive.SideMode;
import org.usfirst.frc.team5952.robot.commands.Drive.TurnCommand;
import org.usfirst.frc.team5952.robot.subsystems.*;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	public static DriveTrain driveTrain;
	public static Lift lift;
	public static Clamp clamp;
	public static Light light;
	public static AHRS gyro;
	public static OI oi;
	
	public static boolean isAutonomous = false;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser;
	
	@Override
	public void robotInit() {
		light =	new Light(RobotMap.light);
		lift = new Lift(RobotMap.liftMotor, 
						RobotMap.liftEncoder1,
						RobotMap.liftEncoder2,
						RobotMap.distancePerPulse,
						RobotMap.topLiftLimitSwitchChannel,
						RobotMap.bottomLiftLimitSwitchChannel);
		clamp = new Clamp(RobotMap.clampUpDown,
				  RobotMap.clampOpenClose);
		driveTrain = new DriveTrain();
		gyro = new AHRS(SPI.Port.kMXP);
		oi = new OI();
		
		m_chooser = new SendableChooser<Command>();
		m_chooser.addDefault("SideMode", new SideMode());
		m_chooser.addObject("MiddleMode", new MiddleMode());
		SmartDashboard.putData("Chooser", m_chooser);
		
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
		m_autonomousCommand = m_chooser.getSelected();
		isAutonomous = true;
		
		fullReset();		
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
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
		
		fullReset();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.move(-oi.getJoystick().getY(), oi.getJoystick().getX());
		
		fullLog();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	private void fullLog() {
		driveTrain.log();
		lift.log();
		clamp.log();
		
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
	}
	
	private void fullReset() {
		driveTrain.reset();
		lift.reset();
		gyro.reset();
	}
}
