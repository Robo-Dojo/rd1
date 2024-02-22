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
        PixelGrabber PixelGrabber = new PixelGrabber(rd1);
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

            // update all telemetry visual data
            telemetry.update();
        }
    }
}