package org.firstinspires.ftc.teamcode.BasicExample.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.BasicExample.subsystem.WristSubsystem;

public class LowerWrist extends CommandBase {
    private WristSubsystem subsystem;
    public LowerWrist(WristSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.down();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
