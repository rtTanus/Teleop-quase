package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "MotoresRobo", group = "LinearOpMode")
@Disabled
public class TeleOperado extends LinearOpMode{

    public DcMotor motorEsquerdoFrente, motorEsquerdoTras, motorDireitoFrente, motorDireitoTras = null;
    public ElapsedTime runtime = new ElapsedTime();
    double poderTrasTotal;
    double poderEsquedaAll;


    @Override
    public void runOpMode(){
        motorEsquerdoFrente  = hardwareMap.get(DcMotor.class, "leftDriveUp");
        motorDireitoFrente  = hardwareMap.get(DcMotor.class, "RightDriveUp");
        motorEsquerdoTras = hardwareMap.get(DcMotor.class, "LeftDriveDown");
        motorDireitoTras = hardwareMap.get(DcMotor.class, "RightDriveDown");

        motorEsquerdoFrente.setDirection(DcMotor.Direction.FORWARD);
        motorDireitoFrente.setDirection(DcMotor.Direction.FORWARD);
        motorEsquerdoTras.setDirection(DcMotor.Direction.REVERSE);
        motorDireitoTras.setDirection(DcMotor.Direction.REVERSE);

        allMotorsPower(0,0,0,0);

        waitForStart();
        runtime.reset();
    }

    public void climbOpMode() {
            double axial   = -gamepad1.left_stick_y;
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;

            double denominador = Math.max(Math.abs(axial) + Math.abs(lateral) + Math.abs(yaw), 1);
            double motorEsquerdoFt  = axial + lateral + yaw / denominador;
            double motorDiretoFt = axial - lateral - yaw / denominador;
            double motorEsquerdoTt   = axial - lateral + yaw / denominador;
            double motorDireitoTt  = axial + lateral - yaw / denominador;

            allMotorsPower(motorEsquerdoFt,motorDiretoFt,motorEsquerdoTt,motorDireitoTt);
    }



    public void allMotorsPower(double paMEF, double paMDF, double paMET, double paMDT){
        motorEsquerdoFrente.setPower(paMEF);
        motorDireitoFrente.setPower(paMDF);
        motorEsquerdoTras.setPower(paMET);
        motorDireitoTras.setPower(paMDT);
    }
}
