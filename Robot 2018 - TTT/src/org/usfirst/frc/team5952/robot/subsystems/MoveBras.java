/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class MoveBras extends Subsystem {
	private int m_direction = 0;
	private Talon _brasMotor;
	
	public MoveBras(int port) {
		_brasMotor = new Talon(port);
	}
	
	public int getDirection() {
		return m_direction;
	}
	
	/**
	 * Monter 		:  1
	 * Descendre 	: -1
	 * Arrêter		:  0
	 * @param direction
	 */
	public void setDirection(int direction) {
		if(direction < 0) {
			m_direction = -1;
		} else if (direction > 0) {
		 	m_direction = 1;
		} else {
			m_direction = 0;
		}
		
		run();
	}
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	void run() {
		_brasMotor.set(m_direction * 0.4);
	}

	public void initDefaultCommand() { }
}
