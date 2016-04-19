package gameHub;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

public class Mainmenu {
	static JButton button2 = new JButton();
	static JButton button = new JButton();
	static JButton button4 = new JButton();
	static JButton button3 = new JButton();
	static JButton userbutton = new JButton();
	
	public static void main(String s[]) {

		JFrame frame = new JFrame("Game Hub");

		//layout
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(new Color(186, 165, 232));
		
		//title of GUI
		JLabel label = new JLabel("GAME HUB");

		createButton();

		//add all buttons to panel
		panel.add(label);
		panel.add(button);	
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(userbutton);
		
		//set frame
		frame.add(panel);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	private static void createButton() {
		//create button to change user
		userbutton.setText("Change User");
		userbutton.setBackground(new Color(131, 250, 20));
				
		//create button for tic tac toe
		button.setLayout(null);
		button.setText("Tic-Tac-Toe");
		button.setBackground(new Color(131, 250, 20));
		
		//create button for word search
		button2.setText("Word Search");
		button2.setBackground(new Color(131, 250, 20));
		
		//create button for eye spy
		button3.setText("Eye Spy");
		button3.setBackground(new Color(131, 250, 20));
		
		//create button for high scores
		button4.setText("High Scores");
		button4.setBackground(new Color(131, 250, 20));
	}
}