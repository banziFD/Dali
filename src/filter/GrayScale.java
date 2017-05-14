package filter;

import java.awt.image.BufferedImage;
import java.io.File;

public class GrayScale extends Filter{
	public GrayScale() {
		super();
	}
	
	public GrayScale(File f) {
		super(f);
	}
	
	public void process() {
		this.imageF = new BufferedImage(this.imageI.getWidth(), 
				this.imageI.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
		for(int i = 0; i < this.imageF.getWidth(); i++) {
			for(int j = 0; j < this.imageF.getHeight(); j++) {
				int rgb = this.imageI.getRGB(i, j);
				this.imageF.setRGB(i, j , rgb);
			}
		}
	}
	
	public String toString() {
		String s = "This filter changes initial image into gray scale image.";
		return s;
	}
}
