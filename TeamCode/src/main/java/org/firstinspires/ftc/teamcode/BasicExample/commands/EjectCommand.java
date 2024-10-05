package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;

public class EjectCommand extends CommandBase{
    private BasicSubsystem subsystem;

    public EjectCommand(BasicSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.runServo();
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopServo();
    }

    @Override
    public boolean isFinished() {
        return !subsystem.isTouchSensorPressed();
    }
}
