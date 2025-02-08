package org.firstinspires.ftc.teamcode.BasicExample.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;

public class PracticeDrive extends SubsystemBase {
    private MecanumDrive drive;
    private Motor frontLeft, frontRight, backLeft, backRight;

    public PracticeDrive(Motor frontLeft, Motor frontRight, Motor backLeft, Motor backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        this.drive = new MecanumDrive(false, frontLeft, frontRight, backRight, backLeft);
    }

    public void drive(double strafe, double forward, double turn, double gyroAngle, boolean fieldCentric) {
        backRight.setInverted(false);
        backLeft.setInverted(false);
        frontRight.setInverted(true);
        backLeft.setInverted(false);

        if (fieldCentric) {
            drive.driveFieldCentric(strafe, forward, turn, gyroAngle);
        } else {
            drive.driveRobotCentric(strafe, forward, turn);
        }
    }
}
