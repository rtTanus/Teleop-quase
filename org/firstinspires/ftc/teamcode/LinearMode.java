package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="linearMode", group="Opmode")
@Disabled

public class LinearMode extends LinearOpMode{

    public DcMotor Arm;
    public ElapsedTime runtime = new ElapsedTime();
    double forcalinear = 0;


    @Override
    public void runOpMode() {
        Arm  = hardwareMap.get(DcMotor.class, "Arm");
        Arm.setPower(forcalinear);

        waitForStart();
        runtime.reset();

    }
    public void climbOpMode() {
        boolean subirl = gamepad2.x;
        boolean descerl = gamepad2.y;
        double subir = 1;
        double descer = -1;

        if(subirl){
            Arm.setPower(subir);
        }
        else if(descerl){
            Arm.setPower(descer);
        }

        telemetry.addData("O Tempo de uso do sistema linear é de:", runtime);

        if(subirl)
        {
            telemetry.addData("A Potencia do sistema linear é de:", subir);
        }
        else if(descerl)
        {
            telemetry.addData("A Potencia do sistema linear é de:", descer);
        }
        else{
            telemetry.addData("A Potencia do sistema linear é de:", 0);
        }
    }

}