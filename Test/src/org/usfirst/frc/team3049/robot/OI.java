package org.usfirst.frc.team3049.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team3049.robot.commands.ExampleCommand;
import org.usfirst.frc.team3049.robot.commands.fuelCollecter;
import org.usfirst.frc.team3049.robot.commands.setSpeed;
import org.usfirst.frc.team3049.robot.commands.startUpLauncher;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick joy = new Joystick(0);
	
	// Xbox Controller Button Mapping
	JoystickButton buttonA = new JoystickButton(joy, 1); // increase speed
	JoystickButton buttonB = new JoystickButton(joy, 2); // decrease speed
	JoystickButton buttonX = new JoystickButton(joy, 3); // spin bin counter clockwise
	JoystickButton buttonY = new JoystickButton(joy, 4); // move bin away from robot
	JoystickButton buttonLSh = new JoystickButton(joy, 5); // collect fuel
	JoystickButton buttonRSh = new JoystickButton(joy, 6); // launch fuel
	JoystickButton buttonBack = new JoystickButton(joy, 7); // piston operation
	JoystickButton buttonStart = new JoystickButton(joy, 8);
	int axisLX = 0; // Drive, turning
	int axisLY = 1; // Drive, fwd/back
	int axisLT = 2; // 
	int axisRT = 3; // 
	int axisRX = 4;
	int axisRY = 5;
	
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public OI() {
		buttonLSh.whileHeld(new startUpLauncher());
		buttonRSh.whileHeld(new startUpLauncher());
		//buttonA.whenPressed(new setSpeed(1));
		//buttonB.whenPressed(new setSpeed(-1));
		
	}

	public Joystick getJoystick() {
		return joy;
	}
	
	
}
