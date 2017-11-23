package model;

import gnu.io.CommPortIdentifier;
import view.View;

public class Fridge {

	
	static View myView;
	private static ManageData manageData;
	private static ArduinoLink arduino;
	private static int order = 0;
	private int time = 0;
	private int refreshTime = 2000;
	
	
	public Fridge(CommPortIdentifier portCom){
		
		enableView(portCom.getName());
		
		manageData = new ManageData();
		arduino = new ArduinoLink(portCom, manageData);
		//new Regulation(arduino, manageData).start();
		
		Thread refreshFrame = new Thread(){
			public void run() {
				
				try {
					
					while(true){
					
						myView.update_fridge_temperature(manageData.getData("celsius"), time);
						myView.update_fridge_humidity(manageData.getData("humidity"), time);
						refreshView();
						time += refreshTime;
						Thread.sleep(refreshTime);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		};
		refreshFrame.start();
	}
	
	
	
	public static void enableView(String portName){
		
		myView = new View(portName);
	}
	
	
	public void refreshView(){
		
		myView.refresh();
	}
	
	
	public ArduinoLink getArduinoLink(){
		return arduino;
	}
	
	
	public void setOrder(int order){
		Fridge.order = order;
	}
	
	
	public static int getOrder(){
		return order;
	}
}
