package org.firstinspires.ftc.teamcode.BasicExample.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.BasicExample.subsystem.ExtensionSubsystem;

public class RetractCommand extends CommandBase {
    private ExtensionSubsystem subsystem;
    public RetractCommand(ExtensionSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }
    @Override
    public void initialize() {
        subsystem.retract();
    }
    @Override
    public boolean isFinished() {
        return true;
    }
}
