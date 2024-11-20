package frc.robot.Robot.Commands.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OverideSubsystem extends SubsystemBase{
    boolean isFinished;
    IntakeSubsystem intake;
    ShooterSubsystem shooter;
    AdvancerSubsystem advancer;
    public OverideSubsystem(IntakeSubsystem intake, ShooterSubsystem shooter, AdvancerSubsystem advancer) {
        this.advancer = advancer;
        this.intake = intake;
        this.shooter = shooter;
    }
}
