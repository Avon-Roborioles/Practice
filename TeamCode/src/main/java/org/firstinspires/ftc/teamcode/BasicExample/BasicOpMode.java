package org.firstinspires.ftc.teamcode.BasicExample;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.teamcode.BasicExample.commands.CollectSample;
import org.firstinspires.ftc.teamcode.BasicExample.commands.ExtendCommand;
import org.firstinspires.ftc.teamcode.BasicExample.commands.LowerWrist;
import org.firstinspires.ftc.teamcode.BasicExample.commands.RaiseWrist;
import org.firstinspires.ftc.teamcode.BasicExample.commands.RetractCommand;
import org.firstinspires.ftc.teamcode.BasicExample.commands.ToggleAlliance;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.WristSubsystem;
import org.firstinspires.ftc.teamcode.BasicExample.subsystem.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.BasicExample.commands.CancelCommand;
import org.firstinspires.ftc.teamcode.BasicExample.commands.EjectCommand;

@TeleOp
public class BasicOpMode extends CommandOpMode {
    private IntakeSubsystem intake;
    private ExtensionSubsystem extension;
    private WristSubsystem wrist;
    private GamepadEx driverOp, operatorOp;

    @Override
    public void initialize() {
//        intake = new IntakeSubsystem(telemetry, hardwareMap.get(DcMotor.class, "motor"),
//                hardwareMap.get(ColorSensor.class, "colorSensor"),
//                hardwareMap.get(RevBlinkinLedDriver.class, "blinkin"),
//                hardwareMap.get(DistanceSensor.class, "distanceSensor"),
//                hardwareMap.get(ServoImplEx.class, "allianceColor"));

        extension = new ExtensionSubsystem(hardwareMap.get(Servo.class, "extension"));
        wrist = new WristSubsystem(hardwareMap.get(Servo.class, "wrist"));

        driverOp = new GamepadEx(gamepad1);
        operatorOp = new GamepadEx(gamepad2);

        driverOp.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(new ExtendCommand(extension));
        driverOp.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(new RetractCommand(extension));

        driverOp.getGamepadButton(GamepadKeys.Button.A)
                .whenPressed(new RaiseWrist(wrist));
        driverOp.getGamepadButton(GamepadKeys.Button.B)
                .whenPressed(new LowerWrist(wrist));

//        operatorOp.getGamepadButton(GamepadKeys.Button.A)
//                .whenPressed(new EjectCommand(intake));
//        operatorOp.getGamepadButton(GamepadKeys.Button.B)
//                .whenPressed(new CancelCommand(intake));
//        operatorOp.getGamepadButton(GamepadKeys.Button.X)
//                .whenPressed(new ToggleAlliance(intake));
//        operatorOp.getGamepadButton(GamepadKeys.Button.Y)
//                .whenPressed(new CollectSample(intake));


    }

}
