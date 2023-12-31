// region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
// endregion

public class ChassyController {
    public void movementWheels(DcMotor frontLeftMotor, DcMotor backLeftMotor, DcMotor frontRightMotor, DcMotor backRightMotor)
    {
        /*
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        */

        // read values gamepad 1
        double gp1Y = -gamepad1.left_stick_y;
        double gp1X = -gamepad1.left_stick_x * 1.1;
        double gp1RotationX = gamepad1.right_stick_x;

        // calculate engines power
        double denominator = Math.max(Math.abs(gp1Y) + Math.abs(gp1X) + Math.abs(gp1RotationX), 1);
        double frontLeftPower = (gp1Y + gp1X - gp1RotationX) / denominator;
        double backLeftPower = (gp1Y - gp1X - gp1RotationX) / denominator;
        double frontRightPower = (gp1Y - gp1X + gp1RotationX) / denominator;
        double backRightPower = (gp1Y + gp1X + gp1RotationX) / denominator;

        // assign values to engines
        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }
}
