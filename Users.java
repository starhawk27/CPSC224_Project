import javax.swing.JOptionPane;

public class Users {

	private String name;
	public Users(){
		
	}
	
	public void setUser(){
   	 name = JOptionPane.showInputDialog(null,
   			 "What is your name?", "");
   			 //JOptionPane.INFORMATION_MESSAGE;
   	 System.out.println(name + "  selected");
   	 
	}
	
	public String getUser(){
		return name;
	}
	
	/*
	 public static void main(String[] args) {
	
		Users test1 = new Users();
		test1.setUser();
		System.out.println(test1.getUser());
	}
   */
	
	

}
