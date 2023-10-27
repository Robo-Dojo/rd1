package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class dcpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive()) {
          movementWheels();
          robotArmController();
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

    public void robotArmController()
    {
        double extendVipers=gamepad1.right_trigger;
        double retractVipers=-gamepad1.left_trigger;
        if(extendVipers>0) {
            System.out.println("Viper extends");
            //controlvipers(extendVipers);
        } else if (retractVipers<0){
            System.out.println("Viper retracts");
            //controlvipers(retractVipers);
        }
    }
}