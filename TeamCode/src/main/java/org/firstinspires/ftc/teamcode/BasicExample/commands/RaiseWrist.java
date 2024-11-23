package org.firstinspires.ftc.teamcode.BasicExample.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.BasicExample.subsystem.WristSubsystem;

public class RaiseWrist extends CommandBase {
    private WristSubsystem subsystem;
    public RaiseWrist(WristSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }
    @Override
    public void initialize() {
        subsystem.up();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
