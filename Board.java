//package project5;

public class Board {
	
	private char[][] cells = new char[3][3];
	
	public Board()
	{
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++)
				cells[i][j] = ' ';
	}
	
	public boolean isFull()
	{
		int counter = 0;
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++)
				if (cells[i][j] == ' ')
					counter++;
		if (counter == 0)
			return true;
		return false;
	}
	
	public boolean setCellAtPosition(int x, int y, char player)
	{
		if (player == ' ')
			cells[x][y] = player;
		else if (cells[x][y] != ' ')
			return false;
		else 
			cells[x][y] = player;
		return true;
	}
	
	public char getCellAtPosition(int x, int y)
	{
		return cells[x][y];
	}
	
	public String toString()
	{
		String string = "";
		string += "   " + cells[0][0];
		string += "\t|";
		string += ("   " + cells[0][1]);
		string += ("\t|");
		string += ("   " + cells[0][2]);
		string += ("\n--------------------------\n");
		string += ("   " + cells[1][0]);
		string += "\t|";
		string += ("   " + cells[1][1]);
		string += ("\t|");
		string += ("   " + cells[1][2]);
		string += ("\n--------------------------\n");
		string += ("   " + cells[2][0]);
		string += "\t|";
		string += ("   " + cells[2][1]);
		string += ("\t|");
		string += ("   " + cells[2][2] + "\n");
		return string;
	}
}


