package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import filter.Negative;
import filter.GrayScale;
import filter.Original;
import java.io.File;

public class Dali extends JFrame{
	public static void main(String[] args) throws Exception{
		new Dali();
	}
	
	public Dali() {
		super("Dali-- Your image rerouching assistant!");
		this.setSize(800, 600);
		
		this.setLayout(new GridLayout(0, 3, 5, 5));
		Container containerImageI = getContentPane();
		Container containerImageF = getContentPane();
		Container containerButton = getContentPane();
		JButton open = new JButton("Open");
		containerButton.add(open, BorderLayout.EAST);
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				while (true) {
					fileChooser.showOpenDialog(null);
					File inputFile = fileChooser.getSelectedFile();
					if(inputFile.getName().endsWith(".jpg")) {
						try {
							Original img = new Original(inputFile);
							containerImageI.add(new ImageCanvas(img.getNewImage()), null);
						} catch (Exception exception) {
							System.out.println(exception);
						}
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Please select a jpg file!");
					}
				}
			}
		});
		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
}
