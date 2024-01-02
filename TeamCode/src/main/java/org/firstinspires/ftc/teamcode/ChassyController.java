// region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
// endregion

public class ChassyController {
    public void movementWheels(Gamepad _gamepad1, DcMotor frontLeftMotor, DcMotor backLeftMotor, DcMotor frontRightMotor, DcMotor backRightMotor)
    {

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // read values gamepad 1
        double gp1Y = -_gamepad1.left_stick_y;
        double gp1X = -_gamepad1.left_stick_x;
        double gp1RotationX = _gamepad1.right_stick_x;

        // calculate engines power
        double denominator = Math.max(Math.abs(gp1Y) + Math.abs(gp1X) + Math.abs(gp1RotationX), 1);
        double frontLeftPower = (gp1Y + gp1X + gp1RotationX) / denominator;
        double backLeftPower = (gp1Y - gp1X + gp1RotationX) / denominator;
        double frontRightPower = (gp1Y - gp1X - gp1RotationX) / denominator;
        double backRightPower = (gp1Y + gp1X - gp1RotationX) / denominator;

        // assign values to engines
        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }
}
