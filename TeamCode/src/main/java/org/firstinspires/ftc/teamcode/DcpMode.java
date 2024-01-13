// region imports
package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.teamcode.subsystems.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// endregion

@TeleOp
public class DcpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // region initialize all robot components & classes needed for dcpMode
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap, false);

        ArmController ArmController = new ArmController();
        ChassyController ChassyController = new ChassyController();
        // endregion

        waitForStart();
        if (isStopRequested()) return;

        // running functions while dcpMode is active
        while (opModeIsActive()) {
            // control the movement of the robot chassis - DONE
            ChassyController.dcpMovement(gamepad1 ,rd1.frontLeftMotor, rd1.rearLeftMotor, rd1.frontRightMotor, rd1.rearRightMotor);

            // control the components of the arm
            ArmController.armLifter(gamepad2 ,rd1.armLifterMotor, rd1.pixelDropperServo, telemetry); // -
            ArmController.pixelDropper(gamepad2 ,rd1.pixelDropperServo); // -

            DroneLauncher.droneReleaser(gamepad2 , rd1.servoDrone, telemetry);

            PixelGabber.pixelGrabber(gamepad2, rd1.pixelGrabber);

            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

            telemetry.update();

            // update all telemetry visual data
            telemetry.update();
        }
    }
}