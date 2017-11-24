package view.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TemperatureSlider extends JSlider
{
	private static final long serialVersionUID = 1L;

	ValueLabel linked_temperature;
	
	public TemperatureSlider(ValueLabel linked_temperature, double widthSlider)
	{	
		super(JSlider.VERTICAL, 0, 30, 15);
		
		this.linked_temperature = linked_temperature;
		//linked_temperature.update_value(18);
		
	    setPaintTicks(true);
	    setPaintLabels(true);
	    setMinorTickSpacing(1);
        setMajorTickSpacing(5);
        setBounds(0,40,(int) (widthSlider * (1.0/4.0)), 600);
        setFont(new Font("Arial", 0, 20));
        setForeground(Color.white);
        setBackground(new Color(30,30,30));
        setBorder(BorderFactory.createMatteBorder(0, 5, 0, 5, Color.black));
        setCursor(new Cursor(8));
        
        addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
            	linked_temperature.update_value((double) ((TemperatureSlider) event.getSource()).getValue());
            }
        });
	}
}
