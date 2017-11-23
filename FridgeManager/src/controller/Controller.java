package controller;

import java.util.Enumeration;

import javax.swing.JOptionPane;

import gnu.io.CommPortIdentifier;
import model.Fridge;

public class Controller
{
	static CommPortIdentifier serialPortId;
	static Enumeration<?> enumComm;
	static CommPortIdentifier comPort;
	private static Fridge system;
	
	
	public Controller(){
		
		do{
			serialPortId = findPort();
			
			if(serialPortId == null){
				int option = JOptionPane.showConfirmDialog(null, "Please connect your Arduino to your computer and select 'OK'.", "Arduino undetected", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(option == JOptionPane.CANCEL_OPTION) System.exit(-1);
			}
			
		}while (serialPortId == null);
	
		system = new Fridge(serialPortId);
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
		system.refreshView();
	}
}
