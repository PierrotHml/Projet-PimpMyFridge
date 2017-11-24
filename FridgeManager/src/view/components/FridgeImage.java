package view.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FridgeImage extends JPanel
{
	private static final long serialVersionUID = 1L;

	private Image fridgeON;
	private Image fridgeOFF;
	private static boolean state = true;
	
	public FridgeImage()
	{
		try {
			fridgeON = ImageIO.read(new File("res/fridgeON.png"));
			fridgeOFF = ImageIO.read(new File("res/fridgeOFF.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setState(boolean arg){
		state = arg;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		g.setColor(new Color(104, 135, 140));
		g.fillRect(0, 0, getWidth(), getHeight());
		if(state)g.drawImage(fridgeON, (int) ((getWidth() - getHeight() * (4.0/5.0) * (3.0/5.0)) / 2.0), (int) ((getHeight() - getHeight() * (4.0/5.0)) / 2.0), (int) (getHeight() * (4.0/5.0) * (3.0/5.0)), (int) (getHeight() * (4.0/5.0)), this);
		else g.drawImage(fridgeOFF, (int) ((getWidth() - getHeight() * (4.0/5.0) * (3.0/5.0)) / 2.0), (int) ((getHeight() - getHeight() * (4.0/5.0)) / 2.0), (int) (getHeight() * (4.0/5.0) * (3.0/5.0)), (int) (getHeight() * (4.0/5.0)), this);
	}
}
