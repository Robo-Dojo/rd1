//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.ArmController;
import org.firstinspires.ftc.teamcode.subsystems.ChassyController;
import org.firstinspires.ftc.teamcode.subsystems.ObjectDetection;
//endregion

@Autonomous(name = "AutonomousBlueShort")
public class AutonomousModeBlueShort extends LinearOpMode {
    ObjectDetection objDet = new ObjectDetection();

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
                // Punem pixelul
                chassyController.forward45DegreeRight(0.5, 450);
                chassyController.resetEncoders();
                // Dam inapoi
                chassyController.reverse(1, 400);
                // Ne orientam cu backboardul
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem putin inainte
                chassyController.forward(1, 1500);
                chassyController.resetEncoders();
                // Ne aliniem cu backboardul
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                chassyController.forward(1, 800);
                chassyController.resetEncoders();
                chassyController.rotate90Left(1);
                chassyController.resetEncoders();
                // Ne apropiem incet de backboard
                chassyController.forward(1, 1600);
                chassyController.forward(0.3, 300);
                // Reset
                chassyController.resetEncoders();
                // Extindem viperele
                ArmController.extendArm();
                sleep(100);
                // Actionam cupa
                ArmController.dropPixel();
                // Punem cupa la loc
                ArmController.returnPixelDropper();
                // Retragem viperele
                ArmController.retractArm();
                // Dam cu spatele putin
                chassyController.reverse(1, 300);
                chassyController.rotate90Left(1);
                // Mergem la stanga
                chassyController.forward(1, 450);
                chassyController.rotate90Right(1);
                // Ne parcam
                chassyController.forward(0.7, 400);
            }
            // center - GATA
            else if(objectDetectionResult == 2){
                // Mergem spre linie cu oprire putin inainte
                chassyController.forward(1,1000);
                // Mergem incet spre linie
                chassyController.forward(0.3,200);
                // Dam cu spatele, putin mai mult ca sa nu lovim pixelul
                chassyController.reverse(1, 200);
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
                chassyController.rotate90Left(1);
                chassyController.resetEncoders();
                // Mergem la stanga
                chassyController.forward(1, 500);
                chassyController.resetEncoders();
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                // Ne parcam
                chassyController.forward(0.7, 300);
                // THE END - 2
            }

            else if(objectDetectionResult == 3){
                // Punem pixelul
                chassyController.forward45DegreeLeft(0.5, 450);
                chassyController.resetEncoders();
                // Dam inapoi
                chassyController.reverse(1, 400);
                // Ne orientam cu backboardul
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem putin inainte
                chassyController.forward(1, 1500);
                chassyController.resetEncoders();
                // Ne aliniem cu backboardul
                chassyController.rotate90Right(1);
                chassyController.resetEncoders();
                chassyController.forward(1, 450);
                chassyController.resetEncoders();
                chassyController.rotate90Left(1);
                chassyController.resetEncoders();
                // Ne apropiem incet de backboard
                chassyController.forward(1, 1600);
                chassyController.forward(0.3, 300);
                // Reset
                chassyController.resetEncoders();
                // Extindem viperele
                ArmController.extendArm();
                sleep(100);
                // Actionam cupa
                ArmController.dropPixel();
                // Punem cupa la loc
                ArmController.returnPixelDropper();
                // Retragem viperele
                ArmController.retractArm();
                // Dam cu spatele putin
                chassyController.reverse(1, 300);
                chassyController.rotate90Left(1);
                // Mergem la stanga
                chassyController.forward(1, 450);
                chassyController.rotate90Right(1);
                // Ne parcam
                chassyController.forward(0.7, 400);
                // THE END - 3
            }
        }
    }
}