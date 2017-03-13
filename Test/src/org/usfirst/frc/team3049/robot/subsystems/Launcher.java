package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;


/**
 *
 */
public class Launcher extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static SpeedController motor1 = new Talon(RobotMap.LAUNCHER);
	//private static SpeedController motor2 = new Talon(6);
	public double totalSpeed = .25;
	private int speed = 0;
	
	
	public Launcher(){
		super();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void startUp() {
		motor1.set(totalSpeed);
		//Timer.delay(5);
		//motor2.set(1);
	}
	

	public void stop(){
		motor1.set(0);
		//motor2.set(0);
	}

	public double getSpeed(){
		totalSpeed = speed/100;
		return totalSpeed;
	}
	
	public void controlSpeed(double var){
		if(var >= 1){
			speed++;
			var = 0;
		}else if (var <= 1){
			speed--;
			var = 0;
		}
	}
	
	public void log(){
		SmartDashboard.putNumber("Motor Speed", totalSpeed);
	}
}
