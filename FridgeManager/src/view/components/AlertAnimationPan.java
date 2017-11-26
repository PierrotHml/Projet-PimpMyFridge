package view.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AlertAnimationPan extends JPanel{

	private static final long serialVersionUID = 1L;
	private int i = 100;
	private int a = 0;
	private int b = 0;
	
	public AlertAnimationPan(){
		
		
	}
	
	protected void setI(int i){
		
		this.i = i;
	}
	
	public void paintComponent(Graphics g){
		
		g.setColor(new Color(104, 135, 140));
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setColor(new Color(255, 255, 255));
		g.fillRect(40, 0, getWidth()-75, getHeight());
		
		g.setColor(new Color(30,30,30));
		
		if(i >= 0 && i <= 12){
			g.fillOval(getWidth()/2 -10*i, getHeight()/2-5-i, 10+i, 10+i);
			g.fillOval(getWidth()/2 +10*i, getHeight()/2-5-i, 10+i, 10+i);
			a =0;
			b = i;
		}
		else if(i >= 12 && i <= 20){
			
			a++;
			g.fillOval(getWidth()-50-10*a, getHeight()/2- 5 -b +a, b+10-a, b+10-a);
			g.fillOval(50+10*a, getHeight()/2-5 -b +a, b+10-a, b+10-a);
		}

	}
}
