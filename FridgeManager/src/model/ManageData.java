package model;

import java.lang.Math;
import java.text.DecimalFormat;


public class ManageData{
	
	private static float data[] = {(float) 0, (float) 0, (float) 0, (float) 0}; 
	private static float R2, V0, celsius, kelvin;
	
	static DecimalFormat df = new DecimalFormat("0.##");
	
	
	public static String roundData(float data){
		
		return df.format(data);
	}
	
	
	public static void setData(int arduinoAnalog3){
		
		V0 = (float) ((float) arduinoAnalog3/205);
		R2 = (float) (( (float) 10000*V0)/( (float)5-V0));
		kelvin = (float) (1 / (0.001096 + 0.00024 * Math.log(R2) + (5.87 * Math.pow(10, -8)) * Math.pow(Math.log(R2), 3)));
		celsius = (float) (kelvin - 273.15);
		System.out.println(celsius);
		
		data[0] = V0; data[1] = R2; data[2] = kelvin; data[3] = celsius;
	}
	
	
	public static float getData(String dataType){
		
		switch(dataType){
		
		case "V0":
			return data[0];
		case "R2":
			return data[1];
		case "kelvinIN":
			return data[2];
		case "celsiusIN":
			return data[3];
		case "kelvinOUT":
			return data[2];
		case "celsiusOUT":
			return data[3];
		case "humidity":
			return data[4];
		
		default :
			return 0;
		}
	}
}
