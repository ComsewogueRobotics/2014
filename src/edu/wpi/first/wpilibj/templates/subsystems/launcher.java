/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Andrew
 */
public class launcher extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Solenoid right = RobotMap.launcherElevator;
    Solenoid shoot1 = RobotMap.shoot1;
    Solenoid shoot2 = RobotMap.shoot2;
    Relay roller = RobotMap.roller;
    boolean raised = true;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void raise(){
        right.set(false);
        raised = true;
    }
    public void lower(){
        right.set(true);
        raised = false;
    }
    public boolean isRaised(){
        return raised;
    }
    public void suck(){
        roller.set(Relay.Value.kForward);
    }
    public void blow(){
        roller.set(Relay.Value.kReverse);
    }
    public void stop(){
        roller.set(Relay.Value.kOff);
    }
    public void shoot(){
        shoot1.set(true);
        shoot2.set(true);
    }
    public void retract(){
        shoot1.set(false);
        shoot2.set(false);
    }
}