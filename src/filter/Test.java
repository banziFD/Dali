package filter;

import java.io.File;
import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) {
		File f = new File("e://test/3.jpg");
		Negative g = new Negative(f);
		String path = f.getPath();
		path = path.replaceAll("3.jpg", "2.jpg");
		File f_ = new File(path);
		try {
			ImageIO.write(g.getNewImage(), "jpg", f_);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
