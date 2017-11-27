package model;

import java.lang.Math;
import java.text.DecimalFormat;


public class ManageData{
	
	private static float data[] = {(float) 0, (float) 0, (float) 0, (float) 0}; 
	private static float R2, V0, celsius, kelvin;
	private static float humidity;
	private static float celsiusDHT22; 
	private static boolean doorState = false; //false = fermé  |  true = ouvert
	static DecimalFormat df = new DecimalFormat("0.##");
	
	public float getRosePoint(){
	
		float alpha = (float) ((17.27 * celsius) / (237.7 + celsius) + Math.log(humidity/100));
		return (float)(237.7 * alpha) / (float)(17.27 - alpha);
	}
	
	
	public boolean getdoorState() {
		return doorState;
	}


	public void setDoorState(boolean doorState) {
		ManageData.doorState = doorState;
	}


	
	
	
	public static String roundData(float data){
		
		return df.format(data);
	}
	
	
	public void setTemp(float pinValue){
		
		V0 = (float) ((float) pinValue/205);
		R2 = (float) (( (float) 10000*V0)/( (float)5-V0));
		kelvin = (float) (1 / (0.001096 + 0.00024 * Math.log(R2) + (5.87 * Math.pow(10, -8)) * Math.pow(Math.log(R2), 3)));
		celsius = (float) (kelvin - 273.15);

		data[0] = V0; data[1] = R2; data[2] = kelvin; data[3] = celsius;
	}
	
	
	public void setHumidity(float pinValue){

		humidity = pinValue;
	}
	
	
	public void setTempDHT22(float pinValue){
		
		celsiusDHT22 = pinValue;
	}
	
	
	public float getData(String dataType){
		
		switch(dataType){
		
		case "V0":
			return data[0];
		case "R2":
			return data[1];
		case "kelvin":
			return data[2];
		case "celsius":
			return data[3];
		case "humidity":
			return humidity;
		case "celsiusDHT22":
			return celsiusDHT22;
		
		default :
			return 0;
		}
	}
}
