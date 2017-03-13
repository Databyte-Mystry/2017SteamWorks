package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3049.robot.subsystems.Collector;

/**
 *
 */
public class fuelCollecter extends Command {

    public fuelCollecter() {
    	super();
    	requires(Robot.collecter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	((Collector) Robot.collecter).Run();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	timeSinceInitialized();
    	setTimeout(30);
    	if(isTimedOut()){
    		return true;
    	};
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	((Collector) Robot.collecter).Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
