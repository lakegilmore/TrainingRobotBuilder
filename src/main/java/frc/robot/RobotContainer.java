// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Shooter m_shooter = new Shooter();
    public final RearElevator m_rearElevator = new RearElevator();
    public final FrontElevator m_frontElevator = new FrontElevator();
    public final Tower m_tower = new Tower();
    public final Susan m_susan = new Susan();
    public final Intake m_intake = new Intake();
    public final Drivetrain m_drivetrain = new Drivetrain();

// Joysticks
private final Joystick joystickCoDriver = new Joystick(1);
private final XboxController xboxController1 = new XboxController(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_shooter);
    SmartDashboard.putData(m_rearElevator);
    SmartDashboard.putData(m_frontElevator);
    SmartDashboard.putData(m_tower);
    SmartDashboard.putData(m_susan);
    SmartDashboard.putData(m_intake);
    SmartDashboard.putData(m_drivetrain);


    // SmartDashboard Buttons
    SmartDashboard.putData("IntakeRun: In_Setpoint", new IntakeRun(.95, m_intake));
    SmartDashboard.putData("IntakeRun: Eject_Setpoint", new IntakeRun(-0.95, m_intake));
    SmartDashboard.putData("SusanSpin: CW_SusanSetPoint", new SusanSpin(.25, m_susan));
    SmartDashboard.putData("SusanSpin: CCW_SusanSetPoint", new SusanSpin(-.25, m_susan));
    SmartDashboard.putData("TowerRun: Up_TowerSetPoint", new TowerRun(.5, m_tower));
    SmartDashboard.putData("TowerRun: Dw_TowerSetPoint", new TowerRun(-.5, m_tower));
    SmartDashboard.putData("ShooterRun: Hi_ShooterSetpoint", new ShooterRun(.95, m_shooter));
    SmartDashboard.putData("ShooterRun: Low_ShooterSetPoint", new ShooterRun(.5, m_shooter));
    SmartDashboard.putData("FrontElevatorRun: Up_FrontElevatorSetPoint", new FrontElevatorRun(-1, m_frontElevator));
    SmartDashboard.putData("FrontElevatorRun: Dw_FrontElevatorSetPoint", new FrontElevatorRun(1, m_frontElevator));
    SmartDashboard.putData("RearElevatorRun: Up_RearElevatorSetPoint", new RearElevatorRun(.75, m_rearElevator));
    SmartDashboard.putData("RearElevatorRun: Dw_RearElevatorSetPoint", new RearElevatorRun(-.75, m_rearElevator));
    SmartDashboard.putData("autodrive: fwd", new autodrive(.1, m_drivetrain));
    SmartDashboard.putData("autoshoot: shootball", new autoshoot(.5, m_shooter));
    SmartDashboard.putData("DriveDistance: inch_20", new DriveDistance(20, .5, 0, m_drivetrain));
    //SmartDashboard.putData("Sequential Command Group 1", new SequentialCommandGroup1( m_drivetrain ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    SmartDashboard.putData("Sequential Command Group 1", new SequentialCommandGroup1( m_drivetrain, m_rearElevator ));

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        //_ BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
   


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_drivetrain.setDefaultCommand(new DriveWithJoystics(() -> xboxController1.getRawAxis(1)*.7, () -> xboxController1.getRawAxis(4)*.8, m_drivetrain) );

    // Configure autonomous sendable chooser
    m_chooser.addOption("Sequence Group 1", new SequentialCommandGroup1( m_drivetrain, m_rearElevator ));
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.addOption("autodrive: fwd", new autodrive(.1, m_drivetrain));
    m_chooser.addOption("autoshoot: shootball", new autoshoot(.5, m_shooter));
    m_chooser.setDefaultOption("DriveDistance", new DriveDistance(20, .5, 0, m_drivetrain));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
final JoystickButton joystickButton13 = new JoystickButton(joystickCoDriver, 13);        
joystickButton13.whileHeld(new SusanSpin(.25, m_susan) ,true);
    SmartDashboard.putData("Joystick Button 13",new SusanSpin(0, m_susan) );

final JoystickButton joystickButton12 = new JoystickButton(joystickCoDriver, 12);        
joystickButton12.whileHeld(new SusanSpin(-.25, m_susan) ,true);
    SmartDashboard.putData("Joystick Button 12",new SusanSpin(0, m_susan) );

final JoystickButton joystickButton8 = new JoystickButton(joystickCoDriver, 8);        
joystickButton8.whileHeld(new RearElevatorRun(-.75, m_rearElevator) ,true);
    SmartDashboard.putData("Joystick Button 8",new RearElevatorRun(-.75, m_rearElevator) );

final JoystickButton joystickButton5 = new JoystickButton(joystickCoDriver, 5);        
joystickButton5.whileHeld(new RearElevatorRun(.75, m_rearElevator) ,true);
    SmartDashboard.putData("Joystick Button 5",new RearElevatorRun(.75, m_rearElevator) );

final JoystickButton joystickButton9 = new JoystickButton(joystickCoDriver, 9);        
joystickButton9.whileHeld(new FrontElevatorRun(-.95, m_frontElevator) ,true);
    SmartDashboard.putData("Joystick Button 9",new FrontElevatorRun(0, m_frontElevator) );

final JoystickButton joystickButton4 = new JoystickButton(joystickCoDriver, 4);        
joystickButton4.whileHeld(new FrontElevatorRun(.95, m_frontElevator) ,true);
    SmartDashboard.putData("Joystick Button 4",new FrontElevatorRun(0, m_frontElevator) );

final JoystickButton joystickButton3 = new JoystickButton(joystickCoDriver, 3);        
joystickButton3.whileHeld(new TowerRun(.95, m_tower) ,true);
    SmartDashboard.putData("Joystick Button 3",new TowerRun(0, m_tower) );

final JoystickButton joystickButton2 = new JoystickButton(joystickCoDriver, 2);        
joystickButton2.whileHeld(new TowerRun(-.95, m_tower) ,true);
    SmartDashboard.putData("Joystick Button 2",new TowerRun(0, m_tower) );

final JoystickButton xboxButtonA = new JoystickButton(xboxController1, XboxController.Button.kA.value);        
xboxButtonA.whileHeld(new ShooterRun(.95, m_shooter) ,true);
    SmartDashboard.putData("Xbox Button A",new ShooterRun(0, m_shooter) );

final JoystickButton xboxButtonB = new JoystickButton(xboxController1, XboxController.Button.kB.value);        
xboxButtonB.whileHeld(new ShooterRun(-.95, m_shooter) ,true);
    SmartDashboard.putData("Xbox Button B",new ShooterRun(0, m_shooter) );

final JoystickButton xboxButton_RB = new JoystickButton(xboxController1, XboxController.Button.kRightBumper.value);        
xboxButton_RB.whileHeld(new IntakeRun(.95, m_intake) ,true);
    SmartDashboard.putData("Xbox Button _RB",new IntakeRun(.5, m_intake) );

final JoystickButton xboxButton_LB = new JoystickButton(xboxController1, XboxController.Button.kLeftBumper.value);        
xboxButton_LB.whileHeld(new IntakeRun(-.95, m_intake) ,true);
    SmartDashboard.putData("Xbox Button _LB",new IntakeRun(-.5, m_intake) );



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public XboxController getXboxController1() {
      return xboxController1;
    }

public Joystick getJoystickCoDriver() {
        return joystickCoDriver;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

