package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.HardwareInit;
//endregion

public class PixelGabber {
    public boolean isOn = false;
    private HardwareInit rd1;

    public PixelGabber(HardwareInit rd1)
    {
        this.rd1 = rd1;
    }

    public void pixelGrabber(Gamepad _gamepad2){
        if(_gamepad2.x == true && isOn == false){
            rd1.pixelGrabber.setPower(0.6);
        }
        else if(_gamepad2.x == true && isOn == true){
            rd1.pixelGrabber.setPower(0);
        }
        else if(_gamepad2.b == true && isOn == false){
            rd1.pixelGrabber.setPower(-0.6);
        }
        else if(_gamepad2.b == true && isOn == true){
            rd1.pixelGrabber.setPower(0);
        }
        else{
            rd1.pixelGrabber.setPower(0);
        }
    }
}
