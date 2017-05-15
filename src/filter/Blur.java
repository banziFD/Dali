package filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class Blur extends Filter{
	public Blur() {
		super();
	}
	
	public Blur(File f) {
		super(f);
	}
	
	public Blur(BufferedImage img) {
		super(img);
	}
	@Override
	public void process() {
		// TODO Auto-generated method stub
		this.imageF = new BufferedImage(this.imageI.getWidth(),
				this.imageI.getHeight(), imageI.getType());
		for(int i = 5; i < this.imageF.getWidth() - 5; i++) {
			for(int j = 5; j < this.imageF.getHeight() - 5; j++) {
				int r = 0;
				int g = 0;
				int b = 0;
				for(int m = i - 5; m < i + 6; m++) {
					for(int n = j - 5; n < j + 6; n++) {
						Color current = new Color(this.imageI.getRGB(m, n));
						r += current.getRed();
						g += current.getGreen();
						b += current.getBlue();
					}
				}
				r /= 121;
				g /= 121;
				b /= 121;
				this.imageF.setRGB(i, j, new Color(r, g, b).getRGB());
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "This is Blur filter.";
		return s;
	}

}
