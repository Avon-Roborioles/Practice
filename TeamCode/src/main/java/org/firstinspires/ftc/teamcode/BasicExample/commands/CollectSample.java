package org.firstinspires.ftc.teamcode.BasicExample.commands;
import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;
import com.arcrobotics.ftclib.util.Timing;

import java.util.concurrent.TimeUnit;


public class CollectSample extends CommandBase{
    private BasicSubsystem subsystem;
    private boolean hasSample = false;
    private boolean validSample = false;
    boolean ejecting = false;
    Timing.Timer timer = new Timing.Timer(3, TimeUnit.SECONDS);

    // This command will acquire samples and either eject them or accept them based on color
    public CollectSample(BasicSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        hasSample = false;
        validSample = false;
        ejecting = false;
    }

    @Override
    public void execute() {
        hasSample = subsystem.isTouchSensorPressed();

        if (ejecting & !timer.done()) {
            subsystem.runServo();
        } else {
            ejecting = false;
            subsystem.stopServo();
        }

        if (!hasSample & !ejecting) {
            subsystem.runServo();
        }
        if (hasSample & !ejecting) {
            if (subsystem.getRedAlliance() & subsystem.isColorSensorRed() |
                    subsystem.isColorSensorYellow()) {
                validSample = true;
            } else if (!subsystem.getRedAlliance() & subsystem.isColorSensorBlue() |
                    subsystem.isColorSensorYellow()){
                validSample = true;
            } else {
                // sample is not valid; eject
                validSample = false;
                ejecting = true;
                timer.start();
            }
        }
        if (!validSample & hasSample) {
            subsystem.runServo();
        }
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopServo();
    }

    @Override
    public boolean isFinished() {
        return validSample;
    }
}
