package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FridgeImage extends JPanel
{
	private static final long serialVersionUID = 1L;

	private Image fridge;
	
	public FridgeImage()
	{
		try {
			fridge = ImageIO.read(new File("res/fridge.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		g.drawImage(fridge, (int) ((getWidth() - getHeight() * (4.0/5.0) * (3.0/5.0)) / 2.0), (int) ((getHeight() - getHeight() * (4.0/5.0)) / 2.0), (int) (getHeight() * (4.0/5.0) * (3.0/5.0)), (int) (getHeight() * (4.0/5.0)), this);
	}
}
