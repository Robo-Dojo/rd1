// region imports
package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.HardwareInit;
// endregion

public class ChassyController {
    public void dcpMovement(Gamepad _gamepad1, DcMotor frontLeftMotor, DcMotor rearLeftMotor, DcMotor frontRightMotor, DcMotor rearRightMotor)
    {
        // read values gamepad 1
        double gp1Y = -_gamepad1.left_stick_y;
        double gp1X = -_gamepad1.left_stick_x;
        double gp1RotationX = _gamepad1.right_stick_x;

        // calculate engines power
        double denominator = Math.max(Math.abs(gp1Y) + Math.abs(gp1X) + Math.abs(gp1RotationX), 1);
        double frontLeftPower = (gp1Y - gp1X + gp1RotationX) / denominator;
        double rearLeftPower = (gp1Y + gp1X + gp1RotationX) / denominator;
        double frontRightPower = (gp1Y + gp1X - gp1RotationX) / denominator;
        double rearRightPower = (gp1Y - gp1X - gp1RotationX) / denominator;

        // assign values to engines
        frontLeftMotor.setPower(frontLeftPower);
        rearLeftMotor.setPower(rearLeftPower);
        frontRightMotor.setPower(frontRightPower);
        rearRightMotor.setPower(rearRightPower);
    }

    public static void autonomousMovement(double power, int frontRightTicks, int frontLeftTicks, int rearRightTicks, int rearLeftTicks) {
        HardwareInit rd1 = new HardwareInit();

        int frontRightTarget;
        int frontLeftTarget;
        int rearLeftTarget;
        int rearRightTarget;

        // Create target positions
        frontRightTarget = rd1.frontRightMotor.getCurrentPosition() + frontRightTicks;
        frontLeftTarget = rd1.frontLeftMotor.getCurrentPosition() + frontLeftTicks;
        rearRightTarget = rd1.rearRightMotor.getCurrentPosition() + rearRightTicks;
        rearLeftTarget = rd1.rearLeftMotor.getCurrentPosition() + rearLeftTicks;

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

        //run to position at the designated power
        rd1.frontRightMotor.setPower(power);
        rd1.frontLeftMotor.setPower(power);
        rd1.rearRightMotor.setPower(power);
        rd1.rearLeftMotor.setPower(power);

        // wait until all motors are no longer busy running to position
        while (rd1.frontRightMotor.isBusy() || rd1.frontLeftMotor.isBusy() || rd1.rearLeftMotor.isBusy() || rd1.rearRightMotor.isBusy()) {
            // do nothing
        }

        // set motor power back to 0
        rd1.frontRightMotor.setPower(0);
        rd1.frontLeftMotor.setPower(0);
        rd1.rearRightMotor.setPower(0);
        rd1.rearLeftMotor.setPower(0);
        }
}
