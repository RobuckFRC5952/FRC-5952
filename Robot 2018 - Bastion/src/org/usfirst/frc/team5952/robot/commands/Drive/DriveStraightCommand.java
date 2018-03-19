/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5952.robot.commands.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5952.robot.Robot;
import org.usfirst.frc.team5952.robot.RobotMap;

/**
 * Drive the given distance straight (negative values go backwards). Uses a
 * local PID controller to run a simple PID loop that is only enabled while this
 * command is running. The input is the averaged values of the left and right
 * encoders.
 */
public class DriveStraightCommand extends Command {
	private double _direction, _distance;
	
	private PIDController leftPID, rightPID, gyroPID;
	private double Kp, Ki, Kd;
	
	public DriveStraightCommand(double distance) {
		requires(Robot.driveTrain);
		
		_direction = Math.signum(distance);
				
		PIDSource sourceLeftDistance = new PIDSource() {
		      @Override
		      public void setPIDSourceType(PIDSourceType pidSource) {
		      }

		      @Override
		      public PIDSourceType getPIDSourceType() {
		        // Distance type PID
		        return PIDSourceType.kDisplacement;
		      }

		      @Override
		      public double pidGet() {
		        return Robot.driveTrain.getDistance();
		      }
		    };
		    
		    PIDSource sourceRightDistance = new PIDSource() {
		      @Override
		      public void setPIDSourceType(PIDSourceType pidSource) {
		      }

		      @Override
		      public PIDSourceType getPIDSourceType() {
		        // Distance type PID
		        return PIDSourceType.kDisplacement;
		      }

		      @Override
		      public double pidGet() {
		        return Robot.driveTrain.getDistance();
		      }
		    };
		    
		    PIDSource sourceGyro = new PIDSource() {
			      @Override
			      public void setPIDSourceType(PIDSourceType pidSource) {
			      }

			      @Override
			      public PIDSourceType getPIDSourceType() {
			        // Distance type PID
			        return PIDSourceType.kDisplacement;
			      }

			      @Override
			      public double pidGet() {
			        return Robot.driveTrain.getHeading();
			      }
			    };
		    
		    PIDOutput outLeftDistance = new PIDOutput() {
		        @Override
		        public void pidWrite(double output) {
		        	Robot.driveTrain.drive(RobotMap.movingSpeed, output);
		        }
		      };

		      PIDOutput outRightDistance = new PIDOutput() {
		        @Override
		        public void pidWrite(double output) {
		          Robot.driveTrain.drive(RobotMap.movingSpeed, output);
		        }
		      };
		      
		      PIDOutput outGyro = new PIDOutput() {
			        @Override
			        public void pidWrite(double output) {
			          Robot.driveTrain.drive(RobotMap.movingSpeed, output);
			        }
      			};
		      
		  leftPID = new PIDController(Kp, Ki, Kd, sourceLeftDistance, outLeftDistance);
		  rightPID = new PIDController(Kp, Ki, Kd, sourceRightDistance, outRightDistance);
		  gyroPID = new PIDController(Kp, Ki, Kd, sourceGyro, outGyro);
	}
	
	@Override
	protected void initialize() {
		leftPID.reset();
		rightPID.reset();
		gyroPID.reset();
		
		leftPID.setSetpoint(Robot.driveTrain.getDistance() + _distance);
		rightPID.setSetpoint(Robot.driveTrain.getDistance() + _distance);
		gyroPID.setSetpoint(Robot.driveTrain.getHeading());
		
		leftPID.enable();
		rightPID.enable();
		gyroPID.enable();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return leftPID.onTarget() && rightPID.onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// Stop PID and the wheels
		leftPID.disable();
		rightPID.disable();
		gyroPID.disable();
		Robot.driveTrain.stop();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}
