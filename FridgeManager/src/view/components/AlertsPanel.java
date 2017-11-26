package view.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlertsPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private JLabel top_alert = new JLabel();
	private JLabel bot_alert = new JLabel();
	private AlertAnimationPan anim = new AlertAnimationPan();
	private Color off = new Color(200,200,200);
	private Font customAlert = new Font("Arial", Font.BOLD, 20);
	
	public AlertsPanel()
	{
		super();
		
		top_alert.setHorizontalAlignment(JLabel.CENTER);
		bot_alert.setHorizontalAlignment(JLabel.CENTER);
		
		top_alert.setFont(customAlert);
		bot_alert.setFont(customAlert);
		
		top_alert.setForeground(off);
		bot_alert.setForeground(off);
		
		top_alert.setText("PORTE OUVERTE");
		bot_alert.setText("RISQUE DE CONDENSATION");
		
		JLabel title = new JLabel("---------   ALERTE   ---------");
		title.setFont(new Font("Arial", Font.BOLD, 25));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		setLayout(new GridLayout(4, 1));
		add(title);
		add(top_alert);
		add(bot_alert);
		add(anim);
		
	}
	
	public void add_door_alert()
	{
		top_alert.setForeground(new Color(191, 77, 68));
	}
	
	public void add_condensation_alert()
	{
		bot_alert.setForeground(new Color(191, 77, 68));
	}
	
	public void drop_alert(String alert)
	{
		if(alert.equals("condensation"))bot_alert.setForeground(off);
		else top_alert.setForeground(off);
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(new Color(104, 135, 140));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(new Color(255, 255, 255));
		g.fillRect(40, 0, getWidth()-75, getHeight());
	}
	
	public void setAnimationState(int i){
		
		anim.setI(i);
	}
}
