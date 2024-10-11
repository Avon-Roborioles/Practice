package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;

public class CancelCommand extends CommandBase{
    private BasicSubsystem subsystem;

    public CancelCommand(BasicSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.stopMotor();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
