package controller;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;


public class ListenerSerialEvent  implements SerialPortEventListener{

	@Override
	public void serialEvent(SerialPortEvent uno) {
		
		if (uno.getEventType() == SerialPortEvent.DATA_AVAILABLE) Controller.updateModelValue();
	}
}
