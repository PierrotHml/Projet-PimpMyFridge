package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class SwitchButton extends JButton implements MouseListener
{
	// Version ID to check if program is up-to-date.
	private static final long serialVersionUID = 1L;
	
	public SwitchButton()
	{
		addMouseListener(this);
	}
	
	public void tell_on()
	{
		setText("Éteindre l'arduino");
	}
	
	public void tell_off()
	{
		setText("Allumer l'arduino");
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		
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
