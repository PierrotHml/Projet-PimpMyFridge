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
		arduino = new ArduinoLink(portCom, manageData);
		//new Regulation(arduino, manageData).start();
		
		Thread refreshFrame = new Thread(){
			public void run() {
				
				try {
					
					while(true){
					
						myView.update_fridge_temperature(manageData.getData("celsiusDHT22"));
						myView.update_cooler_temperature(manageData.getData("celsius"));
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		};
		refreshFrame.start();
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
}
