package frc.robot;

public class Constanst {
    public static final double stickDeadband = 0.3;
    
    public static final class AdvancerConstansts {
        public static final int ADVANCER_MOTOR = 12;
        public static final int UPPER_ADDRESS_DIO = 0;
        public static final int LOWER_ADDRESS_DIO = 1;

        public static final double AdvanceToTop_UPPER_BEAM = -1.0;
        public static final double AdvanceToTop_LOWER_BEAM = -0.7;
        public static final double AlignToTop_FALSE = 0.2;
        public static final double AlignToTop_TRUE = -0.1;
        public static final double AdvanceToShoot = -0.2;
    }

    public static final class ShooterConstansts {
        public static final int UPPER_ADDRESS = 15;
        public static final int LOWER_ADDRESS = 16;
        
        public static final double shooter1Speed_in_SPEAKER_SHOT = -0.4;
        public static final double shooter2Speed_in_SPEAKER_SHOT = 1;
        public static final double shooter1Speed_in_INTAKE = 0.2;
        public static final double shooter2Speed_in_INTAKE = -0.2;
    }

    public static final class IntakeConstansts {
        public static final int INTAKE_MOTOR = 14;

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
