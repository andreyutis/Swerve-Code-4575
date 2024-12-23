package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.AdvancerSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class ShooterLob extends Command {
    private ShooterSubsystem shooter;
    private AdvancerSubsystem advancer;
    private boolean isFinished;
    public ShooterLob(ShooterSubsystem shooter, AdvancerSubsystem advancer) {
        this.advancer = advancer;
        this.shooter = shooter;
        addRequirements(shooter, advancer);
    }

    @Override
    public void initialize(){
        isFinished = false;
        if (advancer.AlignToTop()) {
				shooter.Stop();
				advancer.Stop();
			}
    }

    @Override 
    public void execute() {
        if(shooter.ChangeShoot(.5,.5)) {
            if (advancer.AdvanceToShoot()) {
                isFinished = true;
            }
        }
    }

    @Override
    public void end(boolean interupted) {}

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
