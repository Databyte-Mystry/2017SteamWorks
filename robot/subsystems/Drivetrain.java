package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.OI;
import org.usfirst.frc.team3049.robot.RobotMap;
import org.usfirst.frc.team3049.robot.commands.ArcadeDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public RobotDrive m_robotDrive;
	private SpeedController frontLeftMotor = new Talon(RobotMap.FRONT_LEFT_MOTOR);
	private SpeedController rearLeftMotor = new Talon(RobotMap.REAR_LEFT_MOTOR);
	private SpeedController frontRightMotor = new Talon(RobotMap.FRONT_RIGHT_MOTOR);
	private SpeedController rearRightMotor = new Talon(RobotMap.REAR_RIGHT_MOTOR);

	public Drivetrain(){
		super();
		m_robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		m_robotDrive.setInvertedMotor(MotorType.kFrontLeft, true);
		m_robotDrive.setInvertedMotor(MotorType.kRearRight, true);
	}
	
	public void drive(double x, double y, double r) {
		x = deadzone(x);
		y = deadzone(y);
		r = deadzone(r);
		m_robotDrive.mecanumDrive_Cartesian(x, y, r, 0);
	}
	
	public double deadzone(double i) {
		if (Math.abs(i) < 0.3)
		{
			i = 0.0;
		}
		
		return i;
	}
	
	public void drive(Joystick joy) {
		System.out.println(""+joy.getRawAxis(0)+""+joy.getRawAxis(1)+""+joy.getRawAxis(2)+""+joy.getRawAxis(3)+joy.getRawAxis(4));
		drive(joy.getRawAxis(0), joy.getRawAxis(1), joy.getRawAxis(4));
	}
	
	public void stop() // To keep motor safety happy
	{
		m_robotDrive.stopMotor();
	}
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new ArcadeDriveCommand(this, OI.joy));
	}
}
