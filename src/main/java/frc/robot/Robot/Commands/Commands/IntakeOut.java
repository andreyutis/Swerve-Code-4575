package frc.robot.Robot.Commands.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot.Commands.Subsystems.AdvancerSubsystem;
import frc.robot.Robot.Commands.Subsystems.IntakeSubsystem;

public class IntakeOut extends Command{
    boolean isFinished;
    IntakeSubsystem intake;
    AdvancerSubsystem advancer;
    public IntakeOut (IntakeSubsystem intake, AdvancerSubsystem advancer) {
        this.advancer = advancer;
        this.intake = intake;
        addRequirements(intake);
    }


    @Override
    public void initialize(){
        isFinished = false;
    }

    @Override 
    public void execute() {
        if(intake.Outtake() && advancer.RetractToBottom()) {
            isFinished = true;
        }
    }

    @Override
    public void end(boolean interupted) {}

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
