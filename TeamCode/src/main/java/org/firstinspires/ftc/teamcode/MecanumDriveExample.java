package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MecanumDriveExample extends LinearOpMode {
    static final boolean FIELD_CENTRIC = false;

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(
                new Motor(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "frontRight", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_312)
        );

        GamepadEx driverOp = new GamepadEx(gamepad1);

        waitForStart();
        while(!isStopRequested()) {
            drive.driveRobotCentric(
                    driverOp.getLeftY(),
                    driverOp.getLeftX(),
                    driverOp.getRightX(),
                    FIELD_CENTRIC
            );
        }
    }
}
