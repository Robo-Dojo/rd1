//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.ObjectDetection;
//endregion

@Autonomous(name = "TestAutonom3")
public class AutonomusMode3 extends LinearOpMode {
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

            if(objectDetectionResult == 1){
                // goes to designated line
                drive(0.2,-600,-1800,-600,-1800);
                // go back to backdrop trajectory
                drive(0.2, 1200,0,1200,0);
                drive(0.2,360,360,360,360);
                // go to backdrop playing field
                drive(0.7,+3214,-3214,-3214,+3214);
                // set in front of backdrop
                drive(0.2, +893,+893,+893,+893);
                // rotate robot 90 dgr
                drive(0.2,+900,+2100,+800,+2100);
                // drive to backdrop
                drive(0.2,-1161,-1161,-1161,-1161);
            }
            else if(objectDetectionResult == 2){
                // goes to designated line
                drive(0.2, -800,-800,-800,-800);
                drive(0.2, -500, -500, -500, -500);
                // go back to backdrop trajectory
                drive(0.2,360,360,360,360);
                // go to backdrop playing field
                drive(0.7,+3214,-3214,-3214,+3214);
                // set in front of backdrop
                drive(0.2, +893,+893,+893,+893);
                // rotate robot 90 dgr
                drive(0.2,+900,+2100,+800,+2100);
                // drive to backdrop
                drive(0.2,-1161,-1161,-1161,-1161);
            }
            else{
                // goes to designated line
                drive(0.2,-1800,-600,-1800,-600);
                // go back to backdrop trajectory
                drive(0.2, 1200,0,1200,0);
                drive(0.2,360,360,360,360);
                // go to backdrop playing field
                drive(0.7,+3214,-3214,-3214,+3214);
                // set in front of backdrop
                drive(0.2, +893,+893,+893,+893);
                // rotate robot 90 dgr
                drive(0.2,+900,+2100,+800,+2100);
                // drive to backdrop
                drive(0.2,-1161,-1161,-1161,-1161);
            }

            //inaintat la zona cu linii
            //Asta e buna pentru Linia 1
            drive(0.2,-600,-1800,-600,-1800);

            //segment 2 - 1304
            //Astea 2 bune pentru linia 2
            //drive(0.2, -800,-800,-800,-800);
            //drive(0.2, -500, -500, -500, -500);

            //pozitie 3


            //intoarcere la pozitia 0, dar putin mai in fata sa intram printre bari
            //Astea 2 sunt bune pt linia 1
            drive(0.2, 1200,0,1200,0);

            //intors la start
            drive(0.2,360,360,360,360);

            //mergem spre backboard
            drive(0.7,-3214,3214,3214,-3214);

            sleep(100000);
            idle();

        }
    }
}