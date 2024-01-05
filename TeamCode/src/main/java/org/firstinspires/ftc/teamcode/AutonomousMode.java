//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ChassyController;
//endregion

@Autonomous(name = "TestAutonom1")
public class AutonomousMode extends LinearOpMode {

    @Override
    public void runOpMode() {
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap);

        waitForStart();

        // TODO: code all steps
        if (opModeIsActive()) {
            // wait for team prop detection

            //segment 1 (first pixel placement)
            /*
            if(){
                //PROP is in the 1st segment of the image
                ChassyController.drive(0.7, 30, 15, 30, 15);
            }else if(){
                //PROP is in the 2nd segment of the image
                ChassyController.drive(0.7, 30, 15, 30, 15);
            }else if(){
                //PROP is in the 3rd segment of the image
                ChassyController.drive(0.7, 30, 15, 30, 15);
            }
            */

            //TO GO LEFT YOU HAVE TO GIVE 1/2 of TICKS TO THE LEFT WHEELS
            //EX: ChassyController.drive(0.7, 500, 250, 500, 250);

            //TO GO RIGHT YOU HAVE TO GIVE 1/2 of TICKS TO THE RIGHT WHEELS
            //EX: ChassyController.drive(0.7, 250, 500, 250, 500);

            //segment 2
            ChassyController.drive(0.7, 30, 15, 30, 15);


        }
    }
}
