//region imports
package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.HardwareInit;
//endregion

// the class that controls the entire robot arm
public class ArmController {
    private HardwareInit rd1;
    private Telemetry telemetry;

    private int armLifterPosition = 0;

    public ArmController(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.pixelDropperServo.setPosition(0.875);
    }

    public void robotHanger(Gamepad _gamepad2){
        if(_gamepad2.left_bumper && _gamepad2.right_bumper){
            this.rd1.armLifterMotor.setPower(0.9);
        }
    }

    public void armLifter(Gamepad _gamepad2)
    {
        // get joystick params
        this.rd1.armLifterMotor.setPower(-_gamepad2.right_trigger);
        this.rd1.armLifterMotor.setPower(_gamepad2.left_trigger);

    }

    public void pixelDropper(Gamepad _gamepad2)
    {
        if(_gamepad2.a){
            // set pixelDropper in position for dropping the pixels
            //this.rd1.pixelDropperServo.setPosition(0.70); // TODO: value to be adapted
            //this.rd1.dropperMoverServo.setPosition(0.3);
            rd1.pixelDropperServo.setPosition(0.875);
        } else if(_gamepad2.y){
            // set pixelDropper in position for getting the pixels
            //this.rd1.pixelDropperServo.setPosition(0.1); // TODO: value to be adapted
            //this.rd1.dropperMoverServo.setPosition(0.7);
            rd1.pixelDropperServo.setPosition(0.33);
        }

    }
}
