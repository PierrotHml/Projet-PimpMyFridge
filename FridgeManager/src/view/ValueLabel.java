package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class ValueLabel extends JPanel
{	
	// Version ID to check if the class is up-to-date.
	private static final long serialVersionUID = 1L;
	private static Image backgroundSkin;
	protected static DecimalFormat decimal_format = new DecimalFormat("0.00");
	protected boolean sendable;
	protected String valueType;
	protected JLabel label = null;
	
	public ValueLabel(double value, boolean sendable, String valueType)
	{
		this.sendable = sendable;
		this.valueType = valueType;
		
		label = new JLabel();
		label.setHorizontalAlignment(JLabel.CENTER);
		
		if(valueType.equals("HUMIDITY"))label.setText(decimal_format.format(value) + "%");
		else label.setText(decimal_format.format(value) + "°C");
		
		if(sendable)label.setFont(new Font("Calibri", Font.BOLD, 40));
		else label.setFont(new Font("Calibri", Font.BOLD, 25));
		label.setLocation((int) (getWidth() / 2.0 - label.getWidth() / 2.0), (int) (getHeight() / 2.0 - label.getHeight() / 2.0));
		
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		
	}
	
	public void update_value(double value)
	{	
		if(valueType.equals("HUMIDITY"))label.setText(decimal_format.format(value) + "%");
		else label.setText(decimal_format.format(value) + "°C");
		
		if (sendable == true)
		{
			Controller.updateOrder((int)value);
		}
	}
	
	public void paintComponent(Graphics g){
		
		try {
			if(valueType.equals("HUMIDITY"))backgroundSkin = ImageIO.read(new File("res/jpanelbottom.png"));
			else if(valueType.equals("TEMPERATURE")) backgroundSkin = ImageIO.read(new File("res/jpaneltop.png"));
			else backgroundSkin = ImageIO.read(new File("res/jpanelcenter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.drawImage(backgroundSkin, 0, 0, this.getWidth(), this.getHeight(), this);
		
	}
}
