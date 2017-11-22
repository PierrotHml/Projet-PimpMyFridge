package model;

import gnu.io.CommPortIdentifier;
import view.View;

public class Fridge {

	
	static View myView;
	private static ManageData manageData;
	private static ArduinoLink arduino;
	private static int order = 0;
	
	
	public Fridge(CommPortIdentifier portCom){
		
		enableView();
		
		manageData = new ManageData();
		arduino = new ArduinoLink(portCom);
		
		
		Thread refreshFrame = new Thread(){
			public void run() {
				
			}
		};
		
		refreshFrame.start();

		new Regulation(arduino, manageData).start();
	}
	
	
	public static void enableView(){
		
		myView = new View();
	}
	
	
	public ArduinoLink getArduinoLink(){
		return arduino;
	}
	
	
	public void setOrder(int order){
		Fridge.order = order;
		System.out.println(Fridge.order);
	}
	
	
	public int getOrder(){
		return order;
	}
	
	
	public void uptadeView(){
		
	}
}
