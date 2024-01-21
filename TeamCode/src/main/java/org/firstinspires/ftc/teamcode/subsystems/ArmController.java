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

    public ArmController(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
    }

    public void armLifter(Gamepad _gamepad2)
    {
        // get joystick params
        boolean armLifter= _gamepad2.right_bumper;
        boolean armDropper= _gamepad2.left_bumper;

        // telemetry code for dev purpose
        if(armDropper) {
            rd1.pixelDropperServo.setPosition(0.68);
            rd1.armLifterMotor.setTargetPosition(0);
            rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotor.setPower(0.75);
        }
        else if(armLifter){
            rd1.armLifterMotor.setTargetPosition(2000); // 2391
            rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotor.setPower(0.75);
        }

    }

    public void pixelDropper(Gamepad _gamepad2)
    {
        if(_gamepad2.a){
            // set pixelDropper in position for dropping the pixels
            rd1.pixelDropperServo.setPosition(0.68); // TODO: value to be adapted
        } else if(_gamepad2.y){
            // set pixelDropper in position for getting the pixels
            rd1.pixelDropperServo.setPosition(0.1); // TODO: value to be adapted
        }

    }

    public void extendArm()
    {
        rd1.armLifterMotor.setTargetPosition(2000); // 2391
        rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.armLifterMotor.setPower(0.75);
    }

    public void retractArm()
    {
        rd1.armLifterMotor.setTargetPosition(0);
        rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.armLifterMotor.setPower(0.75);
    }

    public void dropPixel()
    {
        // set pixelDropper in position for dropping the pixels
        rd1.pixelDropperServo.setPosition(0.68); // TODO: value to be adapted
    }

    public void returnPixelDropper()
    {
        // set pixelDropper in position for dropping the pixels
        rd1.pixelDropperServo.setPosition(0.68); // TODO: value to be adapted
    }
}
