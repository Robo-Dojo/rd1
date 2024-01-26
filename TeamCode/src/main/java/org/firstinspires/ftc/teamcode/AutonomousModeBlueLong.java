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
            // right
            if(objectDetectionResult == 1){
                // Punem pixelu
                chassyController.forward45DegreeRight(0.5, 500);
                // Mergem putin inainte pe mijlocul tile-ului
                chassyController.forward(1, 1500);
                // Rotim spre backboard
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem spre backboard
                chassyController.forward(1, 2000);
                // Ne aliniem cu backboardul
                chassyController.left(1, 500);
                // Mergem incet spre backboard
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
                chassyController.right(1, 500);
                // Ne parcam
                chassyController.forward(0.7, 300);
                // THE END - 1
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
                // Mergem spre dreapta putin
                chassyController.right(1,350);
                // Mergem inainte
                chassyController.forward(1, 500);
                // Rotim spre backboard
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem spre backboard
                chassyController.forward(1, 2000);
                // Ne aliniem cu backboardul
                chassyController.left(1, 500);
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
                chassyController.right(1, 500);
                // Ne parcam
                chassyController.forward(0.7, 300);
                // THE END - 2
            }
            // left
            else if(objectDetectionResult == 3){
                // Punem pixelul
                chassyController.forward45DegreeLeft(0.5, 500);
                chassyController.resetEncoders();
                sleep(1000);
                // Mergem putin inainte pe mijlocul tile-ului
                chassyController.forward(1, 1500);
                sleep(1000);
                // Rotim spre backboard
                chassyController.rotate90Left(1);
                // Reset
                chassyController.resetEncoders();
                // Mergem spre backboard
                chassyController.forward(1, 3000);
                chassyController.resetEncoders();
                // Ne aliniem cu backboardul
                chassyController.left(1, 500);
                chassyController.resetEncoders();
                // Mergem incet spre backboard
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
                chassyController.right(1, 200);
                // Ne parcam
                chassyController.forward(0.7, 300);
                // THE END - 3
            }
        }
    }
}