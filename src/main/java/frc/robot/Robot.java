	// Copyright (c) FIRST and other WPILib contributors.
	// Open Source Software; you can modify and/or share it under the terms of
	// the WPILib BSD license file in the root directory of this project.

	package frc.robot;

	import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
	



	/**
	 * The VM is configured to automatically run this class, and to call the functions corresponding to
	 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
	 * the package after creating this project, you must also update the build.gradle file in the
	 * project.
	 */
	public class Robot extends TimedRobot {

	// private Spark leftmotor1 = new Spark(1);
	// private Spark leftmotor2 = new Spark(3);
	// private Spark rightmotor1 = new Spark(7);
	// private Spark rightmotor2 = new Spark(5);
	private Command m_autonomousCommand;
	private RobotContainer m_robotContainer;
	// private PhotonCamera camera = new PhotonCamera("OV5647");

	/**
	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
	 */
	@Override
	public void robotInit() {
		// PowerDistribution pd = new PowerDistribution(1, ModuleType.kRev);
		// pd.setSwitchableChannel(false);

		// pd.
		// Instantiate our RobotContainer.  This will perform all our button bindings, and put our
		// autonomous chooser on the dashboard.
		m_robotContainer = new RobotContainer();
	}

	/**
	 * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
	 * that you want ran during disabled, autonomous, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before LiveWindow and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		// Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
		// commands, running already-scheduled commands, removing finished or interrupted commands,
		// and running subsystem periodic() methods.  This must be called from the robot's periodic
		// block in order for anything in the Command-based framework to work.
		

		//if(m_autonomousCommand == null){
			//CommandScheduler.getInstance().run();
		//}
		
	}

	/** This function is called once each time the robot enters Disabled mode. */
	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		//CommandScheduler.getInstance().run();
	}

	double timer;
	/** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_robotContainer.getAutonomousCommand();

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
		m_autonomousCommand.schedule();
		}
		
		RobotContainer.timervalue.reset();
		RobotContainer.timervalue.start();
		RobotContainer.toggleintake.execute(); // comment out if needed
		//CommandScheduler.getInstance().run();
		
	}

	

	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {
		//m_autonomousCommand = m_robotContainer.getAutonomousCommand();+
		
		CommandScheduler.getInstance().run();

		double timer = RobotContainer.timervalue.get();
		System.out.println(timer);

		// leave community

		// if(timer < 2.2){
		// 	RobotContainer.spin.execute();
		// }
		// else if (timer >= 2.2 && timer <3.5){
		// 	RobotContainer.spin.end(true);
		// 	RobotContainer.fwd.execute();
		// }
		// else if (timer >=3.5){
		// 	RobotContainer.fwd.end(true);
		// }

		// score then leave and preload

		// if (timer < 1.3 && timer >= 1.2){
		// 	RobotContainer.autoOut.execute();
		// }
		// else if (timer >= 1.3 && timer < 3.5){
		// 	RobotContainer.autoOut.end(true);
		// 	RobotContainer.spin.execute();
		// }
		// else if (timer >= 3.6 && timer < 4.9){
		// 	RobotContainer.fwd.execute();
		// 	RobotContainer.spin.end(true);
		// }
		// else if (timer >= 5 && timer < 6){
		// 	RobotContainer.fwd.end(true);
		// 	RobotContainer.autoIn.execute();
		// }
		// else if (timer >= 7){
		// 	RobotContainer.autoIn.end(true);
		// }

		// score, leave, load, score

		if (timer < 1.3 && timer >= 1.2){
			RobotContainer.autoOut.execute();
		}
		else if (timer >= 1.3 && timer < 3.5){
			RobotContainer.autoOut.end(true);
			RobotContainer.spin.execute();
		}
		else if (timer >= 3.6 && timer < 4.9){
			RobotContainer.spin.end(true);
			RobotContainer.fwd.execute();
		}
		else if (timer >= 5 && timer < 6){
			RobotContainer.fwd.end(true);
			RobotContainer.autoIn.execute();
		}
		else if (timer >= 7 && timer < 8.4){
			RobotContainer.autoIn.end(true);
			RobotContainer.fwd.execute();
		}
		else if (timer >= 8.4 && timer < 9.4){
			RobotContainer.fwd.end(true);
			RobotContainer.autoOut.execute();
		}
		else if (timer >= 9.4){
			RobotContainer.autoOut.end(true);
		}

		


		// score then leave community
		
		// if (timer < 1.3 && timer >= 1.2){
		// 	RobotContainer.autoOut.execute();
		// }
		// else if (timer ==1.3){
		// 	RobotContainer.autoOut.end(true);
		// }
		// else if(timer >= 1.4 && timer < 2.6){
		// 	RobotContainer.spin.execute();
		// }
		// else if (timer >= 2 && timer <4.9){
		// 	RobotContainer.spin.end(true);
		// 	RobotContainer.fwd.execute();
		// }
		// else if (timer >=4.9){
		// 	RobotContainer.fwd.end(true);
		// }

		// charge station

		// if(timer < 2.2){
		// 	RobotContainer.fwd.execute();
		// }
		// else if (timer >= 2.2){
		// 	RobotContainer.fwd.end(true);
		// }
		// else if (timer >= 2.4 && timer < 8){
		// 	RobotContainer.balance.execute();
		// } else {
		// 	RobotContainer.balance.end(true);
		// }

	}
		

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
		m_autonomousCommand.cancel();
		}

		
		
	}

	
	/** This function is called periodically during operator control. */
	@Override
	public void teleopPeriodic() {
		CommandScheduler.getInstance().run();
		RobotContainer.vision.choosePipeline();

		RobotContainer.intakesubsystem.compressor();

		//leftmotor1.set(0.2);
		// leftmotor2.set(0.2);
		// rightmotor1.set(0.2);
		// rightmotor2.set(0.2);
		//RobotContainer.swerveSubsystem.turning();
		
	}

	@Override
	public void testInit() {
		// Cancels all running commands at the start of test mode.
		CommandScheduler.getInstance().cancelAll();
	}

	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {}

}

	
