package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class droneLauncher {
    //class for the drone lanucher

    public static void droneReleaser(Gamepad _gamepad2, Servo servoDrone, Telemetry telemetry) {
        //function that controls the drone launcher

        if(_gamepad2.right_trigger!=0){
            //if right trigger's position is changed
            telemetry.addData("changing position",servoDrone);
            servoDrone.setPosition(_gamepad2.right_trigger);
        } else {
            //if right trigger's position is static
            telemetry.addData("servo should be locked in a set position",servoDrone);
        }
    }
}