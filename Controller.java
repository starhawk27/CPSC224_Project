//package project5;

import java.util.Random;

public class Controller {
	
	private Board b1 = new Board();
	private char mark = ' ';
	private int turn, x, y, computer, win, lost, tie = 0;
	private int [] preferredMoves = {4,0,2,6,8,1,3,5,7};
	public static Controller instance;
	
	
	public Controller() 
	{
		reset();
	}
	
	public static Controller getInstance()
	{
		if(instance == null)
		{
			instance = new Controller();
			return instance;
		}
		return instance;
	}
	
	public void SetComputer(int computer1)
	{
		computer = computer1;
	}
	
	public String toString()
	{
		return b1.toString();
	}
	
	public void reset()
	{
		b1 = new Board();
		mark = ' ';
		turn = 0;
		x = 0;
		y = 0;
	}
	
	public boolean hasWon()
	{
			if(b1.getCellAtPosition(0, 0) != ' ' && b1.getCellAtPosition(0, 0) == b1.getCellAtPosition(0, 1))
				if(b1.getCellAtPosition(0, 1) == b1.getCellAtPosition(0, 2))
				{
					x = 0;
					y = 0;
					return true;
				}
			if(b1.getCellAtPosition(0, 0) != ' ' && b1.getCellAtPosition(0, 0) == b1.getCellAtPosition(1, 0))
				if(b1.getCellAtPosition(1, 0) == b1.getCellAtPosition(2, 0))
				{
					x = 0;
					y = 0;
					return true;
				}
			if(b1.getCellAtPosition(2, 2) != ' ' && b1.getCellAtPosition(2, 2) == b1.getCellAtPosition(2, 1))
				if(b1.getCellAtPosition(2, 1) == b1.getCellAtPosition(2, 0))
				{
					x = 2;
					y = 2;
					return true;
				}
			if(b1.getCellAtPosition(2, 2) != ' ' && b1.getCellAtPosition(2, 2) == b1.getCellAtPosition(1, 2))
				if(b1.getCellAtPosition(1, 2) == b1.getCellAtPosition(0, 2))
				{
					x = 2;
					y = 2;
					return true;
				}
			if(b1.getCellAtPosition(1, 0) != ' ' && b1.getCellAtPosition(1, 0) == b1.getCellAtPosition(1, 1))
				if(b1.getCellAtPosition(1, 1) == b1.getCellAtPosition(1, 2))
				{
					x = 1;
					y = 0;
					return true;
				}
			if(b1.getCellAtPosition(0, 1) != ' ' && b1.getCellAtPosition(0, 1) == b1.getCellAtPosition(1, 1))
				if(b1.getCellAtPosition(1, 1) == b1.getCellAtPosition(2, 1))
				{
					x = 0;
					y = 1;
					return true;
				}
			if(b1.getCellAtPosition(2, 2) != ' ' && b1.getCellAtPosition(2, 2) == b1.getCellAtPosition(1, 1))
				if(b1.getCellAtPosition(1, 1) == b1.getCellAtPosition(0, 0))
				{
					x = 1;
					y = 1;
					return true;
				}
			if(b1.getCellAtPosition(0, 2) != ' ' && b1.getCellAtPosition(0, 2) == b1.getCellAtPosition(1, 1))
				if(b1.getCellAtPosition(1, 1) == b1.getCellAtPosition(2, 0))
				{
					x = 0;
					y = 2;
					return true;
				}
		return false;
	}
	
	public boolean isDraw()
	{
		if (b1.isFull() && !hasWon())
			return true;
		return false;
	}
	
	public char getWinner()
	{
		if(isDraw())
			mark = ' ';
		else
			mark = b1.getCellAtPosition(x, y);
		return mark;
	}
	
	public void setGames(int whoWon)
	{
		if(whoWon == 1)
			win++;
		else if(whoWon == 2)
			lost++;
		else
			tie++;
	}
	
	public int getWins()
	{
		return win;
	}
	
	public int getLoses()
	{
		return lost;
	}
	
	public int getTies()
	{
		return tie;
	}
	
	public int computerMove()
	{
		Random rand = new Random();
		int total = -1;
		if(computer == 2)
		{
			if(turn < 3)
			{
				if(b1.getCellAtPosition(1, 1) == ' ')
					total = 4;
				else
					total = -1;
			}
			else
			{
				total = strategy('O');
				if(total == -1)
					total = strategy('X');
			}
		}
		int x = total/3;
		int y = total - (3*x);
		if(total == -1)
		{
			if(computer == 0 || computer == 2)
			{
				boolean out = false;
				while(!out)
				{
					x = (rand.nextInt(3));
					y = (rand.nextInt(3));
					if (b1.getCellAtPosition(x,y) == ' ')
					{
						b1.setCellAtPosition(x, y, 'O');
						out = true;
					}	
					total = 3*x + y;
				}
			}
			else
			{
				loop:
				for(int i= 0 ; i < 9 ; i++)
				{
					total = preferredMoves[i];
					x = total/3;
					y = total - (3*x);
					if (b1.getCellAtPosition(x,y) == ' ')
					{
						b1.setCellAtPosition(x, y, 'O');
						break loop;
					}
				}
			}
		}
		else
			b1.setCellAtPosition(x, y, 'O');
		turn++;
		return total;
	}
	
	public boolean humanMove(int x, int y)
	{
		if (b1.getCellAtPosition(x,y) != ' ')
			return false;
		else
			b1.setCellAtPosition(x, y, 'X');
		turn++;
		return true;
	}
	
	public int strategy(char comp)
	{
		if(turn>2)
		{
			int x,y,m,n,p = 0;
			//this array is an array with all board movements that the computer
			//looks at to see if there are two X's or O's in a row so that
			//it knows to win or block
			int [][] strategy = {{1,3,4,4,2,6,8,8},{0,2,4,4,7,7,7,7},
					{1,4,5,5,0,6,8,8},{0,4,6,6,5,5,5,5},{0,1,2,3,5,6,7,8},
					{2,4,8,8,3,3,3,3},{3,4,7,7,0,2,8,8},{4,6,8,8,1,1,1,1},
					{4,5,7,7,0,2,6,6}};
			for(int i = 0 ; i < 9 ; i++)
			{
				x = i/3;
				y = i - (3*x);
				if (b1.getCellAtPosition(x, y) == comp)
					for(int j = 0 ; j < 8 ; j++)
					{
						p = strategy[i][j];
						m = p/3;
						n = p - (3*m);
						if(b1.getCellAtPosition(x, y) == b1.getCellAtPosition(m, n))
						{
							for(int k = 0 ; k < 8 ; k++)
							{
								if(k == j) continue;
								p = strategy[i][k];
								m = p/3;
								n = p - (3*m);
								if(b1.setCellAtPosition(m, n, comp))
								{
									if(hasWon())
									{
										p = 3*m + n;
										b1.setCellAtPosition(m, n, ' ');
										return p;
									}
									b1.setCellAtPosition(m, n, ' ');
								}
							}			
						}		
					}
			}
		}
		return -1;
	}
}

