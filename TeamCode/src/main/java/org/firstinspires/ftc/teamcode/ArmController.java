//region imports
package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
//endregion

// the class that controls the entire robot arm
public class ArmController {

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

    public void pixelDropper(Servo pixelDropperServo)
    {
        if(gamepad2.y){
            // set pixelDropper in position for dropping the pixels
            pixelDropperServo.setPosition(10); // TODO: value to be adapted
        } else if(gamepad2.a){
            // set pixelDropper in position for getting the pixels
            pixelDropperServo.setPosition(-10); // TODO: value to be adapted
        }

    }
}
