package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;

public class RunServoCommand extends CommandBase{
    private BasicSubsystem subsystem;

    public RunServoCommand(BasicSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }


    @Override
    public void execute() {
        subsystem.runServo();
    }

    @Override
    public boolean isFinished() {
        return subsystem.isTouchSensorPressed();
    }
}
