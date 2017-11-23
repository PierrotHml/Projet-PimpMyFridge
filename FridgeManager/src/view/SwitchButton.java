package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class SwitchButton extends JButton implements MouseListener
{
	// Version ID to check if program is up-to-date.
	private static final long serialVersionUID = 1L;
	
	private boolean fridge_power;
	
	public SwitchButton()
	{
		addMouseListener(this);
		
		set_on();
	}
	
	public void set_on()
	{
		setText("Éteindre le frigo");
		
		fridge_power = true;
	}
	
	public void set_off()
	{
		setText("Allumer le frigo");
		
		fridge_power = false;
	}
	
	public void tell_fridge_state(boolean state)
	{
		if (state)
			set_on();
		else
			set_off();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (fridge_power)
		{
			set_off();
		
			// ANTONIO
		}
		else
		{
			set_on();
			
			// ANTONIO
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{}

	@Override
	public void mouseExited(MouseEvent e)
	{}

	@Override
	public void mousePressed(MouseEvent e)
	{}

	@Override
	public void mouseReleased(MouseEvent e)
	{}
}
