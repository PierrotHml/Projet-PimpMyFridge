package view;

public class View
{
	Frame frame = null;
	
	public View()
	{
		this.frame = new Frame();
	}
	
	public void set_fridge_temperature(double value)
	{
		frame.fridge_temperature_panel.setValue(value);
	}
	
	public void set_cooler_temperature(double value)
	{
		frame.cooler_temperature_panel.setValue(value);
	}
}
