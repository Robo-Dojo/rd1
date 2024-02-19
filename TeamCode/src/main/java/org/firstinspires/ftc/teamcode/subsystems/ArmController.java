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
        rd1.pixelDropperServo.setPosition(0.9);
    }

    public void armLifter(Gamepad _gamepad2)
    {
        // get joystick params
        boolean armLifter= _gamepad2.right_bumper;
        boolean armDropper= _gamepad2.left_bumper;
        boolean robotLifter = _gamepad2.dpad_up;
        boolean robotUnlift = _gamepad2.dpad_left;


        // telemetry code for dev purpose

        if(armDropper) {
            armLifterPosition = 0;
            //this.rd1.pixelDropperServo.setPosition(0.885);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.rd1.armLifterMotor.setTargetPosition(armLifterPosition);
            this.rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            this.rd1.armLifterMotor.setPower(0.75);
        }
        else if(armLifter){
            armLifterPosition += 100;
            if(armLifterPosition <= 2000) {
                this.rd1.armLifterMotor.setTargetPosition(armLifterPosition); // 2391
                this.rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                this.rd1.armLifterMotor.setPower(0.75);
            }
        }

        if(robotLifter){
            if(this.rd1.armLifterMotor.getCurrentPosition() < 2200) this.rd1.armLifterMotor.setPower(0.9);
            else this.rd1.armLifterMotor.setPower(0);
        }
        else if(robotUnlift){
            if(this.rd1.armLifterMotor.getCurrentPosition() > 2) this.rd1.armLifterMotor.setPower(-0.9);
            else this.rd1.armLifterMotor.setPower(0);
        }
        else{
            this.rd1.armLifterMotor.setPower(0);
        }
    }

    public void pixelDropper(Gamepad _gamepad2)
    {
        if(_gamepad2.a){
            // set pixelDropper in position for dropping the pixels
            //this.rd1.pixelDropperServo.setPosition(0.70); // TODO: value to be adapted
            //this.rd1.dropperMoverServo.setPosition(0.3);
            rd1.pixelDropperServo.setPosition(0.9);
        } else if(_gamepad2.y){
            // set pixelDropper in position for getting the pixels
            //this.rd1.pixelDropperServo.setPosition(0.1); // TODO: value to be adapted
            //this.rd1.dropperMoverServo.setPosition(0.7);
            rd1.pixelDropperServo.setPosition(0.3);
        }

    }

    public void extendArm()
    {
        this.rd1.armLifterMotor.setTargetPosition(2000); // 2391
        this.rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.rd1.armLifterMotor.setPower(0.75);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void extendArmTEMP()
    {
        this.rd1.armLifterMotor.setTargetPosition(1000); // 2391
        this.rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.rd1.armLifterMotor.setPower(0.75);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void retractArm()
    {
        this.rd1.armLifterMotor.setTargetPosition(0);
        this.rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.rd1.armLifterMotor.setPower(0.75);
    }

    public void dropPixel()
    {
        // set pixelDropper in position for dropping the pixels
        this.rd1.pixelDropperServo.setPosition(0.3); // TODO: value to be adapted
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void returnPixelDropper()
    {
        // set pixelDropper in position for dropping the pixels
        this.rd1.pixelDropperServo.setPosition(0.885); // TODO: value to be adapted
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
