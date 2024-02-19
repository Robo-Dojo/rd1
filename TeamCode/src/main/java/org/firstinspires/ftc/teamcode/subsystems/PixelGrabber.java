package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.HardwareInit;
//endregion

public class PixelGrabber {
    public boolean isOn = false;
    private HardwareInit rd1;

    public PixelGrabber(HardwareInit rd1)
    {
        this.rd1 = rd1;
    }

    public void pixelGrabber(Gamepad _gamepad2){
        if(_gamepad2.x == true && isOn == false){
            this.rd1.pixelGrabber.setPower(0.7);
        }
        else if(_gamepad2.x == true && isOn == true){
            this.rd1.pixelGrabber.setPower(0);
        }
        else if(_gamepad2.b == true && isOn == false){
            this.rd1.pixelGrabber.setPower(-0.7);
        }
        else if(_gamepad2.b == true && isOn == true){
            this.rd1.pixelGrabber.setPower(0);
        }
        else{
            this.rd1.pixelGrabber.setPower(0);
        }
    }
}
