package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.IntakeSubsystem;

public class ToggleAlliance extends CommandBase{
    private IntakeSubsystem subsystem;

    public ToggleAlliance(IntakeSubsystem subsystem) {
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
