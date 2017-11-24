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

public class FridgePanel extends JPanel{

	Image backgroundSkin;
	
	
	public FridgePanel(){
		
		setBackground(Color.WHITE);
	}
	
	/*public void paintComponent(Graphics g){
		
		try {
			backgroundSkin = ImageIO.read(new File("res/texture.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.drawImage(backgroundSkin, 0, 0, this.getWidth(), this.getHeight(), this);
	}*/
}
