// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import javax.xml.namespace.QName;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;



public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new Intake. */
  private final CANSparkMax intakeMotor = new CANSparkMax(9, MotorType.kBrushless);
  private final DoubleSolenoid piston1 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 0);
  private final DoubleSolenoid piston2 = new DoubleSolenoid(PneumaticsModuleType.REVPH, 14, 15);
  
  // 
  private final Compressor compressor = new Compressor(PneumaticsModuleType.REVPH); //check module number
  private boolean piston1Out = false;
  private boolean piston2Out = false;

  public IntakeSubsystem() {}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   

  }
  // public void getStatus(){ //check status of Pneumatics
  //   System.out.println(compressor.enabled());
  // }
  public void compressor(){
    compressor.enableAnalog(25,30);
   
   }
  // public void stopCompressor(){
  //   compressor.disable();
  // }

  public void intake(){
    intakeMotor.set(0.6);
  }

  public void intakeCube(){
    intakeMotor.set(0.4); //values will change :D
  }
  public void intakeCone(){
    intakeMotor.set(0.6);
  }

  public void outtake(){
    intakeMotor.set(-0.6);
  }

  public void outtakeauto(){
    intakeMotor.set(-0.4);
  }

  public void stop(){
    intakeMotor.set(0);
  }

  
  public void intakeToggle(){
    if(piston1Out){
      piston1.set(Value.kReverse);
      piston1Out = false;
    }
    else{
      piston1.set(Value.kForward);
      piston1Out = true;
    }

    if(piston2Out){
      piston2.set(Value.kReverse);
      piston2Out = false;
    }
    else{
      piston2.set(Value.kForward);  
      piston2Out = true;
    
    }

    
  }

  


}