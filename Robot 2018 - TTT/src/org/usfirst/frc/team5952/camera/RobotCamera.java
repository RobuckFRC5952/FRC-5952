package org.usfirst.frc.team5952.camera;

import edu.wpi.cscore.UsbCamera;;

public class RobotCamera extends UsbCamera {

	/**
	 * Définition d'une caméra usb avec un identifiant unique.
	 * @param name
	 * @param dev
	 */
	public RobotCamera(String name, int dev) {
		super(name, dev);
	}

}
