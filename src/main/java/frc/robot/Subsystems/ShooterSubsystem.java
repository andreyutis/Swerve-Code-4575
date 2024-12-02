package frc.robot.Subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constanst;

import org.springframework.stereotype.Component;

import com.revrobotics.spark.SparkMax;

@Component
public class ShooterSubsystem extends SubsystemBase{
    private SparkMax upperShooter;
    private SparkMax lowerShooter;

    private int cyclesUpToSpeed = 0;

    public ShooterSubsystem () {
        upperShooter = new SparkMax (Constanst.ShooterConstansts.UPPER_ADDRESS, MotorType.kBrushless);
        lowerShooter = new SparkMax (Constanst.ShooterConstansts.LOWER_ADDRESS, MotorType.kBrushless);
    }

    private boolean RunShooter (double shooter1Speed_in, double shooter2Speed_in) {
        upperShooter.set(shooter1Speed_in);
        lowerShooter.set(shooter2Speed_in);
        
        return (Math.abs(upperShooter.getEncoder().getVelocity() / 5300.0) >= Math.abs(0.9 * shooter1Speed_in))
            && (Math.abs(lowerShooter.getEncoder().getVelocity() / 5300.0) >= Math.abs(0.9 * shooter2Speed_in));
    }

    public boolean Shoot () {
//        return (RunShooter(-1.0, 1.0));
        return (RunShooter(Constanst.ShooterConstansts.shooter1Speed_in_SPEAKER_SHOT, 
        Constanst.ShooterConstansts.shooter2Speed_in_SPEAKER_SHOT));
    }
    public boolean Shoot (int waitCycles) {
        if (RunShooter(Constanst.ShooterConstansts.shooter1Speed_in_SPEAKER_SHOT, 
        Constanst.ShooterConstansts.shooter2Speed_in_SPEAKER_SHOT)) {
            cyclesUpToSpeed++;
            return (cyclesUpToSpeed >= waitCycles);
        }
        cyclesUpToSpeed = 0;
        return false;
    }
    public boolean Intake () {
        RunShooter(Constanst.ShooterConstansts.shooter1Speed_in_INTAKE, 
        Constanst.ShooterConstansts.shooter2Speed_in_INTAKE);
        return true;
//        return (RunShooter(0.5, -0.5));
    }
    public void Stop () {
        RunShooter(0, 0);
    }
    public boolean ChangeShoot (double top_shooter, double bottom_shooter) {
        return (RunShooter(top_shooter, bottom_shooter));
    }
}
