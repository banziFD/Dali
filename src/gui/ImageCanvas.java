package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImageCanvas extends JPanel{
	private BufferedImage img;
	
	public ImageCanvas (BufferedImage img) {
		this.img = img;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) {
			g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
		}
	}
	
	
}
