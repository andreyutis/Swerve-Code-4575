package frc.robot.Robot.Commands.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot.Commands.Subsystems.AdvancerSubsystem;

public class AdvancerJiggle extends Command{
    AdvancerSubsystem advancer;
    boolean isFinished;
    double jiggle_count;
    public AdvancerJiggle(AdvancerSubsystem advancer, double jiggle_count) {
        this.advancer = advancer;
        this.jiggle_count = jiggle_count;
        addRequirements(advancer);
    }

    @Override
    public void initialize(){
        isFinished = false;
    }

    @Override 
    public void execute() {
        advancer.Jiggle(Math.round(jiggle_count));
        isFinished = true;
    }

    @Override
    public void end(boolean interupted) {}

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
