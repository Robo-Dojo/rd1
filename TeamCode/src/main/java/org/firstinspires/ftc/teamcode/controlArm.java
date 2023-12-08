//region imports
package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//endregion

// the class that controlls the entire robot arm
public class controlArm {
    public void robotArmController(DcMotor vipersMotor)
    {
        // get joystick params
        double extendVipers= gamepad1.right_trigger;
        double retractVipers= -gamepad1.left_trigger;

        // telemetry code for development purpose only
        telemetry.addData("extend", extendVipers);

        //region choose vipers action
        if(extendVipers>0) {
            System.out.println("Viper extends");
            vipersMotor.setPower(extendVipers);
        } else if (retractVipers<0){
            System.out.println("Viper retracts");
            vipersMotor.setPower(retractVipers);
        }
        else{
            vipersMotor.setPower(0);
        }
        //endregion
    }
}
