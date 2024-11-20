package frc.robot.Robot.Commands.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot.Commands.Constanst;
import frc.robot.Robot.Commands.Subsystems.AdvancerSubsystem;
import frc.robot.Robot.Commands.Subsystems.IntakeSubsystem;
import frc.robot.Robot.Commands.Subsystems.ShooterSubsystem;

public class TestInformation extends Command{
    IntakeSubsystem intake;
    AdvancerSubsystem advancer;
    ShooterSubsystem shooter;

    boolean isFinished;
    public TestInformation(IntakeSubsystem intake, AdvancerSubsystem advancer, ShooterSubsystem shooter) {
        this.advancer = advancer;
        this.intake = intake;
        this.shooter = shooter;
        addRequirements(intake, advancer, shooter);
    }
    
    @Override
    public void initialize(){
        /* Ints */
            System.out.println("Advancer Motor:");
            System.out.print(Constanst.AdvancerConstansts.ADVANCER_MOTOR);

            System.out.println("Upper Address DIO:");
            System.out.print(Constanst.AdvancerConstansts.UPPER_ADDRESS_DIO);

            System.out.println("Lower Address DIO:");
            System.out.print(Constanst.AdvancerConstansts.LOWER_ADDRESS_DIO);

            System.out.println("Shooter Upper Address:");
            System.out.print(Constanst.ShooterConstansts.UPPER_ADDRESS);

            System.out.println("Shooter Lower Address:");
            System.out.print(Constanst.ShooterConstansts.LOWER_ADDRESS);

            System.out.println("Intake Motor:");
            System.out.print(Constanst.IntakeConstansts.INTAKE_MOTOR);
        /* Ints */

        /* Doubles */
            System.out.println("Advance To Shoot:");
            System.out.print(Constanst.AdvancerConstansts.AdvanceToShoot);

            System.out.println("Advance To Top Upper Beam:");
            System.out.print(Constanst.AdvancerConstansts.AdvanceToTop_UPPER_BEAM);

            System.out.println("Advance To Top Lower Beam:");
            System.out.print(Constanst.AdvancerConstansts.AdvanceToTop_LOWER_BEAM);

            System.out.println("Align To Top False:");
            System.out.print(Constanst.AdvancerConstansts.AlignToTop_FALSE);

            System.out.println("Align To Top True:");
            System.out.print(Constanst.AdvancerConstansts.AlignToTop_TRUE);

            System.out.println("Shooter 1 Speed in Speaker Shot:");
            System.out.print(Constanst.ShooterConstansts.shooter1Speed_in_SPEAKER_SHOT);

            System.out.println("Shooter 2 Speed in Speaker Shot:");
            System.out.print(Constanst.ShooterConstansts.shooter2Speed_in_SPEAKER_SHOT);

            System.out.println("Shooter 1 Speed in Intake:");
            System.out.print(Constanst.ShooterConstansts.shooter1Speed_in_INTAKE);

            System.out.println("Shooter 2 Speed in Intake:");
            System.out.print(Constanst.ShooterConstansts.shooter2Speed_in_INTAKE);

            System.out.println("Intake Load Speed NEO:");
            System.out.print(Constanst.IntakeConstansts.INTAKE_LOAD_SPEED_NEO);

            System.out.println("Intake Out Speed NEO:");
            System.out.print(Constanst.IntakeConstansts.INTAKE_OUT_SPEED_NEO);

            System.out.println("Intake Load Speed Kracken:");
            System.out.print(Constanst.IntakeConstansts.INTAKE_LOAD_SPEED_KRACKEN);

            System.out.println("Intake Out Speed Kracken:");
            System.out.print(Constanst.IntakeConstansts.INTAKE_OUT_SPEED_KRACKEN);

            System.out.println("Jiggle Speed NEO:");
            System.out.print(Constanst.IntakeConstansts.JIGGLE_SPEED_NEO);
        /* Doubles */
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
