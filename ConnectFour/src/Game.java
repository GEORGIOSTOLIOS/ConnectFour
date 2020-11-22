import java.util.Scanner;
import java.util.Random;

public class Game {
	
	private Player pl1;
	private Player pl2;
	private DashBoard d;
	
	
	
	
	
	
	
	
	public Game () {
		
		
		pl1 = new Player(1);
		pl2 = new Player(2);
		d = new DashBoard();
		
		
		
		
		
	}
	
	
	Scanner in = new Scanner(System.in);
	
	public void initializeTheGame()
	{   
		pl1.readNameFromKeyboard();
		pl2.readNameFromKeyboard();
		pl1.chooseChipFromKeyBoard('n');
		pl2.chooseChipFromKeyBoard(pl1.getChip());
		d.readSizeOfDashBoard();
		d.printGapDashboard();
	}
	
	public void playAndPrintTheResult() {
		
		Scanner in = new Scanner(System.in);
		
		int num_of_choices = 0;
		
		int turn =  whoPlaysFirst();
		//while no draw
		while(num_of_choices <= d.getRows()* d.getColumns()) {
		
		if(turn == 1) {
			
			System.out.println("");
			
			System.out.println(pl1.getName()+", your turn. Select column:");
			
			int column = in.nextInt();
			
			while(!isValidChoice(column-1)) {
				System.out.println(pl1.getName()+", your turn. Select column:");
				 
				column = in.nextInt();
			}
			
			d.updateTheDashboard(column-1,pl1.getChip());
			num_of_choices ++;
			
			if(isThereAWinner(d.getRowOfChip(),column-1, pl1.getChip())) {
				
				d.printTheDashboard();
				
				System.out.println("THE WINNER IS "+pl1.getName());
				
				break;}
			
		
			//Give the turn to the player2
			turn = 2;
			
			d.printTheDashboard();
			
			
			
		}
		else {
			
			System.out.println("");
			
			System.out.println(pl2.getName()+", your turn. Select column:");
			
			int column = in.nextInt();
			
			while(!isValidChoice(column-1)) {
				System.out.println(pl2.getName()+", your turn. Select column:");
				
				column = in.nextInt();
			}
			
			d.updateTheDashboard(column-1,pl2.getChip());
			num_of_choices ++;
			
			if(isThereAWinner(d.getRowOfChip(),column-1, pl2.getChip())) {
				
				d.printTheDashboard();
				
				System.out.println("THE WINNER IS "+pl2.getName());
				
				break;}
			
			//Give the turn to the player1
			turn = 1;
			
			d.printTheDashboard();
			
			
			
			
		}
		
		
		}
		if(num_of_choices == d.getRows()*d.getColumns()) {
			System.out.println("WE HAVE DRAW");
		}
		in.close();
	}
	
	
	public boolean isThereAWinner(int row, int column, char chip) {
		
		//Go down and check if someone won
		if(row + 3 < d.getRows()) {
			
			
			if( d.getAChipFromArray(row+1, column).charAt(1) == chip &&d.getAChipFromArray(row+2,column).charAt(1) == chip && 
					d.getAChipFromArray(row+3,column).charAt(1) == chip) {
				return true;
			}
			
		
			
		}
		//Go right and check if someone won
		if(column + 3 < d.getColumns()) {
		
			if(d.getAChipFromArray(row,column +1).charAt(1) == chip && d.getAChipFromArray(row,column+2).charAt(1) == chip && 
					d.getAChipFromArray(row,column+3).charAt(1) == chip) {
				
				return true;
			}
		}
		//Go left and check if someone won
		if(column -3 >=0) {
			
			
			if( d.getAChipFromArray(row,column-1).charAt(1) == chip && d.getAChipFromArray(row, column-2).charAt(1) == chip && 
					d.getAChipFromArray(row,column-3).charAt(1) == chip) {
				
				return true;
				
				
			}
			
			
		}
		//Do one step left and two steps right to check if someone won
		if(column - 1 >= 0 && column + 2 < d.getColumns()) {
			
			if(  d.getAChipFromArray(row, column-1).charAt(1) == chip &&  d.getAChipFromArray(row, column+1).charAt(1) == chip && 
				d.getAChipFromArray(row, column+2).charAt(1) == chip) {
				
				return true;
			}
		}
		
		//Do one step right and two steps left to check if someone won
         if(column - 2 >= 0 && column + 1 < d.getColumns()) {
			
			if(  d.getAChipFromArray(row, column-1).charAt(1) == chip &&  d.getAChipFromArray(row, column-2).charAt(1) == chip && 
				 d.getAChipFromArray(row, column+1).charAt(1) == chip) {
				
				return true;
			}
		}
		
		
		//Go down and right and check if someone won
		if(row + 3 < d.getRows() && column+3 <d.getColumns() ) {
			if( d.getAChipFromArray(row+1, column+1).charAt(1) == chip && d.getAChipFromArray(row+2,column+2).charAt(1) == chip && 
				d.getAChipFromArray(row+3, column+3).charAt(1) == chip 	) {
				
				return true;
			}
		}
		
		//Go down and left and check if someone won
		if(row + 3 < d.getRows() && column -3 >=0) {
			
			if(  d.getAChipFromArray(row+1, column-1).charAt(1) == chip && d.getAChipFromArray(row+2, column -2).charAt(1) == chip && 
				 d.getAChipFromArray(row+3, column-3).charAt(1) == chip) {
				
				return true;
			}
		}
		
		//Do one step down and left and two steps up and right to check if someone won
		if(row + 1 < d.getRows() && column - 1 >=0 && row - 2 >=0 && column +2 < d.getColumns()) {
			
			if( d.getAChipFromArray(row+1, column-1).charAt(1) == chip && d.getAChipFromArray(row-1, column+1).charAt(1) == chip && 
				d.getAChipFromArray(row-2, column+2).charAt(1) == chip){
				
				return true;
				
			}
			
		}
		
		//Do two steps down and left and one step up and right to check if someone won
		if(row + 2 < d.getRows() && column -2 >=0 && row -1 >= 0 && column + 1 < d.getColumns()) {
			
			if(  d.getAChipFromArray(row+1, column-1).charAt(1) == chip &&  d.getAChipFromArray(row+2, column-2).charAt(1) == chip && 
				d.getAChipFromArray(row-1, column+1).charAt(1) == chip) {
				
				return true;
			}
		}
		
		
		//Go up and left and check if someone won
		if(row - 3>=0 && column - 3 >=0) {
			 
			if(  d.getAChipFromArray(row-1, column-1).charAt(1) == chip && d.getAChipFromArray(row-2, column-2).charAt(1) == chip && 
				d.getAChipFromArray(row-3, column-3).charAt(1) == chip) {
				return true;
			}
		}
		
		//Go up and right and check if someone won
		if(row - 3>=0 && column + 3 < d.getColumns() ){
			
			if(  d.getAChipFromArray(row-1, column+1).charAt(1) == chip && d.getAChipFromArray(row-2, column+2).charAt(1) == chip && 
				 d.getAChipFromArray(row-3, column+3).charAt(1) == chip) {
				return true;
			}
			
		}
		
		//Do one step up  and left and two steps down and right to check if someone won
		if(row - 1 >= 0 && column- 1 >= 0 && row + 2 < d.getRows() && column + 2 <d.getColumns()) {
			
			if( d.getAChipFromArray(row-1,column-1).charAt(1) == chip && d.getAChipFromArray(row+1,column+1).charAt(1) == chip && 
					d.getAChipFromArray(row+2,column+2).charAt(1) == chip) {
				
				return true;
			} }
			
		//Do two steps up  and left and one step down and right to check if someone won
		if(row - 2>= 0 && column - 2 >=0 && row + 1 < d.getRows() && column + 1 <d.getColumns() ) {
				
			if(d.getAChipFromArray(row-1,column-1).charAt(1) == chip && d.getAChipFromArray(row-2,column-2).charAt(1) == chip && 
					d.getAChipFromArray(row+1,column+1).charAt(1) == chip) {
					
					return true;
				}
			 }
		
		
		
		return false;
	}
	
	
	
	
	
	
	public boolean isValidChoice(int c) {
		
		
		if(c >= 0 && c < d.getColumns()  ) {
			
			     if(d.getAChipFromArray(0, c) == " - " )
			     {  
			    	 return true;
			     }
			
			
			
		}
		
		System.out.println("The choice is not valid");
		return false;
		  
	}
	
	
	
	public int whoPlaysFirst() {
		
		
		Random rand = new Random();
		
		int answer = rand.nextInt(3) +1;
		
		return answer;
		
	}
	
	
	
	
	
	
	

	
	
	

}
