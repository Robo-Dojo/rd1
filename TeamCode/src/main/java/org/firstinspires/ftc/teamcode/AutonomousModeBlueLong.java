//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.subsystems.ArmController;
import org.firstinspires.ftc.teamcode.subsystems.ChassyController;
import org.firstinspires.ftc.teamcode.subsystems.ObjectDetection;
//endregion

@Autonomous(name = "AutonomousBlueLong")
public class AutonomousModeBlueLong extends LinearOpMode {

    @Override
    public void runOpMode() {
        // initialize all components
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap, true);
        ArmController ArmController = new ArmController(rd1, telemetry);
        ObjectDetection objDet = new ObjectDetection();
        ChassyController chassyController = new ChassyController(rd1, telemetry);

        // find team prop
        int objectDetectionResult = objDet.getResult(rd1.webcam, telemetry);
        telemetry.addData("Object Detection Result:", objectDetectionResult);
        telemetry.update();

        waitForStart();

        // TODO: code all steps
        if (opModeIsActive()) {
            // TODO: Use switch
            // left?
            if(objectDetectionResult == 1){
                // goes to designated line
                chassyController.autonomousMovement(0.7,-600,-1800,-600,-1800);
                // go back to backdrop trajectory
                chassyController.autonomousMovement(0.7, 1200,0,1200,0);
                chassyController.autonomousMovement(0.7,-1640,-1640,-1640,-1640);
                //rotate robot 90 dgr
                chassyController.autonomousMovement(0.7, -1115,1115,-1115,1115);
                //reset motor ticks
                chassyController.resetEncoders();
                // go to backdrop playing field
                chassyController.autonomousMovement(0.7,-3250,-3250,-3250,-3250);
                // align robot to backdrop trajectory
                chassyController.autonomousMovement(0.7, 1115,-1115,-1115,1115);
                //reset motor ticks
                chassyController.resetEncoders();
                //place in front of backdrop
                chassyController.autonomousMovement(0.2,-930,-930,-930,-930);
            }
            // center ?
            else if(objectDetectionResult == 2){
                // goes to designated line
                chassyController.autonomousMovement(0.7, -900,-900,-900,-900);
                chassyController.autonomousMovement(0.7, 100, 100, 100, 100);
                // goes under the bridge
                chassyController.autonomousMovement(0.7, 1115,-1115,-1115,1115);
                // goes under gate
                chassyController.autonomousMovement(0.7,-1440,-1440,-1440,-1440);
                // rotate 90 degrees
                chassyController.autonomousMovement(0.7, -1115,1115,-1115,1115);
                // goes to backboard
                chassyController.autonomousMovement(0.7,-1000,-1000,-1000,-1000);
                chassyController.autonomousMovement(0.2,-200,-200,-200,-200);
            }
            // right?
            else if(objectDetectionResult == 3){
                // goes to designated line
                chassyController.autonomousMovement(0.7,-1800,-600,-1800,-600);
                // go back to backdrop trajectory
                chassyController.autonomousMovement(0.7, 1200,0,1200,0);
                chassyController.autonomousMovement(0.7,-1640,-1640,-1640,-1640);
                //rotate robot 90 dgr
                chassyController.autonomousMovement(0.7, -1115,1115,-1115,1115);
                //reset motor ticks
                chassyController.resetEncoders();
                // go to backdrop playing field
                chassyController.autonomousMovement(0.7,-3250,-3250,-3250,-3250);
                // align robot to backdrop trajectory
                chassyController.autonomousMovement(0.7, 1115,-1115,-1115,1115);
                //reset motor ticks
                chassyController.resetEncoders();
                //place in front of backdrop
                chassyController.autonomousMovement(0.2,-930,-930,-930,-930);
            }
        }
    }
}