/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot;

public class RobotMap {
	public static int liftMotor = 0; // PWM
	public static int liftEncoder1 = 6; // DIO
	public static int liftEncoder2 = 7;// DIO 
	public static int topLiftLimitSwitchChannel = 8; // DIO
	public static int bottomLiftLimitSwitchChannel = 9; // DIO
	
	public static int cableWinchMotor = 1; // PWM
	public static int cableWinchEncoder1 = 4; // DIO
	public static int cableWinchEncoder2 = 5; // DIO
	
	public static int driveTrainMotorRight = 3; // PWM
	public static int driveTrainMotorLeft = 2; // PWM
	public static int driveTrainLeftEncoder1 = 2; // DIO
	public static int driveTrainLeftEncoder2 = 3; // DIO
	public static int driveTrainRightEncoder1 = 0; // DIO
	public static int driveTrainRightEncoder2 = 1; // DIO
	
	public static int clampUpDown = 1;
	public static int clampOpenClose = 2;
	
	public static int light = 2;
	
	public static double distancePerPulse = 0.00987;
	public static double cableWinchSpeedAjustement = 1;
	public static double clampHeightEnableHigh = 50;
	public static double clampHeightEnableLow = 10;
}
