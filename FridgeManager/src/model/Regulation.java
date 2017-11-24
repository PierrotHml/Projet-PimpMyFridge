package model;

import view.View;

public class Regulation extends Thread{

	private ArduinoLink arduino;
	private ManageData manageData;
	private View myView;
	
	public Regulation(ArduinoLink arduino, ManageData manageData, View myView){
		
		super("Regulation");
		this.arduino = arduino;
		this.manageData = manageData;
		this.myView = myView;
	}
	
	public void run(){
		
		try {
			while(true){
				
				if(Fridge.getState() != false){
					if(manageData.getData("celsius") > Fridge.getOrder()){
						
						arduino.turnOnPeltier();
						myView.swapFridgePicture(true);
					}
					else if(manageData.getData("celsius") <= Fridge.getOrder()){
						
						arduino.turnOffPeltier();
						myView.swapFridgePicture(false);
					}
				}
				else arduino.turnOffPeltier();
				
				myView.tell_condensation_risk_alert(true);
				Regulation.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
