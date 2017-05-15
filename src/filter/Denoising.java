package filter;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

public class Denoising extends Filter{
	public Denoising() {
		super();
	}
	
	public Denoising(File f) {
		super(f);
	}
	
	public Denoising(BufferedImage img) {
		super(img);
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		int s = 20;
		double sigma = 1000;
		this.imageF = new BufferedImage(this.imageI.getWidth(), 
				this.imageI.getHeight(), this.imageI.getType());
		int[][] r = new int[this.imageF.getWidth()][this.imageF.getHeight()];
		int[][] g = new int[this.imageF.getWidth()][this.imageF.getHeight()];
		int[][] b = new int[this.imageF.getWidth()][this.imageF.getHeight()];
		for(int i = 0; i < this.imageF.getWidth(); i++) {
			for(int j = 0; j < this.imageF.getHeight(); j++) {
				Color current = new Color(this.imageI.getRGB(i, j));
				r[i][j] = current.getRed();
				g[i][j] = current.getGreen();
				b[i][j] = current.getBlue();
			}
		}
		for(int i = s; i < this.imageF.getWidth() - s; i++) {
			for(int j = s; j < this.imageF.getHeight() - s; j++) {
			    double mR = 0;
				double vR = 0;
				double mG = 0;
				double vG = 0;
				double mB = 0;
				double vB = 0;
				for(int m = -s; m < s + 1; m++) {
					for(int n = -s ; n < s + 1; n++) {
						mR += r[i + m][j + n];
						mG += g[i + m][j + n];
						mB += b[i + m][j + n];
					}
				}
				mR = mR / (2 * s + 1) / (2 * s + 1);
				mG = mG / (2 * s + 1) / (2 * s + 1);
				mB = mB / (2 * s + 1) / (2 * s + 1);
				for(int m = -s; m < s + 1; m++) {
					for(int n = -s ; n < s + 1; n++) {
						vR += (r[i + m][j + n] - mR) * (r[i + m][j + n] - mR);
						vG += (g[i + m][j + n] - mG) * (g[i + m][j + n] - mG);
						vB += (b[i + m][j + n] - mB) * (b[i + m][j + n] - mB);
					}
				}
				vR = vR / (2 * s + 1) / (2 * s + 1);;
				vG = vG / (2 * s + 1) / (2 * s + 1);;
				vB = vB / (2 * s + 1) / (2 * s + 1);;
				
				double kR = vR / (vR + sigma);
				double tR = (1 - kR) * mR + kR * r[i][j];
				double kG = vG / (vG + sigma);
				double tG = (1 - kG) * mG + kG * g[i][j];
				double kB = vB / (vB + sigma);
				double tB = (1 - kB) * mB + kB * b[i][j];
				tR = tR < 255 ? tR : 255;
				tG = tG < 255 ? tG : 255;
				tB = tB < 255 ? tB : 255;
				//System.out.println(tR + "x " + tG + "x " + tB);
				this.imageF.setRGB(i, j, new Color((int)tR, (int)tG, (int)tB).getRGB());
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
