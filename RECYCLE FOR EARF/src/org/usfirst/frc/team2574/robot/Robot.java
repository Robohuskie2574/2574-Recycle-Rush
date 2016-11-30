
package org.usfirst.frc.team2574.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Talon left2, right2;
	CANTalon left1;
	CANTalon right1;
	RobotDrive drive1;
	DoubleSolenoid piston1, piston2, arm1;
	Joystick joystick1;
	
	
	
    public void robotInit() {
    	left1 = new CANTalon(4);
    	right1 = new CANTalon(3);
    	drive1 = new RobotDrive(left1, right1);
    	piston1 = new DoubleSolenoid(0, 1);
    	piston2 = new DoubleSolenoid(2, 3);
    	arm1 = new DoubleSolenoid(4, 5);
    	left2 = new Talon(0);
    	right2 = new Talon(1);
    	joystick1 = new Joystick(0);
    	
    	
	

    }



	/**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive1.arcadeDrive(joystick1.getRawAxis(1), -joystick1.getRawAxis(0));
        
        if(joystick1.getRawButton(1) && !joystick1.getRawButton(2)) {
        	left2.set(1);
        	right2.set(-1);
        } else if(joystick1.getRawButton(2) && !joystick1.getRawButton(1)) {
        	left2.set(-1);
        	right2.set(1);
        } else {
        	left2.set(0);
        	right2.set(0);
        }
        
        if(joystick1.getRawButton(3) && !joystick1.getRawButton(5)) {
        	piston1.set(Value.kForward);
        	piston2.set(Value.kForward);
        } else if(joystick1.getRawButton(5) && !joystick1.getRawButton(3)) {
        	piston1.set(Value.kReverse);
        	piston2.set(Value.kReverse);
        }
        
        if(joystick1.getRawButton(7) && !joystick1.getRawButton(9)) {
        	arm1.set(Value.kForward);
        } else if(joystick1.getRawButton(9) && !joystick1.getRawButton(7)) {
        	arm1.set(Value.kReverse);
        }
    }
   
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
