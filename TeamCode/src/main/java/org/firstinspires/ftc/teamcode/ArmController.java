//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

// the class that controls the entire robot arm
public class ArmController {

    public void armLifter(Gamepad _gamepad2, DcMotor armMotor, Telemetry telemetry)
    {
        // get joystick params
        double armLifter= _gamepad2.right_stick_y;

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

    public void pixelDropper(Gamepad _gamepad2 ,Servo pixelDropperServo)
    {
        if(_gamepad2.y){
            // set pixelDropper in position for dropping the pixels
            pixelDropperServo.setPosition(10); // TODO: value to be adapted
        } else if(_gamepad2.a){
            // set pixelDropper in position for getting the pixels
            pixelDropperServo.setPosition(-10); // TODO: value to be adapted
        }

    }
}
