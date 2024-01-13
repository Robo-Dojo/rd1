package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
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
    public WebcamName webcam;

    HardwareMap hwMap = null;

    public void init(HardwareMap hardwareMap, boolean isAutonom){
        hwMap = hardwareMap;

        // motor declaration
        frontLeftMotor = hwMap.dcMotor.get("frontLeftMotor");
        rearLeftMotor = hwMap.dcMotor.get("rearLeftMotor");
        frontRightMotor = hwMap.dcMotor.get("frontRightMotor");
        rearRightMotor = hwMap.dcMotor.get("rearRightMotor");
        pixelGrabber = hwMap.dcMotor.get("pixelGrabber");

        armLifterMotor = hwMap.get(DcMotor.class,"armLifterMotor");
        pixelDropperServo = hwMap.get(Servo.class, "pixelDropperServo");
        servoDrone = hwMap.get(Servo.class,"droneLauncher");

        webcam = hwMap.get(WebcamName.class, "Webcam");

        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armLifterMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        if (!isAutonom) {
            // specify motors run with encoders
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rearLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rearRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        }

        //frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
