package frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveTrainConstants {
    public static final TalonFX leftMaster = new TalonFX(GlobalConstants.leftMaster);
    public static final TalonFX rightMaster = new TalonFX(GlobalConstants.rightMaster);
    public static final VictorSPX leftFollower1 = new VictorSPX(GlobalConstants.leftFollower1);
    public static final VictorSPX leftFollower2 = new VictorSPX(GlobalConstants.leftFollower2);
    public static final VictorSPX rightFollower1 = new VictorSPX(GlobalConstants.rightFollower1);
    public static final VictorSPX rightFollower2 = new VictorSPX(GlobalConstants.rightFollower2);

    static {
        leftMaster.setInverted(true);
        leftFollower1.setInverted(true);
        leftFollower2.setInverted(true);
    }
}
