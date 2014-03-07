/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Andrew
 */
public class Blocker extends Subsystem {
    private Relay motor = RobotMap.blockerMotor;
    private DigitalInput top = new DigitalInput(2);
    private DigitalInput bottom = new DigitalInput(3);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void goUp(){
        motor.set(Relay.Value.kForward);
    }
    public void goDown(){
        motor.set(Relay.Value.kReverse);
    }
    public void stop(){
        motor.set(Relay.Value.kOff);
    }
    public boolean isUp(){
        return !top.get();
    }
    public boolean isDown(){
        return !bottom.get();
    }
}