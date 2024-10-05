package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;

public class AcceptCommand extends CommandBase{
    private BasicSubsystem subsystem;

    public AcceptCommand(BasicSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        if (subsystem.getRedAlliance()) {
           if (subsystem.isColorSensorBlue()) {
               new EjectCommand(subsystem);
               // call eject command
           } else {
               // keep sample and proceed to next step
           }
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
