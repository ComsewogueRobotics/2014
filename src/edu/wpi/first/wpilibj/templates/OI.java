// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    

    public Joystick driveStick;
    public Joystick shootStick;

    

    public OI() {

        
        shootStick = new Joystick(2);
        
        driveStick = new Joystick(1);
        

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("LEDs On", new LEDRingOn());
        SmartDashboard.putData("LEDs Off", new LEDRingOff());

        
        
        
        Button driveButton1 = new JoystickButton(driveStick, 1);
        Button driveButton2 = new JoystickButton(driveStick, 2);
        Button shootButton1 = new JoystickButton(shootStick, 1);
        Button shootButton2 = new JoystickButton(shootStick, 2);
        Button shootButton4 = new JoystickButton(shootStick, 4);
        Button shootButton5 = new JoystickButton(shootStick, 5);
        
        driveButton1.whenPressed(new LowerLauncher());
        driveButton2.whileHeld(new Collect());
        shootButton1.whenPressed(new LowerLauncher());
        shootButton2.whenPressed(new Fire());
        shootButton4.whileHeld(new Collect());
        shootButton5.whileHeld(new Release());
        Robot.compressor.turnOn();

    }
    

    public Joystick getdriveStick() {
        return driveStick;
    }

    public Joystick getshootStick() {
        return shootStick;
    }
    


    public double getDriveRotate(){
        return driveStick.getX();
    }
    public double getDriveY(){
        return driveStick.getY();
    }

}
