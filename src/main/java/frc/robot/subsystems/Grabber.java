package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Grabber extends SubsystemBase{

    private VictorSPX left;
    private VictorSPX right;
    private DoubleSolenoid solenoid;
    private DigitalInput sensor;
    private boolean sensorState;
    PeriodicIO pIO = new PeriodicIO();

    private class PeriodicIO {
        private boolean solenoidState;
        private double velocity;
    }

    public Grabber(VictorSPX left, VictorSPX right, DoubleSolenoid solenoid, DigitalInput input) {
        this.left = left;
        this.right = right;
        this.solenoid = solenoid;
        this.sensor = input;
        this.sensorState = false;
    }

    @Override
    public void periodic() {
        this.left.set(ControlMode.PercentOutput, pIO.velocity);
        this.right.set(ControlMode.PercentOutput, pIO.velocity);
        if (this.pIO.solenoidState) {
            this.solenoid.set(Value.kForward);
        } else {
            this.solenoid.set(Value.kReverse);
        }
        this.sensorState = sensor.get();
        SmartDashboard.putBoolean("Banner Sensor", this.sensorState);
    }

    public void setRollers(double velo) {
        this.pIO.velocity = velo;
    }

    public void setSolenoid(boolean state) {
        this.pIO.solenoidState = state;
    }
}
