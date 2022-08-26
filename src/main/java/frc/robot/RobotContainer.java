// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TelopDriveTrain;
import frc.robot.commands.TelopElevator;
import frc.robot.commands.TelopGrabber;
import frc.robot.constants.DriveTrainConstants;
import frc.robot.constants.ElevatorConstants;
import frc.robot.constants.GrabberConstants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Grabber;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    scheduler.registerSubsystem(m_drivetrain);
    scheduler.registerSubsystem(m_grabber);
    m_drivetrain.setDefaultCommand(new TelopDriveTrain(m_drivetrain, mainController::getLeftY, mainController::getRightX));
    m_grabber.setDefaultCommand(new TelopGrabber(m_grabber, mainController::getXButton, mainController::getLeftBumper, mainController::getRightBumper)); 
    m_elevator.setDefaultCommand(new TelopElevator(m_elevator, mainController::getLeftTriggerAxis, mainController::getRightTriggerAxis));
    // Configure the button bindings
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  private XboxController mainController = new XboxController(0);
  private DriveTrain m_drivetrain = new DriveTrain(
    DriveTrainConstants.leftMaster, 
    DriveTrainConstants.rightMaster, 
    DriveTrainConstants.leftFollower1, 
    DriveTrainConstants.leftFollower2, 
    DriveTrainConstants.rightFollower1, 
    DriveTrainConstants.rightFollower2);

  private Grabber m_grabber = new Grabber(
    GrabberConstants.intakeLeftMotor, 
    GrabberConstants.intakeRightMotor,
    GrabberConstants.solenoid,
    GrabberConstants.sensor);

  private Elevator m_elevator = new Elevator(
    ElevatorConstants.leftMaster,
    ElevatorConstants.rightMaster,
    ElevatorConstants.leftFollower,
    ElevatorConstants.rightFollower);

  private CommandScheduler scheduler = CommandScheduler.getInstance();

}
