package filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class Negative extends Filter{
	public Negative() {
		super();
	}
	
	public Negative(File f) {
		super(f);
	}
	
	public Negative(BufferedImage img) {
		super(img);
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		 System.out.println(this.imageI.getType());
		this.imageF = new BufferedImage(this.imageI.getWidth(),
				this.imageI.getHeight(), imageI.getType());
		for (int i = 1; i < this.imageF.getWidth() - 1; i++) {
			for(int j = 1; j < this.imageF.getHeight() - 1; j++) {
				Color c = new Color(this.imageI.getRGB(i, j));
				int r = 255 - c.getRed();
				int g = 255 - c.getGreen();
				int b = 255 - c.getGreen();
				this.imageF.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "This is Negative filter.";
		return s;
	}
}
