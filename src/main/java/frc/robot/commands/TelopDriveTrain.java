package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TelopDriveTrain extends CommandBase {
    private DriveTrain m_drivetrain;
    private DoubleSupplier throttle;
    private DoubleSupplier rotation;
    private double velocityMultiplier = 0.5;

    public TelopDriveTrain(DriveTrain drivetrain, DoubleSupplier throttle, DoubleSupplier rotation) {
        this.m_drivetrain = drivetrain;
        this.throttle = throttle;
        this.rotation = rotation;
        addRequirements(m_drivetrain);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double leftSide = (throttle.getAsDouble() + rotation.getAsDouble()) * this.velocityMultiplier;
        double rightSide = (throttle.getAsDouble() - rotation.getAsDouble()) * this.velocityMultiplier;
        this.m_drivetrain.setOpenLoop(leftSide, rightSide);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
