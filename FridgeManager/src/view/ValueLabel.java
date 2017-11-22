package view;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ValueLabel extends JPanel
{	
	// Version ID to check if the class is up-to-date.
	private static final long serialVersionUID = 1L;

	protected static DecimalFormat decimal_format = new DecimalFormat("0.00");
	protected JLabel label = null;
	
	public ValueLabel(double value)
	{
		label = new JLabel();
		label.setText(decimal_format.format(value));
		label.setSize(new Dimension(24, 20));
		label.setLocation((int) (getWidth() / 2.0 - label.getWidth() / 2.0), (int) (getHeight() / 2.0 - label.getHeight() / 2.0));
		
		setLayout(null);
		
		add(label);
	}
	
	public void update_value(double value)
	{	
		label.setText(decimal_format.format(value));
	}
	
	@Override
	public void setSize(Dimension dimension)
	{
		super.setSize(dimension);

		label.setLocation((int) (getWidth() / 2.0 - label.getWidth() / 2.0), (int) (getHeight() / 2.0 - label.getHeight() / 2.0));
	}
}
