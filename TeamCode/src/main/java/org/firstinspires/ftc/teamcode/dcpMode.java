// region imports
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
// endregion

@TeleOp
public class dcpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // region initialize all robot components & classes needed for dcpMode
        DcMotor armLifterMotor = hardwareMap.get(DcMotor.class,"armLifterMotor");
        //Servo pixelDropperServo = hardwareMap.get(Servo.class, "pixel-dropper-servo");
        //Servo servoDrone = hardwareMap.get(Servo.class,"drone-launcher");

        // motor declaration
        DcMotor frontLeftMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        DcMotor rearLeftMotor = hardwareMap.dcMotor.get("rearLeftMotor");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("frontRightMotor");
        DcMotor rearRightMotor = hardwareMap.dcMotor.get("rearRightMotor");

        ArmController ArmController = new ArmController();
        ChassyController ChassyController = new ChassyController();
        // endregion

        waitForStart();
        if (isStopRequested()) return;

        // running functions while dcpMode is active
        while (opModeIsActive()) {
            // control the movement of the robot chassis
            ChassyController.movementWheels(gamepad1 ,frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

            // control the components of the arm
            ArmController.armLifter(gamepad2 ,armLifterMotor, telemetry);
            //ArmController.pixelDropper(pixelDropperServo);

            //droneLauncher.droneReleaser(gamepad2 ,servoDrone, telemetry);

            // update all telemetry visual data
            telemetry.update();
        }
    }
}