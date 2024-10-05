package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;

public class AcceptCommand extends CommandBase{
    private BasicSubsystem subsystem;

    public AcceptCommand(BasicSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        subsystem.runServo();
    }

    @Override
    public boolean isFinished() {
        return subsystem.isColorSensorRed() || subsystem.isColorSensorYellow();
    }
}
