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
			Regulation.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		while(true){
			
			try {
				arduino.turnOnPeltier();
				System.out.println("TURN ON");
				Regulation.sleep(10000);
				arduino.turnOffPeltier();
				System.out.println("TURN OFF");
				Regulation.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} 
}
