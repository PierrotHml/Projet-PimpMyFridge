package view;

import java.awt.Color;
import java.awt.Font;
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
	
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	public AlertsPanel()
	{
		super();
		
		setBackground(new Color(104, 135, 140));
		top_alert.setHorizontalAlignment(JLabel.CENTER);
		bot_alert.setHorizontalAlignment(JLabel.CENTER);
		
		top_alert.setFont(new Font("Calibri", Font.BOLD, 35));
		bot_alert.setFont(new Font("Calibri", Font.BOLD, 55));
		
		top_alert.setForeground(Color.red);
		bot_alert.setForeground(Color.red);
		
		setLayout(new GridLayout(2, 1));
		add(top_alert);
		add(bot_alert);
	}
	
	public void add_door_alert()
	{
		if (map.get("door") == null)
		{
			int index = map.get("condensation") != null ? map.get("condensation") == 1 ? 2 : 1 : 1;
			
			if (index == 1)
			{
				top_alert.setText("DOOR OPEN");
				map.put("door", 1);
			}
			else
			{
				bot_alert.setText("DOOR OPEN");
				map.put("door", 2);
			}
		}
	}
	
	public void add_condensation_alert()
	{
		if (map.get("condensation") == null)
		{
			int index = map.get("door") != null ? map.get("door") == 1 ? 2 : 1 : 1;
			
			if (index == 1)
			{
				top_alert.setText("Alerte: Risque de condensation");
				map.put("door", 1);
			}
			else
			{
				bot_alert.setText("Alerte: Risque de condensation");
				map.put("door", 2);
			}
		}
	}
	
	public void drop_alert(String alert)
	{
		if (map.get(alert) == 1)
		{
			top_alert.setText("");
			map.remove(map.get(alert));
		}
		else if (map.get(alert) == 2)
		{
			bot_alert.setText("");
			map.remove(map.get(alert));
		}
	}
}
