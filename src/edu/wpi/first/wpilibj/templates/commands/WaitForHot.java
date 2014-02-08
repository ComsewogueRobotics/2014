/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Robot;
import edu.wpi.first.wpilibj.templates.Shape;

/**
 *
 * @author Andrew
 */

public class WaitForHot extends Command {
    private int timer = 0;
    private NetworkTable table;
    public WaitForHot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getIsHot();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    protected boolean getIsHot() throws ArrayIndexOutOfBoundsException{
        int numHot = 0;
        int numCold = 0;
        table = NetworkTable.getTable("CameraData");
        NumberArray rawData = new NumberArray();
        table.retrieveValue("SHAPES", rawData);
        String shapesPath = table.getString("SHAPES_PATH");
        try{
        double[] tmp = new double[9];
        Shape[] shapes = new Shape[3];
        if(rawData.size()>18){
        for(int i=0; i<27; i++){
            if(i<9)
                tmp[i] = rawData.get(i);
            if(i==8)
                 shapes[0] = new Shape(tmp, shapesPath);
            if(i>8&&i<18)
                tmp[i-9] = rawData.get(i); 
            if(i==17)
                shapes[1] = new Shape(tmp, shapesPath);
            if(i>18)
                tmp[i-18] = rawData.get(i);
            if(i==26)
                shapes[2] = new Shape(tmp, shapesPath);
        }
        for(int i=0; i<3; i++){
            if(shapes[i].getConf()>80){
           //     System.out.println("DEBUG: name="+shapes[i].getName());
                if(shapes[i].getName().equals("Hot"))
                    numHot++;
                else
                    numCold++;
            }
        }
        } else if(rawData.size()>8){
        for(int i=0; i<18; i++){
            if(i<9)
                tmp[i] = rawData.get(i);
            if(i==8)
                 shapes[0] = new Shape(tmp, shapesPath);
            if(i>8&&i<18)
                tmp[i-9] = rawData.get(i); 
            if(i==17)
                shapes[1] = new Shape(tmp, shapesPath);
        }
        for(int i=0; i<2; i++){
            if(shapes[i].getConf()>80){
                System.out.println("DEBUG: name="+shapes[i].getName());
                if(shapes[i].getName().equals("Hot"))
                    numHot++;
                else
                    numCold++;
            }
        }
            
        } else return false;
        } catch(Exception e){
            e.printStackTrace();
            timer++;
            if(timer==150)
                return true;
            return false;
        }
        //for(int i=0;i<3;i++)
          //  System.out.println("Shape "+i+": Status="+shapes[i].getName()+";\tConf="+shapes[i].getConf());
        SmartDashboard.putNumber("Number Hot", numHot);
        SmartDashboard.putNumber("Number Cold", numCold);
        if(numHot>=1&&numCold>=1){
            System.out.println("Target confirmed hot, WHISKEY OSCAR TANGO FOXTROT FIRE FIRE FIRE");
            return true;
        }
        else
            return false;
    }
}
