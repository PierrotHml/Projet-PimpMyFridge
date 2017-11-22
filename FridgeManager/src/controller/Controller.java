package controller;

import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import model.Fridge;

public class Controller
{
	static CommPortIdentifier serialPortId;
	static Enumeration<?> enumComm;
	static CommPortIdentifier comPort;
	private static Fridge system;
	
	public Controller(){
		
		system = new Fridge(findPort());
	}
	
	public static CommPortIdentifier findPort(){
		
		enumComm = CommPortIdentifier.getPortIdentifiers();
		
		while(enumComm.hasMoreElements()){
			serialPortId = (CommPortIdentifier)enumComm.nextElement();
			if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) return serialPortId;
		}
		return null;
	}
	
	public static void updateModelValue(){
		
		system.getArduinoLink().dataEvent();
	}
	
	public static void updateOrder(int order){
		
		system.setOrder(order);
	}
}
