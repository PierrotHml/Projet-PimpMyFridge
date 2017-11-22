package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import view.VirtualLink;

public class ArduinoLink{

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
			
			//add event
			new VirtualLink(serialPort);

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	
	public void dataEvent(){
		
		try {
			String inputLine = input.readLine();
			System.out.println(inputLine);
			ManageData.setData(Integer.parseInt(inputLine));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("InputLine null");
		}
	}
	
	
	public synchronized void close() {
		
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
			
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
