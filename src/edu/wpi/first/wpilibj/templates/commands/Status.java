/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationEnhancedIO.EnhancedIOException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Robot;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Andrew
 */
public class Status extends Command {
    
    public Status() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        SmartDashboard.putBoolean("Should Fire", Robot.drivetrain.shouldFire());
        SmartDashboard.putBoolean("Blocker Up", Robot.Blocker.isUp());
        SmartDashboard.putNumber("Ultrasonic distance", Robot.drivetrain.getDistance());
        SmartDashboard.putBoolean("Blocker Down", Robot.Blocker.isDown());
        SmartDashboard.putNumber("Gyro output", Robot.drivetrain.gyro.getAngle());
        SmartDashboard.putNumber("Back Distance", Robot.drivetrain.getDistFromBack());
        SmartDashboard.putBoolean("Should Truss Fire", Robot.drivetrain.shouldTruss());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}