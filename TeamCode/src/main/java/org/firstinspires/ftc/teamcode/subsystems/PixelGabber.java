package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

public class PixelGabber {
    public static boolean isOn = false;
    public static void pixelGrabber(Gamepad _gamepad2, DcMotor pixelMotor){
        if(_gamepad2.x == true && isOn == false){
            pixelMotor.setPower(0.6);
        }
        else if(_gamepad2.x == true && isOn == true){
            pixelMotor.setPower(0);
        }
        else if(_gamepad2.b == true && isOn == false){
            pixelMotor.setPower(-0.6);
        }
        else if(_gamepad2.b == true && isOn == true){
            pixelMotor.setPower(0);
        }
        else{
            pixelMotor.setPower(0);
        }
    }
}
