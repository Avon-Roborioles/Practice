package org.firstinspires.ftc.teamcode.BasicExample;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;

import org.firstinspires.ftc.teamcode.BasicExample.commands.AcceptCommand;
import org.firstinspires.ftc.teamcode.BasicExample.commands.ToggleAlliance;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.BasicSubsystem;
import org.firstinspires.ftc.teamcode.BasicExample.commands.RunServoCommand;

@TeleOp
public class BasicOpMode extends CommandOpMode {
    private BasicSubsystem subsystem;
    private GamepadEx gamepad;

    @Override
    public void initialize() {
        subsystem = new BasicSubsystem(telemetry, hardwareMap.get(DcMotor.class, "motor"),
                hardwareMap.get(CRServo.class, "servo"),
                hardwareMap.get(TouchSensor.class, "touchSensor"),
                hardwareMap.get(ColorSensor.class, "colorSensor"),
                hardwareMap.get(RevBlinkinLedDriver.class, "blinkin"));
        gamepad = new GamepadEx(gamepad1);

        gamepad.getGamepadButton(GamepadKeys.Button.A)
                .whenPressed(new RunServoCommand(subsystem));
        gamepad.getGamepadButton(GamepadKeys.Button.B)
                .whenPressed(new AcceptCommand(subsystem));
        gamepad.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new ToggleAlliance(subsystem));

    }

}
