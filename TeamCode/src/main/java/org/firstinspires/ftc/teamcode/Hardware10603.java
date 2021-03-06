package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class Hardware10603
{
    /* Public OpMode members. */
  //  public DcMotor  leftLift   = null;
  //  public DcMotor  rightLift  = null;
    public DcMotor  leftPower   = null;
    public DcMotor  rightPower  = null;
 //   public Servo    blocker    = null;
//    public Servo    leftBeacon = null;
  //  public Servo    rightBeacon = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware10603(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
     //   leftLift   = hwMap.dcMotor.get("LL");
     //   rightLift  = hwMap.dcMotor.get("RL");
        leftPower   = hwMap.dcMotor.get("LP");
        rightPower  = hwMap.dcMotor.get("RP");
     //   blocker = hwMap.servo.get("block");
 //       leftBeacon = hwMap.servo.get("LB");
   //     rightBeacon = hwMap.servo.get("RB");
        leftPower.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightPower.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
    //    leftLift.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
      //  rightLift.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        //leftLaunch.setPower(0);
        //rightLaunch.setPower(0);
        //blocker.setPosition(1.0);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        //leftLaunch.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //rightLaunch.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

