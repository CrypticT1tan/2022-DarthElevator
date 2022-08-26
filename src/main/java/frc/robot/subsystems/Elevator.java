package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private TalonSRX leftMaster;
    private TalonSRX rightMaster;
    private VictorSPX leftFollower;
    private VictorSPX rightFollower;
    PeriodicIO pIO = new PeriodicIO();

    private class PeriodicIO {
        private double velocity;
    }

    public Elevator(TalonSRX leftMaster, TalonSRX rightMaster, VictorSPX leftFollower, VictorSPX rightFollower) {
        this.leftMaster = leftMaster;
        this.rightMaster = rightMaster;
        this.leftFollower = leftFollower;
        this.rightFollower = rightFollower;
    }

    @Override
    public void periodic() {
        this.leftMaster.set(ControlMode.PercentOutput, pIO.velocity);
        this.rightMaster.set(ControlMode.PercentOutput, pIO.velocity);
    }

    public void setRiseFall(double speed) {
        this.pIO.velocity = speed;
    }
}
