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
		
		frame.fridge_temperature_graph.add_value(value, time);
	}
		
	public void update_fridge_humidity(double value, int time)
	{
		frame.fridge_humidity_panel.update_value(value);
		
		frame.fridge_humidity_graph.add_value(value, time);
	}
	
	public void refresh(){
		
		frame.refreshFrame();
	}
}
