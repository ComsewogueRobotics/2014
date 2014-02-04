/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.*;

/**
 *
 * @author Andrew
 */
public class drivetrain extends PIDSubsystem {

    private static final double Kp = 25;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    SpeedController left1 = RobotMap.drivetrainLeft1;
    SpeedController left2 = RobotMap.drivetrainLeft2;
    SpeedController right1 = RobotMap.drivetrainRight1;
    SpeedController right2 = RobotMap.drivetrainRight2;
    RobotDrive robotDrive41 = RobotMap.drivetrainRobotDrive41;
    AnalogChannel ultrasonic = RobotMap.ultrasonic;
    private double MAX_DISTANCE = 68;
    private double MIN_DISTANCE = 63;
    // Initialize your subsystem here
    public drivetrain() {
        super("drivetrain", Kp, Ki, Kd);
        
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new normalDrive());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return getDistance();
    }
    public double getDistance(){
        return (ultrasonic.getAverageVoltage()*102.4)/2.54; //inches 
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        robotDrive41.setLeftRightMotorOutputs(-output, -output);
    }
    public void arcadeDrive(double y,double x){
        robotDrive41.arcadeDrive(y, x);
    }
    public void drive(double speed){
        robotDrive41.setLeftRightMotorOutputs(speed, speed);
    }
    public void stop(){
        robotDrive41.stopMotor();
    }
    public void setSafetyEnabled(boolean x){
        robotDrive41.setSafetyEnabled(x);
    }
    public AnalogChannel getUltrasonic(){
        return ultrasonic;
    }
    public boolean shouldFire(){
        if(getDistance()<MAX_DISTANCE&&getDistance()>MIN_DISTANCE) return true;
        return false;
    }
}