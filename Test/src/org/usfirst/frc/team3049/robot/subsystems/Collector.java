package org.usfirst.frc.team3049.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	
	private static SpeedController motor = new Talon(7);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void Run(){
		motor.set(1);
	}
	
	public void Stop(){
		motor.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

