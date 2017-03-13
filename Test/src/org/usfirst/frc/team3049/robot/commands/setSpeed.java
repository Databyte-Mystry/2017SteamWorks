package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class setSpeed extends Command {
	public double i;
    public setSpeed(double i) {
        super();
        requires(Robot.fuelLauncher);
        this.i = i;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	((Launcher) Robot.fuelLauncher).controlSpeed(i);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (i >= 1 || i <= 1){
        	return true;
    	}
		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }
}
