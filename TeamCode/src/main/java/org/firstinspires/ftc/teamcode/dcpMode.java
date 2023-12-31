package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class dcpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor vipersMotor = hardwareMap.get(DcMotor.class, "vipers");
        DcMotor armMotor = hardwareMap.get(DcMotor.class,"arm");
        Servo clawLifter = hardwareMap.get(Servo.class, "claw-lifter");
        Servo clawOpener = hardwareMap.get(Servo.class, "claw-opener");
        Servo servoDrone = hardwareMap.get(Servo.class,"drone-launcher");
        armController armController = new armController();

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
          movementWheels();
          armController.vipersController(vipersMotor);
          armController.armLifter(armMotor);
          armController.clawController(clawLifter,clawOpener);
          droneLauncher.droneReleaser(servoDrone);
          telemetry.update();
        }
    }


    public void movementWheels()
    {
        // Motor declaration
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("backLeftMotor");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("backRightMotor");

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Read values from gamepad 1
        double gp1Y = -gamepad1.left_stick_y;
        double gp1X = -gamepad1.left_stick_x * 1.1;
        double gp1RotationX = gamepad1.right_stick_x;

        // Calculate the engines power
        double denominator = Math.max(Math.abs(gp1Y) + Math.abs(gp1X) + Math.abs(gp1RotationX), 1);
        double frontLeftPower = (gp1Y + gp1X - gp1RotationX) / denominator;
        double backLeftPower = (gp1Y - gp1X - gp1RotationX) / denominator;
        double frontRightPower = (gp1Y - gp1X + gp1RotationX) / denominator;
        double backRightPower = (gp1Y + gp1X + gp1RotationX) / denominator;

        // Assign values to the engines
        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }


}