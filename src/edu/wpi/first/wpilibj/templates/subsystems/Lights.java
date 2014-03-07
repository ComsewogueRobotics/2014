/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Andrew
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static Relay lights = RobotMap.cameraLights;
    private static Relay decLights = RobotMap.decLights;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    public void setOn(){
        lights.set(Relay.Value.kReverse);
    }
    public void setOff(){
        lights.set(Relay.Value.kOff);
    }
    public void decOn(){
        decLights.set(Relay.Value.kForward);
    }
    public void decOff(){
        decLights.set(Relay.Value.kOff);
    }
}