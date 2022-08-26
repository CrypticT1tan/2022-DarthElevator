package frc.robot.constants;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.constants.GlobalConstants;

public class GrabberConstants {
    public static final VictorSPX intakeLeftMotor = new VictorSPX(GlobalConstants.intakeLeft);
    public static final VictorSPX intakeRightMotor = new VictorSPX(GlobalConstants.intakeRight);
    public static final DoubleSolenoid solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
    public static final DigitalInput sensor = new DigitalInput(4);
}
