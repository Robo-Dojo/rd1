package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.HardwareInit;

public class DroneLauncher {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public DroneLauncher(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
    }

    public void droneReleaser(Gamepad _gamepad2)
    {
        //function that controls the drone launcher

        if(_gamepad2.right_trigger!=0){
            //if right trigger's position is changed
            telemetry.addData("changing position", this.rd1.servoDrone);
            this.rd1.servoDrone.setPosition(1);
        } else {
            //if right trigger's position is static
            telemetry.addData("servo should be locked in a set position", this.rd1.servoDrone);
        }
    }
}