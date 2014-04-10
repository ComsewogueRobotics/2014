/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Gyro;
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

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    SpeedController left1 = RobotMap.drivetrainLeft1;
    SpeedController left2 = RobotMap.drivetrainLeft2;
    SpeedController right1 = RobotMap.drivetrainRight1;
    SpeedController right2 = RobotMap.drivetrainRight2;
    RobotDrive robotDrive41 = RobotMap.drivetrainRobotDrive41;
    //AnalogChannel ultrasonic = RobotMap.ultrasonic;   //old, broken
    AnalogChannel ultrasonic = RobotMap.ultrasonic;
    public Gyro gyro = RobotMap.gyro;
    private final double MAX_DISTANCE = 40;
    private final double MIN_DISTANCE = 35;
    //private final double MIN_TRUSS_DIST = 248;        //These aren't the distances from the truss, they are the distances
    //private final double MAX_TRUSS_DIST = 262;        //from the back of the robot to the wall behind it.
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
    /*public double getDistance(){
        //return (ultrasonic.getAverageVoltage()*102.4)/2.54; //incorrect inches 
        return ultrasonic.getAverageVoltage()*39.6858904; //correct inches?
    }*/
    public double getDistance(){     //This is the ultra that used to be on the back, but due 
        return ultrasonic.getAverageVoltage()*81.026032; //to the front one being destroyed, this one is taking over as primary. (moved to front)
    }
    /*public boolean shouldTruss(){
        if(getDistFromBack() > MIN_TRUSS_DIST && getDistFromBack() < MAX_TRUSS_DIST)
            return true;
        return false;
    }*/
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        robotDrive41.setLeftRightMotorOutputs(-output, -output);
    }
    public void arcadeDrive(double y,double x){
        robotDrive41.arcadeDrive(y, x);
    }
    public void drive(double lSpeed, double rSpeed){
        robotDrive41.setLeftRightMotorOutputs(lSpeed, rSpeed);
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