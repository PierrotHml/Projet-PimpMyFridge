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
		frame.update_fridge_temperature(value);
	}
		
	public void update_cooler_temperature(int value)
	{
		frame.update_cooler_temperature(1);
	}
}
