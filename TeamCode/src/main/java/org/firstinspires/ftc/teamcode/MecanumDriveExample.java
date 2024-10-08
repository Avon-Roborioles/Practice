package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.IMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class MecanumDriveExample extends LinearOpMode {
    static final boolean FIELD_CENTRIC = true;

    @Override
    public void runOpMode() throws InterruptedException {
        MecanumDrive drive = new MecanumDrive(
                new Motor(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "frontRight", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_312)
        );

        IMU imu = hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection;
        RevHubOrientationOnRobot.UsbFacingDirection usbDirection;

        logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        usbDirection = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);

        imu.initialize(new IMU.Parameters(orientationOnRobot));

        GamepadEx driverOp = new GamepadEx(gamepad1);

        waitForStart();
        while(!isStopRequested()) {
            if (!FIELD_CENTRIC) {

                drive.driveRobotCentric(
                        driverOp.getLeftY(),
                        driverOp.getLeftX(),
                        driverOp.getRightX(),
                        false);
            } else {
                drive.driveFieldCentric(
                        driverOp.getLeftY(),
                        driverOp.getLeftX(),
                        driverOp.getRightX(),
                        imu.,
                        false);
            }
        }
    }
}
