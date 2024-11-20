// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Robot.Commands;

import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Robot.Commands.Commands.AdvancerJiggle;
import frc.robot.Robot.Commands.Commands.AutoRevShooter;
import frc.robot.Robot.Commands.Commands.ChangeShot;
import frc.robot.Robot.Commands.Commands.DriveTrain;
import frc.robot.Robot.Commands.Commands.IntakeLoad;
import frc.robot.Robot.Commands.Commands.IntakeOut;
import frc.robot.Robot.Commands.Commands.RetractToBottom;
import frc.robot.Robot.Commands.Commands.ShooterIntake;
import frc.robot.Robot.Commands.Commands.ShooterLob;
import frc.robot.Robot.Commands.Commands.SpeakerShoot;
import frc.robot.Robot.Commands.Commands.TelopSwerve;
import frc.robot.Robot.Commands.Constanst.JoystickConstants;
import frc.robot.Robot.Commands.Subsystems.*;

public class RobotContainer {
  
  /* Controllers */
    private final Joystick driver = new Joystick(JoystickConstants.DRIVER_USB);
    private final Joystick operator = new Joystick(JoystickConstants.OPERATOR_USB);

  /* Drive Controls */
    private final int translationAxis = JoystickConstants.LEFT_Y_AXIS;
    private final int strafeAxis = JoystickConstants.LEFT_X_AXIS;
    private final int rotationAxis = JoystickConstants.RIGHT_X_AXIS;

  /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, JoystickConstants.BACK_BUTTON);

  /* Subsystems */
    private final LimelightSubsystem limelight = new LimelightSubsystem();
    private final AdvancerSubsystem advancer = new AdvancerSubsystem();
    private final ShooterSubsystem shooter = new ShooterSubsystem();
    private final IntakeSubsystem intake = new IntakeSubsystem();
    private final DriveTrain s_swerve = new DriveTrain();

  public RobotContainer() {
    double jiggle_count = SmartDashboard.getNumber("Advancer Jiggle Number Auto", 5);
    s_swerve.setDefaultCommand(
      new TelopSwerve(
        s_swerve,
        () -> -driver.getRawAxis(translationAxis), 
        () -> -driver.getRawAxis(strafeAxis), 
        () -> -driver.getRawAxis(rotationAxis)
        )
    );
    
    configureBindings();
      /* Intake */
        NamedCommands.registerCommand("Intake", new IntakeLoad(intake, advancer));
        NamedCommands.registerCommand("Outtake", new IntakeOut(intake, advancer));
      /* Shooter Commands*/
        NamedCommands.registerCommand("Speaker Shot", new SpeakerShoot(shooter, advancer));
        NamedCommands.registerCommand("Lob shot", new ShooterLob(shooter, advancer));
        NamedCommands.registerCommand("Rev Shooter", new AutoRevShooter(shooter));
      /* Advancer Commands */   
        NamedCommands.registerCommand("Advancer Jiggle", new AdvancerJiggle(advancer, jiggle_count));
  }

  public void teleopInit() {
    shooter.Stop();
    intake.Stop();
    advancer.Stop();
  }

  private void configureBindings() {
    /* Driver Controls */
      zeroGyro.onTrue (new InstantCommand(() -> s_swerve.ResetDrives()));

    /* Operator Controls */
      /* Shooter Controls */
        new JoystickButton (operator, JoystickConstants.GREEN_BUTTON).onTrue(new SpeakerShoot(shooter, advancer));
        new Trigger (new JoystickButton(operator, JoystickConstants.GREEN_BUTTON)).and(
          new Trigger(() -> (advancer.LowerBeam.get()))).onTrue(new ParallelCommandGroup(new ShooterIntake(shooter), new RetractToBottom(advancer)));
        new Trigger(() -> limelight.InRange(5)).and(new Trigger(() -> (advancer.LowerBeam.get())))
          .onTrue(new AutoRevShooter(shooter));
        new JoystickButton (operator, JoystickConstants.BLUE_BUTTON).onTrue(new ShooterLob(shooter, advancer));
        new JoystickButton (operator, JoystickConstants.YELLOW_BUTTON).onTrue(new ChangeShot(shooter, advancer));
      /* Intake Controls */
        new JoystickButton (operator, JoystickConstants.RIGHT_BUMPER).onTrue(new IntakeLoad(intake, advancer));
        new JoystickButton (operator, JoystickConstants.LEFT_BUMPER).onTrue(new IntakeOut(intake, advancer));
      /* Advancer stuff */
        new JoystickButton (operator, JoystickConstants.START_BUTTON).onTrue(new AdvancerJiggle(advancer, SmartDashboard.getNumber("Advancer Jiggle Number Teleop", 5)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
