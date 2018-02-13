package org.usfirst.frc.team5952.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class LimitSwitch extends Subsystem {
	private DigitalInput m_limitSwitch;
	private Counter m_limitSwitchCounter;

	public LimitSwitch(int channel) {
		m_limitSwitch = new DigitalInput(channel);
		m_limitSwitchCounter = new Counter(m_limitSwitch);
		m_limitSwitchCounter.setUpSourceEdge(true, false);
	}
	
	public boolean isTriggered() {
		return m_limitSwitchCounter.get() > 0;
	}
	
	public void resetCounter() {
		m_limitSwitchCounter.reset();
	}

	public void initDefaultCommand() { }
}
