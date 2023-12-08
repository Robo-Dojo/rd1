package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;

public class ColorSensorV3 {
    String detectedColor;
    int alphaValue;
    public String getColor(ColorSensor colorSensor) {
        if (colorSensor.red() > colorSensor.green()) {
            if (colorSensor.red() > colorSensor.blue()) {
                detectedColor = "Red";
            } else if (colorSensor.blue() > colorSensor.green()) {
                detectedColor = "Blue";
            }
        } else if (colorSensor.green() > colorSensor.blue()) {
            detectedColor = "Green";
        } else {
            detectedColor = "Blue";
        }

        return detectedColor;
    }
/*
    public int getAlpha() {
        colorSensor = hardwareMap.get(RevColorSensorV3.class, "colorSensor");
        alphaValue = colorSensor.alpha();
        return alphaValue;
    }*/
}