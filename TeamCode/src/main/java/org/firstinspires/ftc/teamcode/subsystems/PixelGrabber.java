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
        this.rd1.pixelGrabber.setPower(_gamepad2.right_stick_y);
    }
}
