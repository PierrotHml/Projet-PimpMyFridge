package model;

import gnu.io.CommPortIdentifier;
import view.View;

public class Fridge {

	
	static View myView;
	private static ManageData manageData;
	private static ArduinoLink arduino;
	private static Regulation regulation;
	private static int order = 0;
	private int time = 0;
	private int refreshTime = 2000;
	private static boolean state = true; // false = turn off || true = turn on
	
	
	public Fridge(CommPortIdentifier portCom){
		
		enableView(portCom.getName());
		
		manageData = new ManageData();
		arduino = new ArduinoLink(portCom, manageData);
		regulation = new Regulation(arduino, manageData, myView);
		
		
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
		regulation.start();
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
	
	public static boolean getState(){
		return state;
	}
	
	public void setState(boolean buttonState){
		state = buttonState;
		myView.tell_frdige_state(state);
	}
}
