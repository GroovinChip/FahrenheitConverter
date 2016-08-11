import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel 
{
	// Declare GUI components
	protected JLabel inputLabel;
	protected JLabel outputLabel; 
	protected JLabel resultLabel;
	protected JLabel lastTempLabel; 
	protected JLabel lastTemp;
	protected JTextField fahrenheit;
	protected JButton clearBtn;
	
	public MainPanel()
	{
		// Define GUI components
		inputLabel = new JLabel("Enter Fahrenheit temperature and press enter");
		outputLabel = new JLabel("Temperature in Celsius: ");
		resultLabel = new JLabel("---");
		lastTempLabel = new JLabel("Last Fahrenheit Temperature Entered: ");
		lastTemp = new JLabel("");
		clearBtn = new JButton("Clear Fields");			
		fahrenheit = new JTextField(5);
		
		// Add ActionListeners 
		fahrenheit.addActionListener(new TempListener());
		clearBtn.addActionListener(new ClearListener());
		
		// Add components
		add(inputLabel);
		add(fahrenheit);
		add(outputLabel);
		add(resultLabel);
		add(lastTempLabel);
		add(lastTemp);
		add(clearBtn);
		
		// Set other GUI attributes
		setPreferredSize(new Dimension(320, 100));
		setBackground(Color.yellow);
	}
	
	// ActionListener for temp calculation
	private class TempListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				// declare variables 
				int fahrenheitTemp; 
				int celsiusTemp;
				String prevTemp; // holds the last entered temp
			
				// get text entered by user and convert to Integer
				String text = fahrenheit.getText();
				fahrenheitTemp = Integer.parseInt(text);
			
				// conversion
				celsiusTemp = (fahrenheitTemp-32) * 5/9;
			
				// show results and clear text field
				resultLabel.setText(Integer.toString(celsiusTemp));
				fahrenheit.setText("");
				prevTemp = String.valueOf(fahrenheitTemp);
				lastTemp.setText(prevTemp);
			}
			// If user does not enter anything or enters non-integer values,
			// display a popup error and clear the field
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Error: Please enter a temperature");
				fahrenheit.setText("");
			}
		}
	}
	
	// ActionListener to clear all fields onscreen
	private class ClearListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			resultLabel.setText("");
			fahrenheit.setText("");
			lastTemp.setText("");
		}
	}
}
