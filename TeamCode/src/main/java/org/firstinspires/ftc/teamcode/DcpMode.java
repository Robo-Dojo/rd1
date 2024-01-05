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
        rd1.init(hardwareMap);

        ArmController ArmController = new ArmController();
        ChassyController ChassyController = new ChassyController();
        // endregion

        waitForStart();
        if (isStopRequested()) return;

        // running functions while dcpMode is active
        while (opModeIsActive()) {
            // control the movement of the robot chassis
            ChassyController.dcpMovement(gamepad1 ,rd1.frontLeftMotor, rd1.rearLeftMotor, rd1.frontRightMotor, rd1.rearRightMotor);

            // control the components of the arm
            ArmController.armLifter(gamepad2 ,rd1.armLifterMotor, telemetry);
            //ArmController.pixelDropper(pixelDropperServo);

            //droneLauncher.droneReleaser(gamepad2 ,servoDrone, telemetry);

            // update all telemetry visual data
            telemetry.update();
        }
    }
}