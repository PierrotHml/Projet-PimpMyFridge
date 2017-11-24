package view;

import view.components.FridgeImage;

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
		frame.animation();
		refresh();
	}
		
	public void update_fridge_humidity(double value, int time)
	{
		frame.fridge_humidity_panel.update_value(value);
		
		frame.fridge_humidity_graph.add_value(value, time);
	}
	
	public void tell_frdige_state(boolean state) // ANTONIO
	{
		frame.fridge_switch_button.tell_fridge_state(state);
		FridgeImage.setState(state);
	}
	
	public void swapFridgePicture(boolean arg){
		
		FridgeImage.setState(arg);
	}
	
	public void tell_opened_door_alert(boolean open)
	{
		if (open) 
			frame.fridge_alerts_panel.add_door_alert();
		else
			frame.fridge_alerts_panel.drop_alert("door");
	}
	
	public void tell_condensation_risk_alert(boolean risk)
	{
		if (risk) 
			frame.fridge_alerts_panel.add_door_alert();
		else
			frame.fridge_alerts_panel.drop_alert("condensation");
	}
	
	public void refresh(){
		
		frame.refreshFrame();
	}
}
