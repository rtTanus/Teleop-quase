
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "TeleOpTodos", group = "TeleOp")
public class TeleOpTodos extends OpMode{
    public LinearMode linear1 = new LinearMode();
    public ServoMode servo1 = new ServoMode();
    public TeleOperado teleop1 = new TeleOperado();

    @Override
    public void init() {
        linear1.runOpMode();
        servo1.runOpMode();
        teleop1.runOpMode();
    }
    @Override
    public void loop(){
        linear1.climbOpMode();
        servo1.climbOpMode();
        teleop1.climbOpMode();
    }

}