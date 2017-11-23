package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ValuesPanel extends JPanel{

	Image backgroundSkin;
	
	public ValuesPanel(){
		
	}
	
	public void paintComponent(Graphics g){
		
		try {
			backgroundSkin = ImageIO.read(new File("res/texture.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		g.drawImage(backgroundSkin, 0, 0, this.getWidth(), this.getHeight(), this);
		
	}
}
