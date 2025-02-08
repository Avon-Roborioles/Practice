package org.firstinspires.ftc.teamcode.BasicExample.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.BasicExample.subsystem.PracticeDrive;

import java.util.function.DoubleSupplier;

public class PracticeDriveCommand extends CommandBase {
    private PracticeDrive driveSubsystem;
    private DoubleSupplier strafe, forward, turn, gyroAngle;
    private boolean fieldCentric;

    public PracticeDriveCommand(PracticeDrive driveSubsystem,
                                DoubleSupplier strafe,
                                DoubleSupplier forward,
                                DoubleSupplier turn,
                                DoubleSupplier gyroAngle,
                                boolean fieldCentric) {
        this.driveSubsystem = driveSubsystem;
        this.strafe = strafe;
        this.forward = forward;
        this.turn = turn;
        this.gyroAngle = gyroAngle;
        this.fieldCentric = fieldCentric;
        addRequirements(driveSubsystem);

    }
    @Override
    public void execute() {

        driveSubsystem.drive(strafe.getAsDouble(),
                forward.getAsDouble(),
                turn.getAsDouble(),
                gyroAngle.getAsDouble(),
                fieldCentric);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
