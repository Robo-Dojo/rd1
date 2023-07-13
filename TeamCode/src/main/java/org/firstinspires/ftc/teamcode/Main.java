package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class Main extends LinearOpMode {
    public ColorSensor colorSensor;
    @Override
    public void runOpMode() {
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        ColorSensorV3 colorSensorClass = new ColorSensorV3();

        waitForStart();

        while (opModeIsActive()) {
            //telemetry.addData("Alpha", colorSensorClass.getAlpha());
            telemetry.addData("Detected color", colorSensorClass.getColor(colorSensor));
            //telemetry.addData("Distance", colorSensor.getIR());
            telemetry.update();
        }
    }
}