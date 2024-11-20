package frc.robot.Robot.Commands.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot.Commands.Subsystems.AdvancerSubsystem;
import frc.robot.Robot.Commands.Subsystems.ShooterSubsystem;

public class ShooterIntake extends Command {
    private ShooterSubsystem shooter;
    private AdvancerSubsystem advancer;
    private boolean isFinished;
    public ShooterIntake (ShooterSubsystem shooter, AdvancerSubsystem advancer) {
        this.advancer = advancer;
        this.shooter = shooter;
        addRequirements(shooter, advancer);
    }

    @Override
    public void initialize(){
        isFinished = false;
    }

    @Override 
    public void execute() {
        shooter.Intake();
    }

    @Override
    public void end(boolean interupted) {
		shooter.Stop();
		advancer.Stop();
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
