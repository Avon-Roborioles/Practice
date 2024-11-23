package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.BasicExample.subsystem.IntakeSubsystem;

import java.util.concurrent.TimeUnit;

public class EjectCommand extends CommandBase{
    private IntakeSubsystem subsystem;
    Timing.Timer timer = new Timing.Timer(2, TimeUnit.SECONDS);

    public EjectCommand(IntakeSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
            subsystem.runMotor();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotor();
    }

    @Override
    public boolean isFinished() {
        return timer.done();
    }
}
