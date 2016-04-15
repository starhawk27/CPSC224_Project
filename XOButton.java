//package project5;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class XOButton extends JButton {
	ImageIcon X,O;
		
	public XOButton() 
	{
		X = new ImageIcon("C:/jdk1.8.0_66/Homework/Group/src/Ximage.jpg");
		O = new ImageIcon("C:/jdk1.8.0_66/Homework/Group/src/Oimage.jpg");
	}
	
	public void setPicture(char x)
	{
		if (x == 'x')
			setIcon(X);
		else if(x == 'o')
			setIcon(O);
		else
			setIcon(null);
	}
}

