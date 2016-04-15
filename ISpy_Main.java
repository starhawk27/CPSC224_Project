
/*@author: Dominic Soares
 *@version 1.0
 *@since   3/30/16
 *Class: CPSC 224-02
 *Description: This is the frame for ISpy
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ISpy_Main extends JFrame implements ActionListener {
	
	Image level1;
	JFrame main = new JFrame();
	JLabel label_1 = new JLabel();
	
	public static void main(String[] args) throws IOException {
		new ISpy_Main();
	}

	public ISpy_Main() throws IOException {
		Time.doTime();
		
		main.setLayout(null);
		main.setBounds(0, 0, 1366, 885);
		
		
		JLabel label = new JLabel();
		label.addMouseListener(new MouseEvent());

		ImageIcon icon = new ImageIcon("C:/Users/soare/java/workspace/ISpy/src/level2_s.jpg");		
		label.setIcon(icon);
		label.setBounds(0, 0, 1366, 768);
		label.setBorder(BorderFactory.createLineBorder(Color.black));

		
		
		ImageIcon icon_1 = new ImageIcon("C:/Users/soare/java/workspace/ISpy/src/level1_1.jpg");
		label_1.setIcon(icon_1);
		label_1.setBounds(0, 769, 400, 74);
				

	    main.add(label_1);
		main.add(label);

		main.setVisible(true);
	}
			
	
	public void addblabel() {
		JLabel label_x1 = new JLabel();
		ImageIcon icon_x1 = new ImageIcon("C:/Users/soare/java/workspace/ISpy/src/x.jpg");
		label_x1.setIcon(icon_x1);
		label_x1.setBounds(90, 2, 20, 20);
		label_1.add(label_x1);
	}	
	
	public void addrlabel() {
		JLabel label_x1 = new JLabel();
		ImageIcon icon_x1 = new ImageIcon("C:/Users/soare/java/workspace/ISpy/src/x.jpg");
		label_x1.setIcon(icon_x1);
		label_x1.setBounds(90, 30, 20, 20);
		label_1.add(label_x1);
	}
	
	public void addflabel() {
		JLabel label_x1 = new JLabel();
		ImageIcon icon_x1 = new ImageIcon("C:/Users/soare/java/workspace/ISpy/src/x.jpg");
		label_x1.setIcon(icon_x1);
		label_x1.setBounds(90, 53, 20, 20);
		label_1.add(label_x1);
	}
	
	public void addglabel() {
		JLabel label_x1 = new JLabel();
		ImageIcon icon_x1 = new ImageIcon("C:/Users/soare/java/workspace/ISpy/src/x.jpg");
		label_x1.setIcon(icon_x1);
		label_x1.setBounds(255, 2, 20, 20);
		label_1.add(label_x1);
	}
	
	public void addhlabel() {
		JLabel label_x1 = new JLabel();
		ImageIcon icon_x1 = new ImageIcon("C:/Users/soare/java/workspace/ISpy/src/x.jpg");
		label_x1.setIcon(icon_x1);
		label_x1.setBounds(255, 30, 20, 20);
		label_1.add(label_x1);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void closeFrame(){
		main.dispatchEvent(new WindowEvent(main, WindowEvent.WINDOW_CLOSING));
	}

	public static class Time{
		int time_t = 0;
		static int time = 300;
		static Timer timer = new Timer();
		private static int flag = 0;
		
		public static void doTime(){
		time = 300;
		flag++;

		if(flag < 1){
				timer.scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						time--;
						System.out.println(time);
					}
				}, 1000, 1000);
			}
		}
		
		public static void cancel(){
			//timer.cancel();
			System.out.println("time is stopped");
			score.calcScore();
			score.PrintScore();
			score.passScore();
		}
		
		public static void next(){
			
		}
	}
	
	public static class score{
		static int score = 0;
		static int miss = 0;
		
		public static void miss_score(){
			miss++;
		}
		
		public static void calcScore(){
			score = (Time.time*5)-(miss*10);
		}

		public static void PrintScore() {
			System.out.println("score is");
			System.out.println(score);
		}
		
		public static void passScore(){
			endofgame a = new endofgame();
			a.endOfGameWindow(score, "Dom");
		}
	}
	
	
	public class MouseEvent implements MouseListener {
		private int flag1;
		private int flag2;
		private int flag3;
		private int flag4;
		private int flag5;
		
		@Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {

			
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			System.out.println(x);
			System.out.println(y);
			System.out.println("");
			
			if(x > 320 & x < 410 & y > 310 & y < 525){
				System.out.println("Barista");
				addblabel();
				flag1 += 1;
			}
			
			else if(x > 945 & x < 990 & y > 345 & y < 400){
				System.out.println("Rooster");
				addrlabel();
				flag2 += 1;
			}
			
			else if(x > 435 & x < 500 & y > 160 & y < 235){
				System.out.println("Fan");
				addflabel();
				flag3 += 1;
			}
			
			else if(x > 20 & x < 100 & y > 530 & y < 625){
				System.out.println("KitKat");
				addglabel();
				flag4 += 1;
			}
			
			else if(x > 670 & x < 762 & y > 556 & y < 626){
				System.out.println("Cup Sleeve");
				addhlabel();
				flag5 += 1;
			}
			
			else{
				System.out.println("miss");
				score.miss_score();				
			}
			
			if((flag1 > 0) & (flag2 > 0) & (flag3 > 0) & (flag4 > 0) & (flag5 > 0)){
				System.out.println("Next Level");
				closeFrame();
				try {
					ISpy_Main2.main(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		
			main.revalidate();
			main.repaint();
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}

