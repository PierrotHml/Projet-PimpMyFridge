package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class ArduinoLink implements SerialPortEventListener{

	private CommPortIdentifier comPort;
	private SerialPort serialPort;
	private BufferedReader input;
	private OutputStream output;
	
	public ArduinoLink(CommPortIdentifier comPort){
		
		this.comPort = comPort;
		initLink();
	}
	
	
	public void initLink() {

		try {
			// open serial port, and use class name for the appName.
			serialPort = (SerialPort) comPort.open(this.getClass().getName(), 3000);
			// set port parameters
			serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			// open the streams
			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			output = serialPort.getOutputStream();

			// add event listeners
			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	
	@Override
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			
			try {
				String inputLine = input.readLine();
				
				System.out.println(inputLine);
				ManageData.setData(Integer.parseInt(inputLine));
				
			} catch (Exception e) {
				
				System.err.println(e.toString());
			}
		}
	}
	
	
	public synchronized void close() {
		
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}
}
