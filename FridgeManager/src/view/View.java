package view;

public class View
{
	Frame frame = null;
	
	public View(String portName)
	{
		this.frame = new Frame(portName);
	}
	
	public void update_fridge_temperature(double value, int time)
	{
		frame.fridge_temperature_panel.update_value(value);
	}
		
	public void update_cooler_temperature(double value, int time)
	{
		frame.cooler_temperature_panel.update_value(value);
	}
	
	public void refresh(){
		
		frame.refreshFrame();
	}
}
