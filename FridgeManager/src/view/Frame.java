package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	// Version ID to check if the GUI is up-to-date.
	private static final long serialVersionUID = 1L;

	// Content sizer
	private JPanel content_sizer = null;
	
	// Main sizers
	private JPanel measures_sizer = null;
	private JPanel fridge_sizer = null;
	private JPanel graphs_sizer = null;
	
	private JPanel values_sizer = null;
	
	// Value panels
	ValueLabel fridge_temperature_panel = null;
	ValueLabel cooler_temperature_panel = null;
	
	public Frame()
	{
		// Configuring the application frame.
		setTitle("Fridge Manager");
		setSize(1280, 720);
		setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    
	    // Initializing main sizers.
	    content_sizer = new JPanel();
	    
	    measures_sizer = new JPanel();
	    measures_sizer.setPreferredSize(new Dimension((int) (getWidth() * (3.0/10.0)), getHeight()));

	    fridge_sizer = new JPanel();
	    fridge_sizer.setPreferredSize(new Dimension((int) (getWidth() * (3.0/10.0)), getHeight()));

	    graphs_sizer = new JPanel();
	    graphs_sizer.setPreferredSize(new Dimension((int) (getWidth() * (2.0/5.0)), getHeight()));

	    // Initializing measure sizers.
	    values_sizer = new JPanel();
	    values_sizer.setBackground(Color.GRAY);
	    values_sizer.setPreferredSize(new Dimension((int) (measures_sizer.getPreferredSize().getWidth() * (3.0/4.0)), (int) measures_sizer.getPreferredSize().getHeight()));
	    
	    // Initializing value panels.
	    fridge_temperature_panel = new ValueLabel(0); //TODO
	    fridge_temperature_panel.setSize(new Dimension(50,50));
	    fridge_temperature_panel.setLocation((int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0) - fridge_temperature_panel.getWidth() / 2), (int) (values_sizer.getPreferredSize().getHeight() * (1.0/4.0) - fridge_temperature_panel.getHeight() / 2));
	    
	    cooler_temperature_panel = new ValueLabel(0); //TODO
	    cooler_temperature_panel.setSize(new Dimension(50,50));
	    cooler_temperature_panel.setLocation((int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0) - cooler_temperature_panel.getWidth() / 2), (int) (values_sizer.getPreferredSize().getHeight() * (3.0/4.0) - cooler_temperature_panel.getHeight() / 2));
	    
	    // TEMP
	    JPanel setpoint_strip = new JPanel();
	    setpoint_strip.setPreferredSize(new Dimension((int) (measures_sizer.getPreferredSize().getWidth() * (1.0/4.0)), (int) measures_sizer.getPreferredSize().getHeight()));
	    
	    // Creating main sizers grid to respect propotions.
	    content_sizer.setLayout(new BorderLayout());
	    content_sizer.add(measures_sizer, BorderLayout.WEST);    
	    content_sizer.add(fridge_sizer, BorderLayout.CENTER);
	    content_sizer.add(graphs_sizer, BorderLayout.EAST);
	    
	    measures_sizer.setLayout(new BorderLayout());
	    measures_sizer.add(values_sizer, BorderLayout.CENTER);
	    measures_sizer.add(setpoint_strip, BorderLayout.EAST);
	    
	    values_sizer.setLayout(null);
	    values_sizer.add(fridge_temperature_panel);
	    values_sizer.add(cooler_temperature_panel);
	    
	    // Creating fridge manager content tree.
	    setContentPane(content_sizer);
        
	    setVisible(true);
	}
}
