// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {
  private PWMSparkMax frontLeftMotor;
  private PWMSparkMax frontRightMotor;
  private PWMSparkMax backLeftMotor;
  private PWMSparkMax backRightMotor;

  private DifferentialDrive robotDrive;
  private XboxController controller;

  private double y_axis_speed;
  private double x_axis_speed;

  @Override
  public void robotInit() {
    frontLeftMotor = new PWMSparkMax(0);
    frontRightMotor = new PWMSparkMax(1);
    backLeftMotor = new PWMSparkMax(2);
    frontRightMotor = new PWMSparkMax(3);

    frontLeftMotor.addFollower(backLeftMotor);
    frontRightMotor.addFollower(backRightMotor);

    robotDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
    controller = new XboxController(0);

    frontRightMotor.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    y_axis_speed = -controller.getLeftY() * Constants.MAX_ROBOT_SPEED;
    x_axis_speed = -controller.getRightX() * Constants.MAX_ROBOT_SPEED;

    robotDrive.arcadeDrive(y_axis_speed, x_axis_speed);
  }
}
