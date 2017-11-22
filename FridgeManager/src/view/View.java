package view;

public class View
{
	Frame frame = null;
	
	public View()
	{
		this.frame = new Frame();
	}
	
	public void update_fridge_temperature(int value)
	{
		frame.fridge_temperature_panel.update_value(value);
	}
		
	public void update_cooler_temperature(int value)
	{
		frame.cooler_temperature_panel.update_value(value);
	}
}
