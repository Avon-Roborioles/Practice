package org.firstinspires.ftc.teamcode.BasicExample.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class BasicSubsystem extends SubsystemBase {
    private DcMotor motor;
    private Telemetry telemetry;
    private CRServo servo;
    private TouchSensor touchSensor;

    public BasicSubsystem(Telemetry telemetry, DcMotor motor, CRServo servo, TouchSensor touchSensor) {
        this.telemetry = telemetry;
        this.motor = motor;
        this.servo = servo;
        this.touchSensor = touchSensor;
    }

    @Override
    public void periodic() {
        telemetry.addData("Motor running", motor.getPower());
        telemetry.addData("Servo running", servo.getPower());
        telemetry.addData("Touch Sensor", touchSensor.isPressed());
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
}
