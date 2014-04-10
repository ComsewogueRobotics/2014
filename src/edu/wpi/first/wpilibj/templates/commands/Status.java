/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Robot;
//import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Andrew
 */
public class Status extends Command {
    private DriverStationEnhancedIO dseio = DriverStation.getInstance().getEnhancedIO();
    //private boolean lastStateFire = Robot.drivetrain.shouldFire();
    //private boolean lastStateTruss = Robot.drivetrain.shouldTruss();
    public Status() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        /*try{
            dseio.setDigitalOutput(13, lastStateFire||lastStateTruss);
            dseio.setDigitalOutput(14, lastStateTruss);
        } catch(Exception e){
            e.printStackTrace();
        }*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        SmartDashboard.putBoolean("Should Fire", Robot.drivetrain.shouldFire());
        SmartDashboard.putBoolean("Blocker Up", Robot.Blocker.isUp());
        SmartDashboard.putNumber("Ultrasonic distance", Robot.drivetrain.getDistance());
        SmartDashboard.putBoolean("Blocker Down", Robot.Blocker.isDown());
        SmartDashboard.putNumber("Gyro output", Robot.drivetrain.gyro.getAngle());
        //SmartDashboard.putNumber("Back Distance", Robot.drivetrain.getDistance());  //broke
        //SmartDashboard.putBoolean("Should Truss Fire", Robot.drivetrain.shouldTruss());
        //try{dseio.setDigitalOutput(13, Robot.oi.getdriveStick().getRawButton(7));} catch(Exception e){}
        //if(Robot.drivetrain.shouldFire()!=lastStateFire||Robot.drivetrain.shouldTruss()!=lastStateTruss){
            //lastStateFire = Robot.drivetrain.shouldFire();
            //lastStateTruss = Robot.drivetrain.shouldTruss();
            try{
                //dseio.setDigitalOutput(13, lastStateFire||lastStateTruss);
                //dseio.setDigitalOutput(14, lastStateTruss);
                dseio.setDigitalOutput(13, Robot.drivetrain.shouldFire());
                
            } catch(Exception e){
                e.printStackTrace();
            }
        //}
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