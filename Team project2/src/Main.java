import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;


public class Main {


	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1600, 800));
		frame.pack();
		frame.setVisible(true);
	}
}
