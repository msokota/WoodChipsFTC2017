/*
    Team 10603's AutoOpMode
    Written by John Gaidimas
 */

package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.ftcrobotcontroller.R;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp(name = "Sensor: MR Color", group = "Sensor")
@Disabled
public class SensorMRColor extends LinearOpMode {

  ColorSensor colorSensorLeft;
  ColorSensor colorSensorRight;


  @Override
  public void runOpMode() throws InterruptedException {

    // bLedOn represents the state of the LED.
    boolean bLedOn = true;

    // get a reference to our ColorSensor object.
    colorSensorLeft = hardwareMap.colorSensor.get("cs Left");
    colorSensorRight = hardwareMap.colorSensor.get("cs Right");

    // Set the LED in the beginning
    colorSensorLeft.enableLed(bLedOn);
    colorSensorRight.enableLed(bLedOn);

    waitForStart();

    while (opModeIsActive()) {
      telemetry.addData("Red Left ", colorSensorLeft.red());
      telemetry.addData("Blue Left ", colorSensorLeft.blue());
      telemetry.addData("Red Right ", colorSensorLeft.red());
      telemetry.addData("Blue Right ", colorSensorLeft.blue());

      telemetry.update();
      idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
    }
  }
}
