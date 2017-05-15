package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import filter.Negative;
import filter.Blur;
import filter.Denoising;
import filter.Emboss;
import filter.GrayScale;
import filter.Original;
import java.io.File;

public class Dali extends JFrame{
	public static void main(String[] args) throws Exception{
		new Dali();
	}
	
	private BufferedImage imageI;
	private BufferedImage imageF;;
	
	public Dali() {
		super("Dali-- Your image rerouching assistant!");
		this.setSize(800, 600);
		
		this.setLayout(new GridLayout(0, 2, 30, 30));
		Container containerImageI = getContentPane();
		Container containerImageF = getContentPane();

		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("file");
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (imageI == null) {
					JFileChooser fileChooser = new JFileChooser();
					while (true) {
						fileChooser.showOpenDialog(null);
						File inputFile = fileChooser.getSelectedFile();
						if(inputFile.getName().endsWith(".jpg")) {
							try {
								Original img = new Original(inputFile);
								imageI = img.getNewImage();
								containerImageI.add(new ImageCanvas(img.getNewImage()), null);
								containerImageF.validate();
								
							} catch (Exception e) {
								System.out.println(e);
							}
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Please select a jpg file!");
						}
					}
				} else {
					System.out.println("You already have loaded image");
				}
				
				
			}
		});
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				JFileChooser fileChooser = new JFileChooser();
				while (true) {
					fileChooser.showOpenDialog(null);
					File outputFile = fileChooser.getSelectedFile();
					try {
						ImageIO.write(imageF, "jpg", outputFile);
						break;
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		});
		file.add(open);
		file.add(save);
		
		JMenu edit = new JMenu("edit");
		JMenuItem emboss = new JMenuItem("emboss");
		emboss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(imageI != null) {
					Emboss eb = new Emboss(imageI);
					imageF = eb.getNewImage();
					Component[] pre = containerImageF.getComponents();
					if (pre.length == 1) {
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					} else {
						containerImageF.remove(1);
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					}
				} else {
					System.out.println("No initial image!");
				}
				
			}
		});
		JMenuItem grayScale = new JMenuItem("grayScale");
		grayScale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(imageI != null) {
					GrayScale gs = new GrayScale(imageI);
					imageF = gs.getNewImage();
					Component[] pre = containerImageF.getComponents();
					if (pre.length == 1) {
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					} else {
						containerImageF.remove(1);
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					}
				} else {
					System.out.println("No initial image!");
				}
			}
		});
		JMenuItem negative = new JMenuItem("negative");
		negative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(imageI != null) {
					Negative ng = new Negative(imageI);
					imageF = ng.getNewImage();
					Component[] pre = containerImageF.getComponents();
					if(pre.length == 1) {
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					} else {
						containerImageF.remove(1);
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					}
				} else {
					System.out.println("No initial image!");
				}
			}
		});
		JMenuItem blur = new JMenuItem("blur");
		blur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(imageI != null) {
					Blur bl = new Blur(imageI);
					imageF = bl.getNewImage();
					Component[] pre = containerImageF.getComponents();
					if(pre.length == 1) {
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					} else {
						containerImageF.remove(1);
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					}
				}
			}
		});
		JMenuItem denoising = new JMenuItem("denoising");
		denoising.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(imageI != null) {
					Denoising dn = new Denoising(imageI);
					imageF = dn.getNewImage();
					Component[] pre = containerImageF.getComponents();
					if(pre.length == 1) {
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					} else {
						containerImageF.remove(1);
						containerImageF.add(new ImageCanvas(imageF), null);
						containerImageF.validate();
					}
				}
			}
		});
		edit.add(emboss);
		edit.add(grayScale);
		edit.add(negative);
		edit.add(blur);
		edit.add(denoising);
		menuBar.add(file);
		menuBar.add(edit);
		
		this.setJMenuBar(menuBar);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}
