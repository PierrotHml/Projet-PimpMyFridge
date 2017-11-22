package view;

import javax.swing.JSlider;

public class TemperatureSlider extends JSlider
{
	private static final long serialVersionUID = 1L;

	public TemperatureSlider()
	{
		super(JSlider.VERTICAL, 0, 30, 18);
		
	    setPaintTicks(true);
	    setPaintLabels(true);
	    setMinorTickSpacing(1);
        setMajorTickSpacing(4);
	}
}
