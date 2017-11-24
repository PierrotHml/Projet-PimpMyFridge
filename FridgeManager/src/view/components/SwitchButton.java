package view.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;

import controller.ListenerButton;

public class SwitchButton extends JButton
{
	// Version ID to check if program is up-to-date.
	private static final long serialVersionUID = 1L;
	
	private boolean fridge_power = true;
	
	public SwitchButton()
	{
		this.addActionListener(new ListenerButton(fridge_power));
		setForeground(Color.white);
		setFont(new Font("Calibri", Font.BOLD, 30));
		setCursor(new Cursor(12));
		
		set_on();
	}
	
	public void set_on()
	{
		setText("TURN OFF");
		setBackground(new Color(191, 77, 68));
		fridge_power = true;
	}
	
	public void set_off()
	{
		setText("TURN ON");
		setBackground(new Color(91, 178, 98));
		fridge_power = false;
	}
	
	public void tell_fridge_state(boolean state)
	{
		if (state)
			set_on();
		else
			set_off();
	}
}
