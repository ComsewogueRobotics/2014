/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.Robot;

/**
 *
 * @author Andrew
 */
public class DriveTimed extends Command {
    double time;
    double speed;
    public DriveTimed(double s, double t) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        time = t;
        speed = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.drive(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}