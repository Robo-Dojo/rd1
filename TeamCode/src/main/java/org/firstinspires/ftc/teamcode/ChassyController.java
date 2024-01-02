// region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
// endregion

public class ChassyController {
    public void movementWheels(Gamepad _gamepad1, DcMotor frontLeftMotor, DcMotor rearLeftMotor, DcMotor frontRightMotor, DcMotor rearRightMotor)
    {

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

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
}
