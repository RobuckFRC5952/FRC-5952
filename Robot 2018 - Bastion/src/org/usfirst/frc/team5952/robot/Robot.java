/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5952.robot.commands.*;
import org.usfirst.frc.team5952.robot.commands.Drive.MiddleMode;
import org.usfirst.frc.team5952.robot.commands.Drive.MoveCommand;
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
public class Robot extends TimedRobot {
	public static final DriveTrain driveTrain = 
			new DriveTrain();
	
	public static final Lift lift = null;
//			new Lift(RobotMap.liftMotor, 
//					RobotMap.liftEncoder1,
//					RobotMap.liftEncoder2,
//					RobotMap.distancePerPulse,
//					RobotMap.topLiftLimitSwitchChannel,
//					RobotMap.bottomLiftLimitSwitchChannel);
	
	public static final CableWinch cableWinch = null;
//			new CableWinch(RobotMap.cableWinchMotor, 
//					RobotMap.cableWinchEncoder1,
//					RobotMap.cableWinchEncoder2,
//					RobotMap.distancePerPulse);
	
	public static final Clamp clamp = null;
//			new Clamp(RobotMap.clampUpDown,
//					  RobotMap.clampOpenClose);
//	
	public static final Light light = null;
//			new Light(RobotMap.light);
	
	//public static final AnalogGyro gyro = new AnalogGyro(RobotMap.gyro);
	public static AHRS gyro = new AHRS(SPI.Port.kMXP);
	
	public static boolean isAutonomous = false;
	
	
	public static OI m_oi;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_oi = new OI();
		
		m_chooser.addDefault("Test", new MoveCommand(150));
		m_chooser.addObject("AutonomneSide", new TurnCommand(90));
		m_chooser.addObject("AutonomneMiddle", new MiddleMode());
		
//		CameraServer.getInstance().startAutomaticCapture();
		SmartDashboard.putData("Chooser", m_chooser);
		
//		light.open();
		driveTrain.reset();
		gyro.reset();
//		lift.reset();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		gyro.reset();
		driveTrain.reset();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.log();
//		lift.log();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		
		isAutonomous = true;
		gyro.reset();
		driveTrain.reset();
		
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
		driveTrain.log();
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
//		lift.log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		
		driveTrain.reset();
		driveTrain.move(-m_oi.getJoystick().getY(), m_oi.getJoystick().getX());
		driveTrain.log();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.move(-m_oi.getJoystick().getY(), m_oi.getJoystick().getX());
		driveTrain.log();
		SmartDashboard.putNumber("Gyro", gyro.getAngle());
//		lift.log();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
