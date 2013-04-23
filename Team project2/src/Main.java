import java.awt.Dimension;

import javax.swing.JFrame;
import java.sql.*;

public class Main
{

	public static void main(String[] args) throws SQLException
	{
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1024, 768));
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}
