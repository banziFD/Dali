package filter;

import java.awt.image.BufferedImage;
import java.io.File;

public class Original extends Filter{
	public Original() {
		super();
	}
	
	public Original(File f) {
		super(f);
	}
	
	public Original(BufferedImage img) {
		super(img);
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		this.imageF = this.imageI;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "This is original image.";
		return s;
	}
	
	

}
