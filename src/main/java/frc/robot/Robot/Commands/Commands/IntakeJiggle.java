package frc.robot.Robot.Commands.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot.Commands.Subsystems.IntakeSubsystem;

public class IntakeJiggle extends Command{
    IntakeSubsystem intake;
    boolean isFinished;
    public IntakeJiggle(IntakeSubsystem intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    @Override
    public void initialize(){
        isFinished = false;
    }

    @Override 
    public void execute() {

    }

    @Override
    public void end(boolean interupted) {}

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
