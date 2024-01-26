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

@Autonomous(name = "AutonomousRedLong")
public class AutonomousModeRedLong extends LinearOpMode {

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

            }

            // center
            else if(objectDetectionResult == 2){
                // Mergem spre linie cu oprire putin inainte
                chassyController.forward(1,1000);
                // Mergem incet spre linie
                chassyController.forward(0.3,350);
                // Dam cu spatele, putin mai mult ca sa nu lovim pixelul
                chassyController.reverse(1, 350);
                // Reset
                chassyController.resetEncoders();
                // Rotim spre backboard
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem spre backboard, ne oprim putin inainte
                chassyController.forward(1, 2000);
                // Optional, ne aliniem cu apriltagul din mijloc
                // chassyController. left sau right 200?
                // Ne apropiem incet de backboard
                chassyController.forward(0.3, 200);
                // Reset
                chassyController.resetEncoders();
                // Extindem viperele
                ArmController.extendArm();
                // Actionam cupa
                ArmController.dropPixel();
                // Punem cupa la loc
                ArmController.returnPixelDropper();
                // Retragem viperele
                ArmController.retractArm();
                // Dam cu spatele putin
                chassyController.reverse(1, 200);
                // Mergem la stanga
                chassyController.left(1, 500);
                // Ne parcam
                chassyController.forward(0.7, 300);
                // THE END - 2
            }
            // left
            else if(objectDetectionResult==3){

            }
        }
    }
}