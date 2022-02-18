// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.RearElevator;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SequentialCommandGroup1 extends SequentialCommandGroup {
  /** Creates a new SequentialCommandGroup1. */
  public SequentialCommandGroup1(Drivetrain drivetrain, RearElevator rearElevator) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveDistance(10, .5, 0.0, drivetrain).withTimeout(5),
      new RearElevatorRun(.2,rearElevator).withTimeout(3)
      
      );
  }
}
