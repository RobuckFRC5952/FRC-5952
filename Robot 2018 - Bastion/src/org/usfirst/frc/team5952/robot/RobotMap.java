/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

public class RobotMap {
	public static int liftMotor = 2; // PWM
	public static int liftEncoder1 = 1;
	public static int liftEncoder2 = 2;
	public static int topLiftLimitSwitchChannel = 1;
	public static int bottomLiftLimitSwitchChannel = 2;
	
	public static int cableWinchMotor = 2; // PWM
	public static int cableWinchEncoder1 = 1;
	public static int cableWinchEncoder2 = 2;
	
	public static int driveTrainMotorRight = 0; // PWM
	public static int driveTrainMotorLeft = 1; // PWM
	public static int driveTrainLeftEncoder1 = 0; 
	public static int driveTrainLeftEncoder2 = 1;
	public static int driveTrainRightEncoder1 = 2;
	public static int driveTrainRightEncoder2 = 3;
	
	public static int clampUpDown = 1;
	public static int clampOpenClose = 2;
	
	public static int light = 2;
	
	public static double distancePerPulse = 0.00987;
}
