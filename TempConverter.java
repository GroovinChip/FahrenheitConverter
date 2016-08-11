import java.awt.Frame;

import javax.swing.JFrame;

public class TempConverter 
{
	public static void main(String[] args) 
	{
		JFrame TempPgm = new JFrame("Temperature Converter");
		TempPgm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanel converter = new MainPanel();
		TempPgm.getContentPane().add(converter);
		
		TempPgm.pack();
		TempPgm.setVisible(true);
		TempPgm.setResizable(false);
	}
}
