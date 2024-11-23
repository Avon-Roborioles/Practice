package org.firstinspires.ftc.teamcode.BasicExample.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.BasicExample.subsystem.ExtensionSubsystem;

public class ExtendCommand extends CommandBase {
    private ExtensionSubsystem subsystem;

    public ExtendCommand(ExtensionSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.extend();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
