package filter;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public abstract class Filter {
	protected BufferedImage imageI;
	protected BufferedImage imageF;
	
	public Filter() {
		imageI = null;
		imageF = null;
	}
	
	public Filter(File f) {
		try {
			this.imageI = ImageIO.read(f);
			process();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Filter(BufferedImage img) {
		this.imageI = img;
		process();
	}
	
	public BufferedImage getNewImage() {
		return imageF;
	}
	
	public abstract void process();
	
	public abstract String toString();
	
}
