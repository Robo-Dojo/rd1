package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.hardware.Servo;

public class droneLauncher {
    //class for the drone lanucher

    public static void droneReleaser(Servo servoDrone) {
        //function that controls the drone launcher

        if(gamepad2.right_trigger!=0){
            //if right trigger's position is changed
            telemetry.addData("changing position",servoDrone);
            servoDrone.setPosition(gamepad2.right_trigger);
        } else {
            //if right trigger's position is static
            telemetry.addData("servo should be locked in a set position",servoDrone);
        }
    }
}
