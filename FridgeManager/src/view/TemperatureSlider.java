package view;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TemperatureSlider extends JSlider
{
	private static final long serialVersionUID = 1L;

	ValueLabel linked_temperature;
	
	public TemperatureSlider(ValueLabel linked_temperature)
	{	
		super(JSlider.VERTICAL, 0, 30, 18);
		
		this.linked_temperature = linked_temperature;
		linked_temperature.update_value(18);
		
	    setPaintTicks(true);
	    setPaintLabels(true);
	    setMinorTickSpacing(1);
        setMajorTickSpacing(5);
        
        addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent event)
            {
            	linked_temperature.update_value((double) ((TemperatureSlider) event.getSource()).getValue());
            }
        });
	}
}
