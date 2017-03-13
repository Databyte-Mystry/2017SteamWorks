package org.usfirst.frc.team3049.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import org.usfirst.frc.team3049.robot.subsystems.Launcher;
import org.usfirst.frc.team3049.robot.commands.DriveStraightCommand;
import org.usfirst.frc.team3049.robot.subsystems.Collector;
import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static Launcher fuelLauncher;
	public static Collector collecter;
	public static OI oi;
	public static Drivetrain driveTrain;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		fuelLauncher = new Launcher();
		collecter = new Collector();
		oi = new OI();
		driveTrain = new Drivetrain();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {                   
		autonomousCommand = new DriveStraightCommand(driveTrain, 5.0);
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		log();
	/*
		while (isOperatorControl() && isEnabled()) {
			Scheduler.getInstance().run();
			double x = oi.joy.getRawAxis(0);
			double y = oi.joy.getRawAxis(1);
			double r = oi.joy.getRawAxis(4);
			
			//set deadzones
			x = deadzone(x);
			y = deadzone(y);
			r = deadzone(r);
			
			driveTrain.mecanumDrive_Cartesian(x, y, r, 0);
			Timer.delay(0.02);
			log();
		}
		
		
		//for (int i = 0; i < oi.joy.getAxisCount(); i++) {
			//System.out.println("Axis " + i + " = " + oi.joy.getRawAxis(i));
		//}
		 */
	}
	
	private void log(){
		((Launcher) fuelLauncher).log();
	}

	public double deadzone(double i) {
		if (i * i < 0.3 * 0.3) {
			i = 0.0;
		}
		
		return i;
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
