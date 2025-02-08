package org.firstinspires.ftc.teamcode.BasicExample.commands;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.BasicExample.subsystem.ImuSubsystem;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.PracticeDrive;

@TeleOp(name = "Magic")
public class PracticeOPCommand extends CommandOpMode {

    private GamepadEx driverOp, operatorOp;

    private PracticeDrive practiceDriveSubsystem;
    private ImuSubsystem imuSubsystem;

    @Override
    public void initialize() {
        driverOp = new GamepadEx(gamepad1);
        operatorOp = new GamepadEx(gamepad2);
        // sets IMU parameters and defines reference variables
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection;
        RevHubOrientationOnRobot.UsbFacingDirection usbDirection;
        logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        usbDirection = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        // Defines IMU
        imuSubsystem = new ImuSubsystem(hardwareMap.get(IMU.class, "imu"),
                orientationOnRobot);

        practiceDriveSubsystem = new PracticeDrive(
                new Motor(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "frontRight", Motor.GoBILDA.RPM_312),
                new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_312));

        practiceDriveSubsystem.setDefaultCommand(new PracticeDriveCommand(practiceDriveSubsystem,
                driverOp::getLeftX, driverOp::getLeftY, driverOp::getRightX,
                imuSubsystem::getYawDeg, true));
    }

    }
