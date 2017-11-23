package view;

public class View
{
	Frame frame = null;
	
	public View(String portName)
	{
		this.frame = new Frame(portName);
	}
	
	public void update_fridge_temperature(double value)
	{
		frame.fridge_temperature_panel.update_value(value);
	}
		
	public void update_cooler_temperature(double value)
	{
		frame.cooler_temperature_panel.update_value(value);
	}
	
	public void refresh(){
		
		frame.refreshFrame();
	}
}
