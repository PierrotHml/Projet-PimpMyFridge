package view;

public class View
{
	Frame frame = null;
	
	
	
	public View()
	{
		this.frame = new Frame();
	}
	
	public void update_view()
	{
		frame.update_fridge_temperature(1);
		
		frame.update_cooler_temperature(1);
	}
}
