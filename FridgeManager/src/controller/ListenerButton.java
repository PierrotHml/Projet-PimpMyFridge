package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerButton implements ActionListener{

	private boolean state;
	// false = turn off || true = turn on
	
	public ListenerButton(boolean state){
		
		this.state = state;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(state == true)state = false;
		else state = true;	
		
		Controller.manageFridgeState(state);
	}

}
