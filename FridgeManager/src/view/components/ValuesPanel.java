package view.components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ValuesPanel extends JPanel{

	Image backgroundSkin;
	private int a;
	private int b;
	private int circleHeight = 5;
	private Color circle =new Color(104, 135, 140);
	private Color circle2 =new Color(104, 135, 140);
	
	
	public void paintComponent(Graphics g1){
		
		b = a - circleHeight - 20;
		
		try {
			backgroundSkin = ImageIO.read(new File("res/texture.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Graphics2D g = (Graphics2D) g1;
		BasicStroke line = new BasicStroke(circleHeight);
		g.setStroke(line);
		g.setColor(circle);
		
		g.drawImage(backgroundSkin, 0, 0, this.getWidth(), this.getHeight(), this);
	
		g.drawOval(197-(a+circleHeight)/2,196-(a+circleHeight)/2,a+circleHeight,a+circleHeight);
		g.setColor(circle2);
		g.drawOval(197-(b+circleHeight)/2,196-(b+circleHeight)/2,b+circleHeight,b+circleHeight);

		g.setColor(circle);
		g.drawOval(197-(a+circleHeight)/2,487-(a+circleHeight)/2,a+circleHeight,a+circleHeight);
		g.setColor(circle2);
		g.drawOval(197-(b+circleHeight)/2,487-(b+circleHeight)/2,b+circleHeight,b+circleHeight);

		
		
	}
	
	public void setI(int i) {
		this.a = i;
	}
}
