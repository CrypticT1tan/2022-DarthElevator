package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class TelopElevator extends CommandBase {
    private Elevator m_elevator;
    private DoubleSupplier getLeft;
    private DoubleSupplier getRight;
    private double speed;
    private double velocityMultiplier = 0.6;

    public TelopElevator(Elevator elevator, DoubleSupplier left, DoubleSupplier right) {
        this.m_elevator = elevator;
        this.getLeft = left;
        this.getRight = right;
        addRequirements(m_elevator);
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double up = getLeft.getAsDouble();
        double down = getRight.getAsDouble()*-1;
        this.speed = up + down;
        this.m_elevator.setRiseFall(this.speed);
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
