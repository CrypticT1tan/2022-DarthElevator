package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private final TalonFX leftMaster;
    private final TalonFX rightMaster;
    private final VictorSPX leftFollower1;
    private final VictorSPX leftFollower2;
    private final VictorSPX rightFollower1;
    private final VictorSPX rightFollower2;

    private static PeriodicIO pIO = new PeriodicIO();

    public static class PeriodicIO {
        public double leftOutput = 0;
        public double rightOutput = 0;
    }
    public DriveTrain(TalonFX leftMaster, TalonFX rightMaster, VictorSPX leftFollower1, VictorSPX leftFollower2, VictorSPX rightFollower1, VictorSPX rightFollower2) {
        this.leftMaster = leftMaster;
        this.rightMaster = rightMaster;
        this.leftFollower1 = leftFollower1;
        this.leftFollower2 = leftFollower2;
        this.rightFollower1 = rightFollower1;
        this.rightFollower2 = rightFollower2;
    }
    public void periodic() {
        this.leftMaster.set(ControlMode.PercentOutput, pIO.leftOutput);
        this.rightMaster.set(ControlMode.PercentOutput, pIO.rightOutput);
    }
    public void setOpenLoop(double leftSide, double rightSide) {
        pIO.leftOutput = leftSide;
        pIO.rightOutput = rightSide;
    }
}
