package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.AdvancerSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class Overide extends Command {
    boolean isFinished;
    IntakeSubsystem intake;
    ShooterSubsystem shooter;
    AdvancerSubsystem advancer;
    public Overide(IntakeSubsystem intake, ShooterSubsystem shooter, AdvancerSubsystem advancer) {
        this.advancer = advancer;
        this.intake = intake;
        this.shooter = shooter;
        addRequirements(intake, shooter, advancer);
    }
    
    @Override
    public void initialize(){
        isFinished = false;
    }

    @Override 
    public void execute() {
        shooter.Stop();
        advancer.Stop();
        intake.Stop();
    }

    @Override
    public void end(boolean interupted) {}

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
