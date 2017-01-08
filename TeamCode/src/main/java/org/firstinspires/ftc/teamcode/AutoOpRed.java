/*
    Team 10603's AutoOpMode
    Written by John Gaidimas
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto Red", group="Linear Opmode")
public class AutoOpRed extends LinearOpMode {
    /* Declare OpMode members. */
    Hardware10603 robot = new Hardware10603();   // Use a Pushbot's hardware
    OpticalDistanceSensor odsSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        double left;
        double right;
        double max;

        // bLedOn represents the state of the LED.
        boolean bLedOn = true;
        boolean hit = false;

        robot.init(hardwareMap);
        odsSensor = hardwareMap.opticalDistanceSensor.get("ods");


        waitForStart();

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Startup Complete, Waiting for 10 Seconds");    //
        telemetry.update();

        Thread.sleep(10000);

        //Color Sensor Data Readout
        while (opModeIsActive()) {
            if(odsSensor.getRawLightDetected() < 0.1){
                /*telemetry.addData("Raw" , odsSensor.getRawLightDetected());
                telemetry.addData("Normal", odsSensor.getLightDetected());
                telemetry.addData("Red Left ", colorSensorLeft.red());
                telemetry.addData("Blue Left ", colorSensorLeft.blue());
                telemetry.addData("Red Right ", colorSensorRight.red());
                telemetry.addData("Blue Right ", colorSensorRight.blue());
                telemetry.update();
                if(colorSensorLeft.blue() > 200 && colorSensorLeft.red() < 100 && colorSensorLeft.green() < 100){
                    robot.leftPower.setPower(1.00);
                    robot.rightPower.setPower(.5);
                }
                else if(colorSensorLeft.red() > 200 && colorSensorLeft.blue() < 100 && colorSensorLeft.green() < 100){
                    robot.leftPower.setPower(1.00);
                    robot.rightPower.setPower(1.00);
                }
                else{*/
                robot.leftPower.setPower(.3);
                robot.rightPower.setPower(-.3);
                //}
            }
            else{
                robot.leftPower.setPower(1.00);
                robot.rightPower.setPower(-1.00);
                robot.waitForTick(2000);
                robot.leftPower.setPower(0);
                robot.rightPower.setPower(0);
                break;
            }
            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle();
        }
    }
}
