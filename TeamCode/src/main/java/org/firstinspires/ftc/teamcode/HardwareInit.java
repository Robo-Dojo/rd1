package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareInit {
    public DcMotor frontLeftMotor = null;
    public DcMotor rearLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor rearRightMotor = null;
    public DcMotor armLifterMotor = null;
    public Servo pixelDropperServo = null;
    public Servo servoDrone = null;
    public DcMotor pixelGrabber = null;

    HardwareMap hwMap = null;

    public void init(HardwareMap hardwareMap){
        hwMap = hardwareMap;

        // motor declaration
        frontLeftMotor = hwMap.dcMotor.get("frontLeftMotor");
        rearLeftMotor = hwMap.dcMotor.get("rearLeftMotor");
        frontRightMotor = hwMap.dcMotor.get("frontRightMotor");
        rearRightMotor = hwMap.dcMotor.get("rearRightMotor");
        pixelGrabber = hwMap.dcMotor.get("pixelGrabber");

        // specify motors run with encoders
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        armLifterMotor = hwMap.get(DcMotor.class,"armLifterMotor");
        pixelDropperServo = hwMap.get(Servo.class, "pixelDropperServo");
        servoDrone = hwMap.get(Servo.class,"droneLauncher");
    }
}
