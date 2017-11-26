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
				
				//If the fridge is turn on or turn off
				if(Fridge.getState() != false){
					
					//Peltier control
					if(manageData.getData("celsius") > Fridge.getOrder()){
						
						arduino.turnOnPeltier();
						myView.swapFridgePicture(true);
					}
					else if(manageData.getData("celsius") <= Fridge.getOrder()){
						
						arduino.turnOffPeltier();
						myView.swapFridgePicture(false);
					}
					
					//Condensation risk alert
					if(Fridge.getOrder() <= manageData.getRosePoint()) myView.tell_condensation_risk_alert(true);	
					else myView.tell_condensation_risk_alert(false);
				}
				else{
					arduino.turnOffPeltier();
					myView.tell_condensation_risk_alert(false);
				}
				
				//Door alert
				if(manageData.getdoorState()) myView.tell_opened_door_alert(true);
				else myView.tell_opened_door_alert(false);
				
				if(manageData.getdoorState() || Fridge.getOrder() <= manageData.getRosePoint() && Fridge.getState() != false) myView.launchAlertAnim(true);
				else myView.launchAlertAnim(false);
				
				Regulation.sleep(2000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
