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
public class LowerLauncher extends Command {
    
    public LowerLauncher() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.launcher.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.getshootStick().getTrigger()&&!Robot.oi.getshootStick().getTrigger();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.launcher.raise();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}