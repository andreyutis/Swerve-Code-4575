package frc.robot;

import frc.robot.Commands.DriveTrain;

public class Constanst {
    public static final double stickDeadband = 0.3;
    
    public static final class SwerveConstants {
        /* Ints */
            public static final int kEncoderResolution = 4096;
        /* Doubles */
            public static final double kWheelRadius = 0.0508;
            public static final double kModuleMaxAngularVelocity = DriveTrain.kMaxAngularSpeed;
            public static final double kModuleMaxAngularAcceleration = 18.85;//4 * Math.PI; // radians per second squared
            // FWF - stole this from 6328's code, each gear reduction written out. Final is 6.75. 39.37 converts inches to meters so we can be european fancy
            //private final double driveAfterEncoderReduction = (50.0 / 14.0) * (17.0 / 27.0) * (45.0 / 15.0);
            public static final double driveAfterEncoderReduction = (4.0 / 39.37) * Math.PI * (1/6.75);
            public static final double turnAfterEncoderReduction = -1 * (7/150);
  
    }
    
    public static final class AdvancerConstansts {
        /* Ints */
            public static final int ADVANCER_MOTOR = 12;
            public static final int UPPER_ADDRESS_DIO = 0;
            public static final int LOWER_ADDRESS_DIO = 1;
        /* Doubles */
            public static final double AdvanceToTop_UPPER_BEAM = -1.0;
            public static final double AdvanceToTop_LOWER_BEAM = -0.7;
            public static final double AlignToTop_FALSE = 0.2;
            public static final double AlignToTop_TRUE = -0.1;
            public static final double AdvanceToShoot = -0.2;
    }

    public static final class ShooterConstansts {
        /* Ints */
            public static final int UPPER_ADDRESS = 15;
            public static final int LOWER_ADDRESS = 16;
        /* Doubles */
            public static final double shooter1Speed_in_SPEAKER_SHOT = -0.4;
            public static final double shooter2Speed_in_SPEAKER_SHOT = 1;
            public static final double shooter1Speed_in_INTAKE = 0.2;
            public static final double shooter2Speed_in_INTAKE = -0.2;
    }

    public static final class IntakeConstansts {
        /* Ints */
            public static final int INTAKE_MOTOR = 14;
        /* Doubles */
            public static final double INTAKE_LOAD_SPEED_NEO = 0.7;
            public static final double INTAKE_OUT_SPEED_NEO = -0.4;
            public static final double INTAKE_LOAD_SPEED_KRACKEN = -0.38;
            public static final double INTAKE_OUT_SPEED_KRACKEN = 0.4;
            public static final double JIGGLE_SPEED_NEO = 0.4;
    }

    public final static class JoystickConstants{
        public final static int DRIVER_USB = 0;
        public final static int OPERATOR_USB = 1;
        public final static int TEST_USB = 2;
        
        public final static int LEFT_Y_AXIS = 1;
        public final static int LEFT_X_AXIS = 0;
        public final static int RIGHT_X_AXIS = 4;
        public final static int RIGHT_Y_AXIS = 5;
    
        public final static int GREEN_BUTTON = 1;
        public final static int RED_BUTTON = 2;
        public final static int YELLOW_BUTTON = 4;
        public final static int BLUE_BUTTON = 3;
    
        public final static int LEFT_TRIGGER = 2;
        public final static int RIGHT_TRIGGER = 3;
        public final static int LEFT_BUMPER = 5;
        public final static int RIGHT_BUMPER = 6;
    
        public final static int BACK_BUTTON = 7;
        public final static int START_BUTTON = 8;
    
        public final static int POV_UP = 0;
        public final static int POV_RIGHT = 90;
        public final static int POV_DOWN = 180;
        public final static int POV_LEFT = 270;
    }
    
}
