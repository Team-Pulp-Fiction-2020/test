//2474073K Francesca Kennedy

import java.util.Random;							//for Question 4 - to allow random numbers to be generated

public class ConnectFour {

	public static void main(String[] args) {
					
	RandomConnectFour();							//Returns RandomConnectFour method from Q4 below.
		
	//	Test 1 - Question 1 Part C
	
	/*	Player p1 = new Player("Clive", 'x');
		Counter c = new Counter(p1);
		System.out.println(c.getPlayer().toString() + ", " + c.toString());
	*/	
		
	//	Test 2 - Question 2 Part C 
	
	/*	Player p1 = new Player("Clive", 'x');
		Counter c = new Counter(p1);
		Column col = new Column(4);
		for(int i=0;i<5;i++) {
			boolean result = col.add(new Counter(p1));
			System.out.println(result);
		}
	*/
		
	//	Test 3 - Question 2 Part E
	
	/*	Column col = new Column(6);
		Player p1 = new Player("Clive",'o');
		Player p2 = new Player("Sharon",'x'); {
		for(int i=0;i<3;i++) {
		col.add(new Counter(p1));
		col.add(new Counter(p2));
		}
		col.display();
		}	
	*/
	
	//	Test 4 - Question 3 Part D
	
	/*	Board board = new Board(6,7);
		Player p1 = new Player("Clive",'o');
		Player p2 = new Player("Sharon",'x');
		board.add(new Counter(p2),6);
		board.add(new Counter(p1),3);
		board.add(new Counter(p2),4);
		board.add(new Counter(p1),4);
		board.add(new Counter(p2),5);
		board.add(new Counter(p1),5);
		board.add(new Counter(p2),6);
		board.add(new Counter(p1),5);
		board.add(new Counter(p2),6);
		board.add(new Counter(p1),6);
		board.toString();						//	This line was added to the test to display the board
	*/
					
	}

	// Question 4
	public static void RandomConnectFour() {
		
		int rows = 6;								//define rows variable
		int columns = 7;							//define columns variable
		Board board = new Board(rows, columns);		//define board array
		Random random = new Random();				//defines random variable
		Player p1 = new Player("Clive",'o');		//player 1 defined
		Player p2 = new Player("Sharon",'x');		//player 2 defined
		Player Currentplayer = p1;					//'CurrentPlayer' is an interchangeable player variable set as p1 at first
		
		while (board.isFull() == false) {											//runs loop until board is full using isFull method in Board class
			int RandomColumnDrop = random.nextInt(columns);							//defines a random column to drop the next counter into	
			if (board.add(new Counter(Currentplayer), RandomColumnDrop) == true) {
				/*
					Line 70 runs add method in Board class, dropping current 'Currentplayer' counter into the random column 
					defined in previous line.  If the drop the column isn't yet full, the counter is placed into the
					column, and the if/else statement in lines 79-83 redefines 'Currentplayer' to be the other player.
					If the column is full, the loop continues but doesn't change player so they don't miss a turn.
				*/ 					
				
				if (Currentplayer == p1) {					//	...if the 'add' is successful, and Currentplayer is p1 
					Currentplayer = p2;						//	...Currentplayer becomes p2
				}
				else {										//	...or else
					Currentplayer = p1;						//	...Currentplayer becomes p1
				}
			}
		}
		
		board.toString(); 									//	Once method 'isFull' is true the board is displayed.
		System.out.println(board.whoWon() + " has won");	//	Added for Question 5 to display the winner.
	}
	
}