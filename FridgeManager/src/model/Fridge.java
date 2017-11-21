package model;

import gnu.io.CommPortIdentifier;
import view.View;

public class Fridge {

	
	static View myView;
	static ManageData manageData;
	static ArduinoLink arduino;
	
	public Fridge(CommPortIdentifier portCom){
		
		enableView();
		
		manageData = new ManageData();
		//arduino = new ArduinoLink(portCom);
		
		Thread refreshFrame = new Thread(){
			public void run() {
				
			}
		};
		
		refreshFrame.start();
	}
	
	public static void enableView(){
		
		myView = new View();
	}
	
	public static void setFridgeTempC(){
		
		
	}
}
