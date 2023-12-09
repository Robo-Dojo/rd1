//region imports
package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//endregion

// the class that controls the entire robot arm
public class armController {

    public void clawController(Servo clawLifter, Servo clawOpener){
        //function that controls the claw

        //variables/positions
        //all variables are subject to change
        double clawLifterStart = 0;
        double clawLifterMid = 0.5;
        double clawLifterFinal = 1;
        double clawOpen = 1;
        double clawOpenMid = 0.5;
        double clawClosed = 0;

        // telemetry code for dev purpose clawLifter
        if(gamepad2.y){
            telemetry.addData("lifting-claw", clawLifter );
        } else if(gamepad2.a){
            telemetry.addData("dropping-claw",clawLifter);
        } else {
            telemetry.addData("static-claw", clawLifter);
        }

        // telemetry code for dev purpose clawOpener
        if(gamepad2.x){
            telemetry.addData("opening-claw",clawOpener);
        } else if(gamepad2.b){
            telemetry.addData("closing-claw",clawOpener);
        } else {
            telemetry.addData("static-claw-teeth",clawOpener);
        }

        //region choose clawLifter action
        if(gamepad2.y){
            //will lift the claw
            clawLifter.setPosition(clawLifterStart);
        } else if(gamepad2.a){
            //will drop the claw
            clawLifter.setPosition(clawLifterFinal);
        } else {
            //will set the claw to a middle position
            clawLifter.setPosition(clawLifterMid);
        }

        //region choose clawOpener action
        if(gamepad2.x){
            //will open the teeth of the claw
            clawOpener.setPosition(clawOpen);
        } else if(gamepad2.b){
            //will close the teeth of the claw
            clawOpener.setPosition(clawClosed);
        } else {
            //will set the claw's teeth to a mid position
            clawOpener.setPosition(clawOpenMid);
        }
    }

    public void armLifter(DcMotor armMotor)
    {
        // get joystick params
        double armLifter= gamepad2.right_stick_y;

        // telemetry code for dev purpose
        if(armLifter<0) {

            telemetry.addData("dropping",armLifter);

        } else if(armLifter==0){

                telemetry.addData("static",armLifter);

        } else if(armLifter>0){

            telemetry.addData("lifting",armLifter);

        }

        //region choose lifter action
        armMotor.setPower(armLifter);
    }
    public void vipersController(DcMotor vipersMotor)
    {
        // get joystick params
        double extendVipers= gamepad1.right_trigger;
        double retractVipers= -gamepad1.left_trigger;

        // telemetry code for development purpose only
        telemetry.addData("extend", extendVipers);
        telemetry.addData("retract",retractVipers);

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
