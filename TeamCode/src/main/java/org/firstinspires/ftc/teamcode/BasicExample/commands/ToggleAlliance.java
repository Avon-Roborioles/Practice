package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;

public class ToggleAlliance extends CommandBase{
    private BasicSubsystem subsystem;

    public ToggleAlliance(BasicSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.changeAlliance();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
