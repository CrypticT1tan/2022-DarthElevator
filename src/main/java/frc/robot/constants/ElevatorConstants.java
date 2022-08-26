package frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ElevatorConstants {
    public static final TalonSRX leftMaster = new TalonSRX(GlobalConstants.elevatorLeftMaster);
    public static final TalonSRX rightMaster = new TalonSRX(GlobalConstants.elevatorRightMaster);
    public static final VictorSPX leftFollower = new VictorSPX(GlobalConstants.elevatorLeftFollower);
    public static final VictorSPX rightFollower = new VictorSPX(GlobalConstants.elevatorRightFollower);

    static{
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
    }

}
