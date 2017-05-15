package filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class Emboss extends Filter{
	public Emboss() {
		super();
	}
	
	public Emboss(File f) {
		super(f);
	}
	
	public Emboss(BufferedImage img) {
		super(img);
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		this.imageF = new BufferedImage(this.imageI.getWidth(),
				this.imageI.getHeight(), imageI.getType());
		for(int i = 1; i < this.imageF.getWidth() - 1; i++) {
			for(int j = 1; j < this.imageF.getHeight() - 1; j++) {
				Color c1 = new Color(this.imageI.getRGB(i + 1, j + 1));
				Color c2 = new Color(this.imageI.getRGB(i - 1,  j - 1));
				int r = c1.getRed() - c2.getRed() + 128;
				r = r < 256 ? r : 255;
				r = r > -1 ? r : 0;
				int g = c1.getGreen() - c2.getGreen() + 128;
				g = g < 256 ? g : 255;
				g = g > -1 ? g : 0;
				int b = c1.getBlue() - c2.getBlue() + 128;
				b = b < 256 ? b : 255;
				b = b > -1 ? b : 0;
				this.imageF.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "This is Emboss filter.";
		return s;
	}
}
