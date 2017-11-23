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
			
			while(true){

			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
