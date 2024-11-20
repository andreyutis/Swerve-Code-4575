package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.AdvancerSubsystem;

public class RetractToBottom extends Command{
    AdvancerSubsystem advancer;
    boolean isFinished;
    public RetractToBottom(AdvancerSubsystem advancer) {
        this.advancer = advancer;
        addRequirements(advancer);
    }

    @Override
    public void initialize(){
        isFinished = false;
    }

    @Override 
    public void execute() {
        advancer.RetractToBottom();
        isFinished = true;
    }

    @Override
    public void end(boolean interupted) {}

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}

