package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.AdvancerSubsystem;
import frc.robot.Subsystems.IntakeSubsystem;

public class IntakeLoad extends Command{
    boolean isFinished;
    IntakeSubsystem intake;
    AdvancerSubsystem advancer;
    public IntakeLoad (IntakeSubsystem intake, AdvancerSubsystem advancer) {
        this.advancer = advancer;
        this.intake = intake;
        addRequirements(intake, advancer);
    }


    @Override
    public void initialize(){
        isFinished = false;
    }

    @Override 
    public void execute() {
        if(intake.Load() && advancer.AdvanceToShoot()) {
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interupted) {
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
