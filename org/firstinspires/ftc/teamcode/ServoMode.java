package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "ServoMode", group = "OpMode")
@Disabled
public class ServoMode extends LinearOpMode{

    public Servo servoMotor;
    public ElapsedTime runtime = new ElapsedTime();
    double garraAberta = 0;
    double garraFechada = 1;

    @Override
    public void runOpMode(){

        servoMotor = hardwareMap.get(Servo.class,"Intake");
        servoMotor.setPosition(garraAberta);

        waitForStart();
        runtime.reset();
    }

    public void climbOpMode(){
        boolean garraA = gamepad2.a;
        boolean garraF = gamepad2.b;

        if (garraF){
            servoMotor.setPosition(garraFechada);
        }
        else if (garraA){
            servoMotor.setPosition(garraAberta);
        }

        telemetry.addData("O Tempo de uso no servo é de:", runtime);

        if(garraF)
        {
            telemetry.addData("A Potencia do servo é de:", garraFechada);
        }
        else if(garraA)
        {
            telemetry.addData("A Potencia do servo  é de:", garraAberta);
        }
        else{
            telemetry.addData("A Potencia do servo  é de:", 0);
        }
    }




}
