package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveSubsystem {
    private final VictorSPX frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;

    public DriveSubsystem() {
        backLeftMotor = new VictorSPX(1);
        frontLeftMotor = new VictorSPX(2);
        frontRightMotor = new VictorSPX(3);
        backRightMotor = new VictorSPX(4);

        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);

        backLeftMotor.setNeutralMode(NeutralMode.Coast);
        frontLeftMotor.setNeutralMode(NeutralMode.Coast);
        frontRightMotor.setNeutralMode(NeutralMode.Coast);
        backRightMotor.setNeutralMode(NeutralMode.Coast);

        frontRightMotor.setInverted(true);
        backRightMotor.setInverted(true);
    }

    public void drive(double speed, double turn) {
        frontLeftMotor.set(VictorSPXControlMode.PercentOutput, speed * calculateVelocity(turn, true));
        frontRightMotor.set(VictorSPXControlMode.PercentOutput, speed * calculateVelocity(turn, false));
    }

    public static double calculateVelocity(double ySpeed, boolean isLeft) {
        return (Math.sin(((isLeft ? ySpeed : -ySpeed) * Math.PI) / 2) + 1) / 2;
    }
}