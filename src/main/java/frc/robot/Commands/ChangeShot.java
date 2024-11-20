package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.AdvancerSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;

public class ChangeShot extends Command {
    private ShooterSubsystem shooter;
    private AdvancerSubsystem advancer;
    private boolean isFinished;
    public ChangeShot(ShooterSubsystem shooter, AdvancerSubsystem advancer) {
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
        double top_shooter;
        double bottom_shooter;
        top_shooter = -SmartDashboard.getNumber("Lower Shot", 0);
        bottom_shooter = SmartDashboard.getNumber("Upper Shot", 0);
        if(shooter.ChangeShoot(top_shooter, bottom_shooter)) {
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
