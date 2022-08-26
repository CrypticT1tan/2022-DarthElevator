package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grabber;

public class TelopGrabber extends CommandBase{
    private Grabber m_grabber;
    private BooleanSupplier xbutton;
    private BooleanSupplier leftbumper;
    private BooleanSupplier rightbumper;

    public TelopGrabber(Grabber grabber, BooleanSupplier x, BooleanSupplier left, BooleanSupplier right) {
        this.m_grabber = grabber;
        this.xbutton = x;
        this.leftbumper = left;
        this.rightbumper = right;
        addRequirements(m_grabber);
        
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        this.m_grabber.setSolenoid(this.xbutton.getAsBoolean());
        if (this.leftbumper.getAsBoolean()) {
            this.m_grabber.setRollers(1.0);
        } else if (this.rightbumper.getAsBoolean()) {
            this.m_grabber.setRollers(-1.0);
        } else if (this.leftbumper.getAsBoolean() && this.rightbumper.getAsBoolean()) {
            this.m_grabber.setRollers(0.0);
        } else {
            this.m_grabber.setRollers(0.0);
        }
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
