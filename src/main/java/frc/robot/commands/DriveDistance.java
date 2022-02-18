// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveDistance extends CommandBase {

  private double m_distance;
  private double m_speed;
  private double m_turn;
  private Drivetrain m_drivetrain;

  public DriveDistance(double distance, double speed, double turn, Drivetrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_distance = distance;
    m_speed = speed;
    m_turn = turn;
    m_drivetrain = subsystem;
    addRequirements(m_drivetrain);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.my_resetLeftEncoder();
    m_drivetrain.my_resetRightEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.my_DriveArcade(m_speed, m_turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.my_DriveArcade(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   
    return (Math.abs(m_drivetrain.my_getRight_Distance_Inches())) >= m_distance;
  }
}
