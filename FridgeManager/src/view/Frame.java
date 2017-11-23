package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame
{
	// Version ID to check if the GUI is up-to-date.
	private static final long serialVersionUID = 1L;
	
	//icon
	Image icone = Toolkit.getDefaultToolkit().getImage("res/fridgeIcon.png");

	// Content sizer
	private JPanel content_sizer = new JPanel();
	
	// Main sizers
	private JPanel measures_sizer = new JPanel();
	private JPanel fridge_sizer = new JPanel();
	private JPanel graphs_sizer = new JPanel();
	private JPanel setpoint_slider_sizer = new JPanel();
	private ValuesPanel values_sizer = new ValuesPanel();
	private JPanel fridge_image_sizer = new JPanel();
	private JPanel state_sizer = new JPanel();
	private JPanel alerts_sizer = new JPanel();
	private JPanel switch_sizer = new JPanel();
	
	// Value panels
	ValueLabel setpoint_temperature_panel = null;
	ValueLabel fridge_temperature_panel = null;
	ValueLabel fridge_humidity_panel = null;
	
	// Setpoint value slider
	TemperatureSlider setpoint_slider = null;
	
	// Fridge image
	FridgeImage fridge_image;
	
	// Fridge switch button
	SwitchButton fridge_switch_button;
	
	// Graphs
	ValueGraph fridge_temperature_graph;
	ValueGraph cooler_temperature_graph;
	ValueGraph fridge_humidity_graph;
	
	public Frame(String portName)
	{
		// Configuring the application frame.
		setIconImage(icone);
		setTitle("Fridge Manager [" + portName + "]");
		setSize(1280, 720);
		setResizable(false);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    // Initializing main sizers.
	    
	    measures_sizer.setPreferredSize(new Dimension((int) (getWidth() * (3.0/10.0)), getHeight()));

	    fridge_sizer.setPreferredSize(new Dimension((int) (getWidth() * (3.0/10.0)), getHeight()));

	    graphs_sizer.setPreferredSize(new Dimension((int) (getWidth() * (2.0/5.0)), getHeight()));

	    // Building measure sizers.
	    setpoint_slider_sizer.setBackground(new Color(30,30,30));
	    setpoint_slider_sizer.setPreferredSize(new Dimension((int) (measures_sizer.getPreferredSize().getWidth() * (1.0/4.0)), (int) measures_sizer.getPreferredSize().getHeight()));
	    
	    values_sizer.setPreferredSize(new Dimension((int) (measures_sizer.getPreferredSize().getWidth() * (3.0/4.0)), (int) measures_sizer.getPreferredSize().getHeight()));
	    
	    // Building fridge sizers.
	    fridge_image_sizer.setPreferredSize(new Dimension((int) fridge_sizer.getPreferredSize().getWidth(), (int) (fridge_sizer.getPreferredSize().getHeight() * (3.0/5.0))));
	    
	    state_sizer.setPreferredSize(new Dimension((int) fridge_sizer.getPreferredSize().getWidth(), (int) (fridge_sizer.getPreferredSize().getHeight() * (2.0/5.0))));
	    
	    // Building value panels.
	    setpoint_temperature_panel = new ValueLabel(15, true, "CONSIGNE");
	    setpoint_temperature_panel.setSize(new Dimension((int) (values_sizer.getPreferredSize().getWidth() * (2.0/3.0)), (int) (values_sizer.getPreferredSize().getWidth() * (2.0/3.0))));
	    setpoint_temperature_panel.setLocation((int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0) - setpoint_temperature_panel.getWidth() / 2.0), (int) (values_sizer.getPreferredSize().getHeight() * (1.0/2.0) - 18 - setpoint_temperature_panel.getHeight() / 2.0));
	    
	    fridge_temperature_panel = new ValueLabel(0, false, "TEMPERATURE");
	    fridge_temperature_panel.setSize(new Dimension((int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0)), (int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0))));
	    fridge_temperature_panel.setLocation((int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0) - fridge_temperature_panel.getWidth() / 2.0), (int) (values_sizer.getPreferredSize().getHeight() * (1.0/4.0) - 36 - fridge_temperature_panel.getHeight() / 2.0));
	    
	    fridge_humidity_panel = new ValueLabel(0, false, "HUMIDITY");
	    fridge_humidity_panel.setSize(new Dimension((int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0)), (int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0))));
	    fridge_humidity_panel.setLocation((int) (values_sizer.getPreferredSize().getWidth() * (1.0/2.0) - fridge_humidity_panel.getWidth() / 2.0), (int) (values_sizer.getPreferredSize().getHeight() * (3.0/4.0) - fridge_humidity_panel.getHeight() / 2.0));
	    
	    // Building slider panel.
	    setpoint_slider = new TemperatureSlider(setpoint_temperature_panel, measures_sizer.getPreferredSize().getWidth());
	    
	    // Building firdge image.
	    fridge_image = new FridgeImage();
	    //fridge_image.setSize(new Dimension((int) (fridge_image_sizer.getPreferredSize().getHeight() * (4.0/5.0) * (3.0/5.0)), (int) (fridge_image_sizer.getHeight() * (4.0/5.0))));
	    //fridge_image.setLocation((int) (fridge_image_sizer.getPreferredSize().getWidth() / 2.0 - fridge_image.getWidth() / 2.0), (int) (fridge_image_sizer.getPreferredSize().getHeight() / 2.0 - fridge_image.getHeight() / 2.0));
	    
	    // Building state sizers.
	    alerts_sizer.setPreferredSize(new Dimension((int) state_sizer.getPreferredSize().getWidth(), (int) (state_sizer.getPreferredSize().getHeight() * (3.0/5.0))));
	    
	    switch_sizer.setPreferredSize(new Dimension((int) state_sizer.getPreferredSize().getWidth(), (int) (state_sizer.getPreferredSize().getHeight() * (2.0/5.0))));
	    
	    // Building switch button.
	    fridge_switch_button = new SwitchButton();
	    fridge_switch_button.setSize(new Dimension((int) (switch_sizer.getPreferredSize().getWidth() * (4.0/5.0)), (int) (switch_sizer.getPreferredSize().getHeight() * (3.0/4.0))));
	    fridge_switch_button.setLocation((int) (switch_sizer.getPreferredSize().getWidth() / 2.0 - fridge_switch_button.getWidth() / 2.0), (int) (switch_sizer.getPreferredSize().getHeight() / 2.0 - fridge_switch_button.getHeight() / 2.0));
	    
	    // Building graphs.
	    fridge_temperature_graph = new ValueGraph(ValueGraph.get_fridge_temperature_chart());
	    fridge_temperature_graph.setPreferredSize(new Dimension((int) (graphs_sizer.getPreferredSize().getWidth()), (int) (graphs_sizer.getPreferredSize().getHeight() / 2.0 - 16)));
	    
	    fridge_humidity_graph = new ValueGraph(ValueGraph.get_fridge_humidity_chart());
	    fridge_humidity_graph.setPreferredSize(new Dimension((int) (graphs_sizer.getPreferredSize().getWidth()), (int) (graphs_sizer.getPreferredSize().getHeight() / 2.0 - 16)));
	    
	    // Creating main sizers grid to respect propotions.
	    content_sizer.setLayout(new BorderLayout());
	    content_sizer.add(measures_sizer, BorderLayout.WEST);    
	    content_sizer.add(fridge_sizer, BorderLayout.CENTER);
	    content_sizer.add(graphs_sizer, BorderLayout.EAST);
	    
	    measures_sizer.setLayout(new BorderLayout());
	    measures_sizer.add(values_sizer, BorderLayout.CENTER);
	    measures_sizer.add(setpoint_slider_sizer, BorderLayout.EAST);
	    
	    fridge_sizer.setLayout(new BorderLayout());
	    fridge_sizer.add(fridge_image_sizer, BorderLayout.CENTER);
	    fridge_sizer.add(state_sizer, BorderLayout.SOUTH);
	    
	    graphs_sizer.setLayout(new BorderLayout());
	    graphs_sizer.add(fridge_temperature_graph, BorderLayout.NORTH);
	    graphs_sizer.add(fridge_humidity_graph, BorderLayout.SOUTH);
	    
	    values_sizer.setLayout(null);
	    values_sizer.add(setpoint_temperature_panel);
	    values_sizer.add(fridge_temperature_panel);
	    values_sizer.add(fridge_humidity_panel);
	    
	    setpoint_slider_sizer.setLayout(null);
	    setpoint_slider_sizer.add(setpoint_slider);
	    
	    fridge_image_sizer.setLayout(new BorderLayout());
	    fridge_image_sizer.add(fridge_image, BorderLayout.CENTER);
	    
	    state_sizer.setLayout(new BorderLayout());
	    state_sizer.add(alerts_sizer, BorderLayout.NORTH);
	    state_sizer.add(switch_sizer, BorderLayout.SOUTH);
	    
	    alerts_sizer.setLayout(new GridLayout(1, 2));
	    
	    switch_sizer.setLayout(null);
	    switch_sizer.add(fridge_switch_button);
	    
	    // Creating fridge manager content tree.
	    setContentPane(content_sizer);
	    setVisible(true);
	}
	
	
	public void refreshFrame(){
		
		this.revalidate();
		this.repaint();
	}
	
	public void animation(){
		
		Thread animation = new Thread(){
			public void run(){
				for(int i = 1; i <= 100; i+=5){
					values_sizer.setI(i);
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		animation.start();
		
	}
}
