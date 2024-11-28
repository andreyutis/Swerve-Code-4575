package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MetricsProvider {

    private static final Field2d location = new Field2d();

    public static void registerMetrics() {
        SmartDashboard.putData("location", location);
    }

    public static void updateLocation(Pose2d pose) {
        location.setRobotPose(pose);
    }

}
