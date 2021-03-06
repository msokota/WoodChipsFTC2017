/*
    Team 10603's Hardware Testing OpMode
        Written by Molly Sokota
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.util.RobotLog;
import org.firstinspires.ftc.teamcode.Hardware10603;

@TeleOp(name="TeleOp", group="10603")

public class TeleOp10603 extends LinearOpMode {

    /* Declare OpMode members. */
    Hardware10603 robot           = new Hardware10603();   // Use a Pushbot's hardware

    @Override
    public void runOpMode() throws InterruptedException {
        double left;
        double right;
        double max;
      //  boolean liftdrop;
      //  double lift;
        //boolean rBeacon;
        //boolean lBeacon;
        //boolean beaconsBack;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Startup Complete");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            right = gamepad1.right_stick_y;
            left = gamepad1.left_stick_y;
     //       liftdrop = gamepad1.b;
      //      lift = gamepad2.right_stick_y;
           /* rBeacon = gamepad1.right_bumper;
            lBeacon = gamepad1.left_bumper;
            beaconsBack = gamepad1.a;
*/
            max = Math.max(Math.abs(left), Math.abs(right));
            if (max > .25)
            {
                left /= max;
                right /= max;
            }
            robot.rightPower.setPower(right);
            robot.leftPower.setPower(left);
/*
            if(liftdrop){
                robot.blocker.setPosition(.5);
            }

            if(rBeacon){
                robot.rightBeacon.setPosition(.7);
            }
            if(!rBeacon){
                robot.rightBeacon.setPosition(.5);
            }

            if(lBeacon){
                robot.leftBeacon.setPosition(.7);
            }
            if(!lBeacon){
                robot.leftBeacon.setPosition(.5);
            }

            if(beaconsBack){
                robot.leftBeacon.setPosition(.3);
                robot.rightBeacon.setPosition(.3);
            }

            robot.leftLift.setPower(lift);
            robot.rightLift.setPower(lift);
*/

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
        }
    }
}

