package org.firstinspires.ftc.teamcode.BasicExample.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BasicSubsystem extends SubsystemBase {
    private DcMotor motor;
    private Telemetry telemetry;
    private CRServo servo;
    private TouchSensor touchSensor;
    private ColorSensor colorSensor;
    private RevBlinkinLedDriver blinkin;
    private boolean RedAlliance = false;

    public BasicSubsystem(Telemetry telemetry, DcMotor motor, CRServo servo, TouchSensor touchSensor, ColorSensor colorSensor, RevBlinkinLedDriver blinkin) {
        this.telemetry = telemetry;
        this.motor = motor;
        this.servo = servo;
        this.touchSensor = touchSensor;
        this.colorSensor = colorSensor;
        this.blinkin = blinkin;
    }

    @Override
    public void periodic() {
        telemetry.addData("Motor running", motor.getPower());
        telemetry.addData("Servo running", servo.getPower());
        telemetry.addData("Touch Sensor", touchSensor.isPressed());
        telemetry.addData("Red Sample", isColorSensorRed());
        telemetry.addData("Blue Sample", isColorSensorBlue());
        telemetry.addData("Yellow Sample", isColorSensorYellow());
        if (isColorSensorRed()) {
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.RED);
        } else if (isColorSensorBlue()) {
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.BLUE);
        } else if (isColorSensorYellow()) {
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.YELLOW);
        } else {
            blinkin.setPattern(RevBlinkinLedDriver.BlinkinPattern.RAINBOW_RAINBOW_PALETTE);
        }
        if (RedAlliance) {
            telemetry.addData("Alliance", "Red");
        } else {
            telemetry.addData("Alliance", "Blue");
        }
        telemetry.update();
    }
    public void runMotor() {
        motor.setPower(0.75);
    }

    public void stopMotor() {
        motor.setPower(0);
    }

    public void runServo() {
        servo.setPower(0.75);
    }

    public void stopServo() {
        servo.setPower(0);
    }

    public boolean isTouchSensorPressed() {
        return touchSensor.isPressed();
    }

    public boolean isColorSensorRed() {
        return colorSensor.red() > colorSensor.blue() && colorSensor.red() > colorSensor.green();
    }

    public boolean isColorSensorBlue() {
        return colorSensor.blue() > colorSensor.red() && colorSensor.blue() > colorSensor.green();
    }

    public boolean isColorSensorYellow() {
        return colorSensor.red() > colorSensor.blue() && colorSensor.green() > colorSensor.blue();
    }

    public void changeAlliance() {
        this.RedAlliance = !getRedAlliance();
    }

    public boolean getRedAlliance() {
        return RedAlliance;
    }
}
