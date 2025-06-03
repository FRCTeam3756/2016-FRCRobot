// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.DriveSubsystem;

public class Robot extends TimedRobot {
  private XboxController controller;
  private DriveSubsystem driveSubsystem;

  @Override
  public void robotInit() {
    driveSubsystem = new DriveSubsystem();
    controller = new XboxController(0);
  }

  @Override
  public void teleopPeriodic() {
    double speed = -controller.getLeftX() * Constants.MAX_ROBOT_SPEED;
    double turn = -controller.getLeftY() * Constants.MAX_ROBOT_SPEED;

    driveSubsystem.drive(speed, turn);
  }

  @Override
  public void autonomousPeriodic() {
    driveSubsystem.drive(0.3, 0.0);
  }
}
