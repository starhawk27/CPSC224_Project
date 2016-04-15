//package project5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	private JPanel p = new JPanel();
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JRadioButton response1 = new JRadioButton(" Easy ",true);
	private JRadioButton response2 = new JRadioButton(" Medium ",false);
	private JRadioButton response3 = new JRadioButton(" Hard ",false);
	private ButtonGroup group = new ButtonGroup();
	private XOButton buttons[] = new XOButton[9];
	private Controller g1 = new Controller();
	private JButton reset = new JButton("Reset");
	private JTextField win = new JTextField();
	private JTextField lost = new JTextField();
	private JTextField tie = new JTextField();
	private Font font = new Font("Courier", Font.BOLD,19);
	
	
	public MainFrame() {
		//Makes the window
		super("TicTacToe");
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//creates the main JPanel
		p1.setLayout(new BorderLayout(0,0));
		setContentPane(p1);
		
		//creates the JPanel with the top buttons
		p1.add(p2, BorderLayout.NORTH );
		//p2.setBackground(new Color(117,37,111));
		//adds the buttons to the panel
		win.setText(" Wins: " + g1.getWins() + " ");
		lost.setText(" Loses: " + g1.getLoses() + " ");
		tie.setText(" Ties: " + g1.getTies() + " ");
		win.setBackground(new Color(0,0,0));
		win.setFont(font);
		win.setForeground(new Color(255,255,255));
		lost.setBackground(new Color(0,0,0));
		lost.setFont(font);
		lost.setForeground(new Color(255,255,255));
		tie.setBackground(new Color(0,0,0));
		tie.setFont(font);
		tie.setForeground(new Color(255,255,255));
		win.setEnabled(false);
		lost.setEnabled(false);
		tie.setEnabled(false);
		p2.add(win);
		p2.add(lost);
		p2.add(tie);
		reset.setEnabled(true);
		reset.addActionListener(this); 
		reset.setBackground(new Color(0,0,0));
		reset.setFont(font);
		reset.setForeground(new Color(255,0,0));
		p2.add(reset);
		response1.setBackground(new Color(0,0,0));
		response1.setFont(font);
		response1.setForeground(new Color(255,255,255));
		response2.setBackground(new Color(0,0,0));
		response2.setFont(font);
		response2.setForeground(new Color(255,255,255));
		response3.setBackground(new Color(0,0,0));
		response3.setFont(font);
		response3.setForeground(new Color(255,255,255));
		p2.add(response1);
		p2.add(response2);
		p2.add(response3);
		group.add(response1);
		group.add(response2);
		group.add(response3);
		
		response1.addItemListener(new HandlerClass(0));
		response2.addItemListener(new HandlerClass(1));
		response3.addItemListener(new HandlerClass(2));
		
		//creates the JPanel with the grid on it
		p.setLayout(new GridLayout(3,3));
		p1.add(p, BorderLayout.CENTER);
		//adds the buttons to the grid
		for(int i = 0 ; i < 9 ; i++)
		{
			buttons[i] = new XOButton();
			p.add(buttons[i]);
			buttons[i].setEnabled(true);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(new Color(0,0,0));
		}
		add(p);
		setVisible(true);
	}
	
	private class HandlerClass implements ItemListener{
		private int x = 0;
		
		public HandlerClass(int computer)
		{
			x = computer;
		}

		public void itemStateChanged(ItemEvent e) {
			g1.SetComputer(x);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(reset == e.getSource())
		{
			for(int i = 0 ; i < 9 ; i++)
			{
				buttons[i].setPicture('N');
				buttons[i].setEnabled(true);
			}
			if(!g1.hasWon() && !g1.isDraw())
			{
				g1.setGames(2);
				lost.setText(" Loses: " + g1.getLoses() + " ");
			}
			g1.reset();
		}
		loop:
		for (int i = 0 ; i < 9 ; i++)
		{
			if(buttons[i] == e.getSource())
			{
				int x = i/3;
				int y = i - (3*x);
				if(!g1.humanMove(x, y))
					return;
				buttons[i].setPicture('x');
				if(g1.isDraw() || g1.hasWon())
				{
					winner();
					break loop;
				}
				int comp = g1.computerMove();
				buttons[comp].setPicture('o');
				if(g1.isDraw() || g1.hasWon())
				{
					winner();
					break loop;
				}		
			}
		
		}
	}
	
	public void winner()
	{
		if(g1.getWinner() == 'X')
		{
			g1.setGames(1);
			win.setText(" Wins: " + g1.getWins() + " ");
			JOptionPane.showMessageDialog(p,"You Won!");
		}
		else if(g1.getWinner() == 'O')
		{
			g1.setGames(2);
			lost.setText(" Loses: " + g1.getLoses() + " ");
			JOptionPane.showMessageDialog(p,"The Computer Won.");
		}
		else if(g1.isDraw())
		{
			g1.setGames(3);
			tie.setText(" Ties: " + g1.getTies() + " ");
			JOptionPane.showMessageDialog(p,"It's a tie!");
		}
		for(int i = 0 ; i < 9 ; i++)
			buttons[i].setEnabled(false);
	}
	
	/*public void music(URL audio)
	{
		try{
			AudioInputStream audioin = AudioSystem.getAudioInputStream(audio);
			Clip clip = AudioSystem.getClip();
			clip.open(audioin);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(UnsupportedAudioFileException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(LineUnavailableException e){
			e.printStackTrace();
		}
	}
	*/
	private void setComponetNames(){
		response1.setName("button1");
		response2.setName("button2");
		response3.setName("button3");
		
		for(int i = 0 ; i < 9 ; i++)
		{
			buttons[i].setName("buttons" + Integer.toString(i));
			
		}
	}
	public static void main(String[] args)
	{
		new MainFrame();	
	}
}
