/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Robot;

/**
 *
 * @author Andrew
 */
public class DriveToDistance extends Command {
    private double setpoint;
    private double initDistance;
    private double speed;
    private final double SLOW = .4;
    private final double MED = .5;
    private final double FAST = .6;
    private double next;
    private final double DIST_SCALE = .85;
    private final double SPEED_SCALE = .75;
    private double kP = .003;
    public DriveToDistance(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        this.setpoint = setpoint;
        initDistance = Robot.drivetrain.getDistance()-setpoint;
        next = initDistance*DIST_SCALE;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        /*Robot.drivetrain.setSetpoint(setpoint);        
        Robot.drivetrain.enable();
        */
        Robot.drivetrain.gyro.reset();
        if(initDistance <= 20)
            speed = SLOW;
        else if(initDistance < 50)
            speed = MED;
        else speed = FAST;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //SmartDashboard.putNumber("Ultrasonic distance", Robot.drivetrain.getDistance()); //Deprecated by Status()
        if(Robot.drivetrain.getDistance() < next){
            next = next*DIST_SCALE;
            speed = speed*SPEED_SCALE;
        }
        SmartDashboard.putNumber("speed w/correction", speed+(Robot.drivetrain.gyro.getAngle()*kP));
        SmartDashboard.putNumber("speed w/not corrected", speed);
        Robot.drivetrain.drive(speed, speed+Robot.drivetrain.gyro.getAngle()*kP);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return Math.abs(Robot.drivetrain.getDistance()-setpoint) < .02;
        return Robot.drivetrain.getDistance() <=setpoint;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("DriveToDistance finished");
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}