package filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class GrayScale extends Filter{
	public GrayScale() {
		super();
	}
	
	public GrayScale(File f) {
		super(f);
	}
	
	public GrayScale(BufferedImage img) {
		super(img);
	}
	
	public void process() {
		this.imageF = new BufferedImage(this.imageI.getWidth(), 
				this.imageI.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		for(int i = 0; i < this.imageF.getWidth(); i++) {
			for(int j = 0; j < this.imageF.getHeight(); j++) {
				this.imageF.setRGB(i, j , this.imageI.getRGB(i, j));
			}
		}
	}
	
	public String toString() {
		String s = "This filter changes initial image into gray scale image.";
		return s;
	}
}
