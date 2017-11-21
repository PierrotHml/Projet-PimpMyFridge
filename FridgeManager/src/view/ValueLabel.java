package view;

import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ValueLabel extends JPanel
{	
	// Version ID to check if the class is up-to-date.
	private static final long serialVersionUID = 1L;

	protected static DecimalFormat decimal_format = new DecimalFormat("0.##");
	protected JLabel label = null;
	
	public ValueLabel(double value)
	{
		label = new JLabel();
		label.setText(decimal_format.format(value));
		
		add(label);
	}
	
	public void update_value(double value)
	{
		label.setText(decimal_format.format(value));
	}
}
