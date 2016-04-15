import static org.junit.Assert.*;

import org.junit.Test;

public class TestUsers {
	private javax.swing.JTextField inputTextField;
	@Test
	public void test() {

		Users testcase = new Users();
		testcase.setUser();
		
		String expectedOutput = "test";
		String actualOutput = testcase.getUser();
		
		if (!expectedOutput.equals(actualOutput))
		{fail();
			
		}

	}
	private void setcomponets(){
		inputTextField.setName("text");
				
	}
	private void inputTextFieldActionPreformed(Java.awt.event.ActionEvent evt){
		inputTextField.setText(inputTextField.getText());
	}
}
