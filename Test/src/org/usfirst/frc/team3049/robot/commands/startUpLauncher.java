package org.usfirst.frc.team3049.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Launcher;


/**
 *
 */
public class startUpLauncher extends Command {
	public startUpLauncher() {
		super();
		requires(Robot.fuelLauncher);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		  ((Launcher) Robot.fuelLauncher).startUp();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		((Launcher) Robot.fuelLauncher).stop();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
