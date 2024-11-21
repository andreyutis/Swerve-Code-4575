package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.AdvancerSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class ShooterIntake extends Command {
    private ShooterSubsystem shooter;
    private boolean isFinished;
    public ShooterIntake (ShooterSubsystem shooter) {
        this.shooter = shooter;
        addRequirements(shooter);
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
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
