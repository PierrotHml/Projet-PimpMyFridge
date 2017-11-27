package view;

import java.util.TooManyListenersException;
import controller.ListenerSerialEvent;
import gnu.io.SerialPort;

public class VirtualLink{

	public VirtualLink(SerialPort serialPort) throws TooManyListenersException{
		
		serialPort.addEventListener(new ListenerSerialEvent());
		serialPort.notifyOnDataAvailable(true);
	}
}
