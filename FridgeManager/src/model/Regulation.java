package model;

public class Regulation extends Thread{

	private ArduinoLink arduino;
	private ManageData manageData;
	
	public Regulation(ArduinoLink arduino, ManageData manageData){
		
		super("Regulation");
		this.arduino = arduino;
		this.manageData = manageData;
	}
	
	public void run(){
		
		try {
			while(true){
				if(manageData.getData("celsius") > Fridge.getOrder()) arduino.turnOnPeltier();
				else if(manageData.getData("celsius") <= Fridge.getOrder()) arduino.turnOffPeltier();
				Regulation.sleep(5000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
