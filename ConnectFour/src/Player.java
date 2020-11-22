
import java.util.Scanner;



public class Player {
	private String name;
	private char chip;
	private int num_of_player;
	
	
	
	public Player() {
		name = "";
		
		chip =' ';
		
		
		
	}
	public Player(int n) {
		num_of_player = n;
        name = "";
		chip =' ';
		
	}
	
	public String getName() {
		return name;
	}
	
	public char getChip() {
		return chip;}
	
	
	
	Scanner in = new Scanner(System.in);
	
	
	
	public void readNameFromKeyboard() {
	 if(num_of_player == 1)
		System.out.println("This is Score4");
		
		
		System.out.println("Please enter the name of the "+num_of_player+"st player:");
		name = in.nextLine();
		
		
		
		
		}
	
	
	
	
	public void chooseChipFromKeyBoard(char previousChip) {
		
			while(num_of_player == 1 ) {
			
			System.out.println(name+", please select your chip (x/o):");
			chip = in.next().charAt(0);
			chip = Character.toLowerCase(chip);
			
			if(chip == 'x' || chip == 'o') break;
			
			
		} 
		if(num_of_player == 2) {
			
			if(previousChip == 'x') {System.out.println(name+", your chip is: o");
			chip = 'o';
			
			}
			
			else {System.out.println(name+", your chip is: x");
			chip = 'x';
					}
			
		
	  }
	 
		    
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	}
