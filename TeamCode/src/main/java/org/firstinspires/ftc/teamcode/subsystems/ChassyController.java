// region imports
package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.HardwareInit;
// endregion

public class ChassyController {
    private HardwareInit rd1;
    private Telemetry telemetry;

    int frontRightTarget = 0;
    int frontLeftTarget = 0;
    int rearLeftTarget = 0;
    int rearRightTarget = 0;

    // class constructor
    public ChassyController(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
    }

    public void dcpMovement(Gamepad _gamepad1)
    {
        // read values gamepad 1
        double accelerator = (0.3 + _gamepad1.right_trigger);
        double gp1Y = -(_gamepad1.right_stick_y*accelerator);
        double gp1X = -(_gamepad1.right_stick_x*accelerator);
        double gp1RotationX = _gamepad1.left_stick_x*0.6;

        // calculate engines power
        double denominator = Math.max(Math.abs(gp1Y) + Math.abs(gp1X) + Math.abs(gp1RotationX), 1);
        double frontLeftPower = ((gp1Y - gp1X + gp1RotationX) / denominator);
        double rearLeftPower = ((gp1Y + gp1X + gp1RotationX) / denominator);
        double frontRightPower = ((gp1Y + gp1X - gp1RotationX) / denominator);
        double rearRightPower = ((gp1Y - gp1X - gp1RotationX) / denominator);

        // assign values to engines
        rd1.frontLeftMotor.setPower(frontLeftPower);
        rd1.rearLeftMotor.setPower(rearLeftPower);
        rd1.frontRightMotor.setPower(frontRightPower);
        rd1.rearRightMotor.setPower(rearRightPower);

    }

    public void autonomousMovement(double power, int frontRightTicks, int frontLeftTicks, int rearRightTicks, int rearLeftTicks)
    {
        telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
        telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
        telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
        telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

        telemetry.update();

        // Create target positions
        frontRightTarget = rd1.frontRightMotor.getCurrentPosition() + frontRightTicks;
        frontLeftTarget = rd1.frontLeftMotor.getCurrentPosition() + frontLeftTicks;
        rearRightTarget = rd1.rearRightMotor.getCurrentPosition() + rearRightTicks;
        rearLeftTarget = rd1.rearLeftMotor.getCurrentPosition() + rearLeftTicks;

        // Create target positions
//            frontRightTarget += frontRightTicks;
//            frontLeftTarget += frontLeftTicks;
//            rearRightTarget += rearRightTicks;
//            rearLeftTarget += rearLeftTicks;

        // set target position
        rd1.frontRightMotor.setTargetPosition(frontLeftTarget);
        rd1.frontLeftMotor.setTargetPosition(frontRightTarget);
        rd1.rearRightMotor.setTargetPosition(rearLeftTarget);
        rd1.rearLeftMotor.setTargetPosition(rearRightTarget);

        //switch to run to position mode
        rd1.frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.rearRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.rearLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rd1.frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rd1.frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rd1.rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rd1.rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //run to position at the designated power
        rd1.frontRightMotor.setPower(power);
        rd1.frontLeftMotor.setPower(power);
        rd1.rearRightMotor.setPower(power);
        rd1.rearLeftMotor.setPower(power);

        // wait until all motors are no longer busy running to position
        while (isOnTarget()) {
            // do nothing
        }

        // set motor power back to 0
            rd1.frontRightMotor.setPower(0);
            rd1.frontLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);

        telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
        telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
        telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
        telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

        telemetry.update();
    }

    public boolean isOnTarget() {
        double frontRightMotorCheck = Math.abs(rd1.frontRightMotor.getCurrentPosition() - rd1.frontRightMotor.getTargetPosition());
        double frontLeftMotorCheck = Math.abs(rd1.frontLeftMotor.getCurrentPosition() - rd1.frontLeftMotor.getTargetPosition());
        double rearRightMotorCheck = Math.abs(rd1.rearRightMotor.getCurrentPosition() - rd1.rearRightMotor.getTargetPosition());
        double rearLeftMotorCheck = Math.abs(rd1.rearLeftMotor.getCurrentPosition() - rd1.rearLeftMotor.getTargetPosition());
        if (frontRightMotorCheck > 10 || frontLeftMotorCheck > 10 || rearRightMotorCheck > 10 || rearLeftMotorCheck > 10) {
            return true;
        } else {
            return false;
        }
    }

    public void forward(double power, int ticks) {
        autonomousMovement(power, -ticks, -ticks, -ticks, -ticks);
    }

    public void reverse(double power, int ticks) {
        autonomousMovement(power, ticks, ticks, ticks, ticks);
    }

    public void left(double power, int ticks) {
        autonomousMovement(power, -ticks, ticks, ticks, -ticks);
    }

    public void right(double power, int ticks) {
        autonomousMovement(power, ticks, -ticks, -ticks, ticks);
    }

    public void rotate90Left(double power) {
        autonomousMovement(power, -1000,1000,-1000,1000);
    }

    public void rotate90Right(double power) {
        autonomousMovement(power, 1000,-1000,1000,-1000);
    }

    public void resetEncoders()
    {
        rd1.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rd1.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rd1.rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rd1.rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}
