// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package edu.wpi.first.wpilibj.templates;
    
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    public static SpeedController drivetrainLeft1;
    public static SpeedController drivetrainLeft2;
    public static SpeedController drivetrainRight1;
    public static SpeedController drivetrainRight2;
    public static RobotDrive drivetrainRobotDrive41;
    public static Solenoid launcherElevator;
    public static Solenoid shoot1;
    public static Solenoid shoot2;
    public static Relay cameraLights;
    public static Compressor compressorObj;
    public static Relay roller;
    public static AnalogChannel ultrasonic;
    public static void init() {

        drivetrainLeft1 = new Jaguar(1, 1);
	LiveWindow.addActuator("drivetrain", "Left1", (Jaguar) drivetrainLeft1);
        
        drivetrainLeft2 = new Jaguar(1, 2);
	LiveWindow.addActuator("drivetrain", "Left2", (Jaguar) drivetrainLeft2);
        
        drivetrainRight1 = new Jaguar(1, 3);
	LiveWindow.addActuator("drivetrain", "Right1", (Jaguar) drivetrainRight1);
        
        drivetrainRight2 = new Jaguar(1, 4);
	LiveWindow.addActuator("drivetrain", "Right2", (Jaguar) drivetrainRight2);
        
        drivetrainRobotDrive41 = new RobotDrive(drivetrainLeft1, drivetrainLeft2,
              drivetrainRight1, drivetrainRight2);
        ultrasonic = new AnalogChannel(2);
	SmartDashboard.putNumber("Ultrasonic Raw output", ultrasonic.getVoltage());
        drivetrainRobotDrive41.setSafetyEnabled(true);
        drivetrainRobotDrive41.setExpiration(0.1);
        drivetrainRobotDrive41.setSensitivity(0.5);
        drivetrainRobotDrive41.setMaxOutput(1.0);
        
        
        launcherElevator = new Solenoid(1);
        shoot1 = new Solenoid(2);
        shoot2 = new Solenoid(3);
        
        
        compressorObj = new Compressor(1, 1);
        roller = new Relay(2);
        
        cameraLights = new Relay(3);
        
        
    }
}
