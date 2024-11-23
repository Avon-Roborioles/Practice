package org.firstinspires.ftc.teamcode.BasicExample.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Servo;

public class ExtensionSubsystem extends SubsystemBase {
    private Servo servo;

    public ExtensionSubsystem(Servo servo) {
        this.servo = servo;
    }

    public void extend() {
        servo.setPosition(0.55);
    }

    public void retract() {
        servo.setPosition(1.0);
    }
}
