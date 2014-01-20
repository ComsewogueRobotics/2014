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
public class Fire extends Command {
    
    public Fire() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.launcher);
        setTimeout(.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.launcher.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.launcher.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}