//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ArmController;
import org.firstinspires.ftc.teamcode.subsystems.ObjectDetection;
//endregion

@Autonomous(name = "TestAutonom1")
public class AutonomousMode extends LinearOpMode {
    HardwareInit rd1 = new HardwareInit();
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
            rd1.frontRightMotor.setPower(0);
            rd1.frontLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);

            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

            telemetry.update();
            idle();
        }
    }

    @Override
    public void runOpMode() {
        rd1.init(hardwareMap, true);

        waitForStart();

        // TODO: code all steps
        if (opModeIsActive()) {
            // wait for team prop detection
            telemetry.addData("FRM= ", rd1.frontRightMotor.getCurrentPosition());
            telemetry.addData("FLM= ", rd1.frontLeftMotor.getCurrentPosition());
            telemetry.addData("RLM= ", rd1.rearLeftMotor.getCurrentPosition());
            telemetry.addData("RRM= ", rd1.rearRightMotor.getCurrentPosition());

            telemetry.update();

            int objectDetectionResult = objDet.getResult(rd1.webcam, telemetry);
            telemetry.addData("Object Detection Result:", objectDetectionResult);
            telemetry.update();
            objectDetectionResult=1;
            if(objectDetectionResult == 1){
                // goes to designated line
                drive(0.7,-600,-1800,-600,-1800);
                // go back to backdrop trajectory
                drive(0.7, 1200,0,1200,0);
                drive(0.7,-1640,-1640,-1640,-1640);
                //rotate robot 90 dgr
                drive(0.7, 1130,-1130,1130,-1130);
                //reset motor ticks
                rd1.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rd1.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rd1.rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rd1.rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                // go to backdrop playing field
                drive(0.7,-3250,-3250,-3250,-3250);
                // align robot to backdrop trajectory
                drive(0.7, -1200,1200,1200,-1200);
                //reset motor ticks
                rd1.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rd1.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rd1.rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rd1.rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                //place in front of backdrop
                drive(0.2,-900,-900,-900,-900);
                /*if(rd1.frontRightMotor.getCurrentPosition() > 1398 || rd1.frontLeftMotor.getCurrentPosition() < -5998 || rd1.rearRightMotor.getCurrentPosition() < -5998 || rd1.rearLeftMotor.getCurrentPosition() > 1398) {
                    rd1.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rd1.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rd1.rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rd1.rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    drive(0.7,850,850,850,850);
                    drive(0.2, 1100,-1100,1100,-1100);
                }*/
            }
            /*
            else if(objectDetectionResult == 2){
                // goes to designated line
                drive(0.2, -800,-800,-800,-800);
                drive(0.2, -500, -500, -500, -500);
            }
            else{
                // goes to designated line
                drive(0.2,-1800,-600,-1800,-600);
                // go back to backdrop trajectory
                drive(0.2, 1200,0,1200,0);
                drive(0.2,360,360,360,360);
            }
            */

        }
    }
}