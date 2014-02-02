/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.LEDRingOn;

/**
 *
 * @author Andrew
 */
public class CameraLights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private static Relay lights = RobotMap.cameraLights;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    public void setOn(){
        lights.set(Relay.Value.kOn);
    }
    public void setOff(){
        lights.set(Relay.Value.kOff);
    }
}