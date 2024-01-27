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


        waitForStart();

        // TODO: code all steps
        if (opModeIsActive()) {
            // wait for team prop detection
            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());
            int objectDetectionResult = objDet.getResult(rd1.webcam, telemetry);
            telemetry.addData("Object Detection Result:", objectDetectionResult);

            telemetry.update();


            //TEMPORAR - 1
            if(objectDetectionResult == 4){
                // Punem pixelul
                chassyController.forward45DegreeRight(0.7, 550);
                chassyController.resetEncoders();
                //chassyController.forward(1, 100);
                chassyController.reverse(1, 500);
                chassyController.resetEncoders();
                // Ne orientam cu backboardul
                chassyController.rotate90Right(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem putin inainte
                chassyController.forward(1, 1400);
                chassyController.resetEncoders();
                // Ne aliniem cu backboardul
                // Extindem viperele
                ArmController.extendArmTEMP();
//                // Actionam cupa
                ArmController.dropPixel();
//                // Punem cupa la loc
                ArmController.returnPixelDropper();
//                // Retragem viperele
                ArmController.extendArm();
                ArmController.retractArm();
                chassyController.forward(1, 100);
            }

            // right
            if(objectDetectionResult == 1){
                // Punem pixelul
                chassyController.forward45DegreeRight(0.7, 550);
                chassyController.resetEncoders();
                chassyController.reverse(1, 450);
                chassyController.resetEncoders();
                //chassyController.forward(1, 100);
                // Ne orientam cu backboardul
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                chassyController.forward(1, 1200);
                chassyController.resetEncoders();
                chassyController.rotate90Left(1);
                chassyController.resetEncoders();
                chassyController.forward(1, 500);
                chassyController.resetEncoders();
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                // Ne apropiem incet de backboard
                chassyController.forward(0.3, 500);
                // Reset
                chassyController.resetEncoders();
                // Extindem viperele
                ArmController.extendArm();
//                // Actionam cupa
                ArmController.dropPixel();
//                // Punem cupa la loc
                ArmController.returnPixelDropper();
//                // Retragem viperele
                ArmController.retractArm();
                // Dam cu spatele putin
                chassyController.reverse(1, 300);
                chassyController.resetEncoders();
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                // Mergem la stanga
                chassyController.forward(1, 1000);
                chassyController.resetEncoders();
                chassyController.rotate90Left(1);
                chassyController.resetEncoders();
                // Ne parcam
                chassyController.forward(0.7, 400);
            }
            // center - temporar - 2
            else if(objectDetectionResult == 5){
                // Mergem spre linie cu oprire putin inainte
                chassyController.forward(1,1000);
                // Mergem incet spre linie
                chassyController.forward(0.6,200);
                // Dam cu spatele, putin mai mult ca sa nu lovim pixelul
                chassyController.reverse(1, 1000);
                // Reset
                chassyController.resetEncoders();
                // Rotim spre backboard
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem spre backboard, ne oprim putin inainte
                chassyController.forward(1, 1500);
                // Optional, ne aliniem cu apriltagul din mijloc
                // chassyController. left sau right 200?
                // Ne apropiem incet de backboard
                //chassyController.forward(0.3, 200);
                // Reset
                chassyController.resetEncoders();
                // Extindem viperele
                ArmController.extendArmTEMP();
                // Actionam cupa
                ArmController.dropPixel();
                // Punem cupa la loc
                ArmController.returnPixelDropper();
                // Retragem viperele
                ArmController.extendArm();
                ArmController.retractArm();
                chassyController.forward(1, 100);
            }
            // center - ALA BUN
            else if(objectDetectionResult == 2){
                // Mergem spre linie cu oprire putin inainte
                chassyController.forward(1,1000);
                // Mergem incet spre linie
                chassyController.forward(0.6,200);
                // Dam cu spatele, putin mai mult ca sa nu lovim pixelul
                chassyController.reverse(1, 300);
                // Reset
                chassyController.resetEncoders();
                // Rotim spre backboard
                chassyController.rotate90Right(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem spre backboard, ne oprim putin inainte
                chassyController.forward(1, 1500);
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
                chassyController.resetEncoders();
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                // Mergem la stanga
                chassyController.forward(1, 1000);
                chassyController.resetEncoders();
                chassyController.rotate90Left(1);
                chassyController.resetEncoders();
                // Ne parcam
                chassyController.forward(0.7, 300);
                // THE END - 2
            }

            // right - 3 - BUN
            else if(objectDetectionResult == 3){
                // Punem pixelul
                chassyController.forward45DegreeLeft(0.7, 550);
                chassyController.resetEncoders();
                // Ne orientam cu backboardul
                chassyController.rotate90Right(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem putin inainte
                chassyController.forward(1, 1400);
                chassyController.resetEncoders();
                // Ne aliniem cu backboardul
                chassyController.forward(0.3, 150);
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
                chassyController.reverse(1, 300);
                chassyController.resetEncoders();
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                // Mergem la stanga
                chassyController.forward(1, 1200);
                chassyController.resetEncoders();
                chassyController.rotate90Left(1);
                chassyController.resetEncoders();
                // Ne parcam
                chassyController.forward(0.7, 400);
                // THE END - 3
            }

            //TEMPORAR - 3
            else if(objectDetectionResult == 6){
                // Punem pixelul
                chassyController.forward45DegreeLeft(0.7, 550);
                chassyController.resetEncoders();
                // Dam inapoi
                chassyController.reverse(1, 475);
                // Ne orientam cu backboardul
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem putin inainte
                chassyController.forward(1, 1400);
                chassyController.resetEncoders();
                // Extindem viperele
                ArmController.extendArmTEMP();

                // Actionam cupa
                ArmController.dropPixel();
                // Punem cupa la loc
                ArmController.returnPixelDropper();
                // Retragem viperele
                ArmController.extendArm();
                ArmController.retractArm();
                chassyController.forward(1, 100);
            }
        }
    }
}