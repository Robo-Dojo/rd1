//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.checkerframework.checker.units.qual.A;
import org.firstinspires.ftc.teamcode.subsystems.ArmController;
import org.firstinspires.ftc.teamcode.subsystems.ChassyController;
import org.firstinspires.ftc.teamcode.subsystems.ObjectDetection;
//endregion

@Autonomous(name = "AutonomousRedShort")
public class AutonomousModeRedShort extends LinearOpMode {

    @Override
    public void runOpMode() {
        // initialize all components
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap, true);
        ArmController ArmController = new ArmController(rd1, telemetry);
        ObjectDetection objDet = new ObjectDetection();
        ChassyController chassyController = new ChassyController(rd1, telemetry);

        int objectDetectionResult = objDet.getResult(rd1.webcam, telemetry);
        telemetry.addData("Object Detection Result:", objectDetectionResult);
        telemetry.update();

        waitForStart();

        // TODO: code all steps
        if (opModeIsActive()) {
            // wait for team prop detection
            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

            telemetry.update();

            // right
            if(objectDetectionResult == 1){
                // goes to designated line
                chassyController.autonomousMovement(0.65,-450,-1650,-450,-1650);
                // go back to backdrop trajectory
                chassyController.autonomousMovement(0.7, 1050,0,1050,0);
                //align to not hit the truss
                chassyController.autonomousMovement(0.7, 400,400,400,400);
                //rotate robot 90 dgr
                chassyController.autonomousMovement(0.7, 1200,-1200,1200,-1200);
                chassyController.resetEncoders();
                //go on track
                chassyController.autonomousMovement(0.7,-1600,-1600,-1600,-1600);
                //glide to align with backdrop
//                resetEncoders();
//                drive(0.7,1100,-1100,-1100,1100);
//                //drive to the backdrop
//                resetEncoders();
//                drive(0.7,-350,-350,-350,-350);
//                drive(0.7,300,-300,-300,300);

                chassyController.resetEncoders();

//                extendVipers();

            }

            // center
            else if(objectDetectionResult == 2){
                // goes to designated line and a bit back to bne able to rotate
                chassyController.autonomousMovement(0.7, -700,-700,-700,-700);
                chassyController.autonomousMovement(0.3, -500,-500,-500,-500);
                chassyController.autonomousMovement(0.3,  200,200,200,200);
                //rotate robot 90 dgr
                chassyController.autonomousMovement(0.7, 1110,-1110,1110,-1110);
                chassyController.resetEncoders();
                //drive to the backdrop
                chassyController.resetEncoders();
                chassyController.autonomousMovement(0.7,-1600,-1600,-1600,-1600);
                //coast slowly to hit the backdrop gently
                //drive(0.2,-100,-100,-100,-100);
                chassyController.autonomousMovement(0.7,800,-800,-800,800);
                chassyController.resetEncoders();
                // extend vipers
//                extendVipers();
            }
            // left
            else if(objectDetectionResult==3){
                // goes to designated line
                chassyController.autonomousMovement(0.7,-1800,-600,-1800,-600);
                // go back to backdrop trajectory
                chassyController.autonomousMovement(0.7, 0,1200,0,1200);
                //align to not hit the truss
                chassyController.autonomousMovement(0.7, -500,-500,-500,-500);
                //rotate robot 90 dgr
                chassyController.autonomousMovement(0.7, 1110,-1110,1110,-1110);
                chassyController.resetEncoders();
                //drive to the backdrop
                chassyController.resetEncoders();
                chassyController.autonomousMovement(0.7,-1700,-1700,-1700,-1700);
                chassyController.autonomousMovement(0.7,-800,800,800,-800);

                chassyController.resetEncoders();
                // extend vipers
//                extendVipers();
            }
        }
    }
}