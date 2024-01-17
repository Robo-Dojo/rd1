//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.ObjectDetection;
//endregion

@Autonomous(name = "AutonomousBlueShort")
public class AutonomousModeBlueShort extends LinearOpMode {
    HardwareInit rd1 = null;
    ObjectDetection objDet = new ObjectDetection();

    int frontRightTarget = 0;
    int frontLeftTarget = 0;
    int rearLeftTarget = 0;
    int rearRightTarget = 0;

    // Drive function with 3 parameters
    private void drive(double power, int frontRightTicks, int frontLeftTicks, int rearRightTicks, int rearLeftTicks) {
        telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
        telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
        telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
        telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

        telemetry.update();

        if (opModeIsActive()) {
            // Create target positions
            frontRightTarget = rd1.frontRightMotor.getCurrentPosition() + frontRightTicks;
            frontLeftTarget = rd1.frontLeftMotor.getCurrentPosition() + frontLeftTicks;
            rearRightTarget = rd1.rearRightMotor.getCurrentPosition() + rearRightTicks;
            rearLeftTarget = rd1.rearLeftMotor.getCurrentPosition() + rearLeftTicks;

            // Create target positions
//            frontRightTarget += frontRightTicks;
//            frontLeftTarget += frontLeftTicks;
//            rearRightTarget += rearRightTicks;
//            rearLeftTarget += rearLeftTicks;

            // set target position
            rd1.frontRightMotor.setTargetPosition(frontLeftTarget);
            rd1.frontLeftMotor.setTargetPosition(frontRightTarget);
            rd1.rearRightMotor.setTargetPosition(rearLeftTarget);
            rd1.rearLeftMotor.setTargetPosition(rearRightTarget);

            //switch to run to position mode
            rd1.frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.rearRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.rearLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            //run to position at the designated power
            rd1.frontRightMotor.setPower(power);
            rd1.frontLeftMotor.setPower(power);
            rd1.rearRightMotor.setPower(power);
            rd1.rearLeftMotor.setPower(power);

            // wait until all motors are no longer busy running to position
            while (opModeIsActive() && (rd1.frontRightMotor.isBusy() || rd1.frontLeftMotor.isBusy() || rd1.rearLeftMotor.isBusy() || rd1.rearRightMotor.isBusy())) {
                idle();
            }

            // set motor power back to 0
//            rd1.frontRightMotor.setPower(0);
//            rd1.frontLeftMotor.setPower(0);
//            rd1.rearRightMotor.setPower(0);
//            rd1.rearLeftMotor.setPower(0);

            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

            telemetry.update();
            idle();
        }
    }

    private void resetEncoders(){
        rd1.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rd1.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rd1.rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rd1.rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void runOpMode() {
        rd1 = new HardwareInit();
        rd1.init(hardwareMap, true);

        int objectDetectionResult = objDet.getResult(rd1.webcam, telemetry);
        telemetry.addData("Object Detection Result:", objectDetectionResult);
        telemetry.update();

        waitForStart();

        // TODO: code all steps
        if (opModeIsActive()) {
            // wait for team prop detection
            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

            telemetry.update();

            if(objectDetectionResult == 1){
                // goes to designated line
                drive(0.65,-450,-1650,-450,-1650);
                // go back to backdrop trajectory
                drive(0.7, 1050,0,1050,0);
                //align to not hit the truss
                drive(0.7, 400,400,400,400);
                //rotate robot 90 dgr
                drive(0.7, -1000,1000,-1000,1000);
                resetEncoders();
                //go on track
                drive(0.7,-1100,-1100,-1100,-1100);
                //glide to align with backdrop
                resetEncoders();
                drive(0.7,-1700,1700,1700,-1700);
                //drive to the backdrop
                resetEncoders();
                drive(0.45,-630,-630,-630,-630);
                //drive(0.7,-350,350,350,-350);

                resetEncoders();

//                extendVipers();
//                idle();
            }

            else if(objectDetectionResult == 2){
                // goes to designated line and a bit back to bne able to rotate
                drive(0.7, -700,-700,-700,-700);
                drive(0.3, -500,-500,-500,-500);
                drive(0.3,  200,200,200,200);
                //rotate robot 90 dgr
                drive(0.7, -1110,1110,-1110,1110);
                resetEncoders();
                //drive to the backdrop
                resetEncoders();
                drive(0.7,-1600,-1600,-1600,-1600);
                drive(0.7,-600,600,600,-600);
                //coast slowly to hit the backdrop gently
                drive(0.2,-100,-100,-100,-100);
//                drive(0.7,-200,200,200,-200);
//                drive(0.7,800,-800,-800,800);
                resetEncoders();
                // extend vipers
//                extendVipers();
//                idle();
            }

            else if(objectDetectionResult == 3){
                // goes to designated line
                drive(0.7,-1700,-600,-1700,-600);
                // go back to backdrop trajectory
                drive(0.7, 0,1100,0,1100);
                //align to not hit the truss
                drive(0.7, 500,500,500,500);
                //rotate robot 90 dgr
                drive(0.7, -1000,1000,-1000,1000);
                resetEncoders();
                //drive to the backdrop
                resetEncoders();
                drive(0.7,-1750,-1750,-1750,-1750);
                //drive(0.7,-700,700,700,-700);

                resetEncoders();
                // extend vipers
//                extendVipers();
//                idle();
            }
        }
    }
    private void extendVipers() {
        // extend vipers
        rd1.armLifterMotor.setTargetPosition(2100); // 2391
        telemetry.addData("Target pos set ", rd1.armLifterMotor.getTargetPosition());

        rd1.armLifterMotor.setPower(0.75);
        telemetry.addData("Set power ", rd1.armLifterMotor.getPower());

        rd1.armLifterMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rd1.armLifterMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // drop the pixel
        rd1.pixelDropperServo.setPosition(0.68);
        telemetry.addData("Set pixel drop pos", rd1.pixelDropperServo.getPosition());
        telemetry.update();
        //sleep(100000);
    }
}