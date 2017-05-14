package filter;

import java.io.File;

public class PoorContrast extends Filter{
	private GrayScale g;
	
	public PoorContrast() {
		super();
	}
	
	public PoorContrast(File f) {
		super(f);
		this.g = new GrayScale(f);
		this.imageF = g.getNewImage();
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
