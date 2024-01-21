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

        ArmController ArmController = new ArmController(rd1, telemetry);
        ChassyController ChassyController = new ChassyController(rd1, telemetry);
        DroneLauncher DroneLauncher = new DroneLauncher(rd1, telemetry);
        PixelGabber PixelGrabber = new PixelGabber(rd1);
        // endregion

        waitForStart();
        if (isStopRequested()) return;

        // running functions while dcpMode is active
        while (opModeIsActive()) {
            // control the movement of the robot chassis
            ChassyController.dcpMovement(gamepad1);

            // control the components of the arm
            ArmController.armLifter(gamepad2);
            ArmController.pixelDropper(gamepad2);

            DroneLauncher.droneReleaser(gamepad2);

            PixelGrabber.pixelGrabber(gamepad2);

            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

            // update all telemetry visual data
            telemetry.update();
        }
    }
}