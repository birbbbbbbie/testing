// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.CubeIntakeCmd;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.Timer;


public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	public static IntakeSubsystem intakesubsystem = new IntakeSubsystem();

	private static CubeIntakeCmd cubeintake = new CubeIntakeCmd(intakesubsystem);

	//TIMER
	public static Timer timervalue = new Timer();
	
	///private final AutonomousCmd auto = new AutonomousCmd();
	

	// joystick
	public static Joystick joystick1 = new Joystick(Constants.kDriverControllerPort); 
	public static Joystick joystick2 = new Joystick(Constants.kDriverController2Port); 
	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		//Configure the trigger bindings

		configureBindings();
	}

	private void configureBindings() {
		
		//joystick 1
		new JoystickButton(joystick1, 3).toggleOnTrue(cubeintake);
	
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		return null;
	}
}
 