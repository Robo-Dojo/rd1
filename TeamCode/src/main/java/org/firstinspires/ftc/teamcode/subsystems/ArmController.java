//region imports
package org.firstinspires.ftc.teamcode.subsystems;
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
        boolean armLifter= _gamepad2.right_bumper;
        boolean armDropper= _gamepad2.left_bumper;

        // telemetry code for dev purpose
        if(armDropper) {
            armMotor.setTargetPosition(0);
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.75);
        } else if(armLifter){
            armMotor.setTargetPosition(2000); // 2391
            armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            armMotor.setPower(0.75);
        }

    }

    public void pixelDropper(Gamepad _gamepad2 ,Servo pixelDropperServo)
    {
        if(_gamepad2.a){
            // set pixelDropper in position for dropping the pixels
            pixelDropperServo.setPosition(0.68); // TODO: value to be adapted
        } else if(_gamepad2.y){
            // set pixelDropper in position for getting the pixels
            pixelDropperServo.setPosition(0.1); // TODO: value to be adapted
        }

    }
}
