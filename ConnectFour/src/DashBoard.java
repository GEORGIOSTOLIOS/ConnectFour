import java.util.Scanner;

public class DashBoard {
	
	private int rows;
	private int columns;
	private String [][] Array;
	private int rowOfChip;
	
	
	public DashBoard() {
		Array = new String [15][15];
		rows = 0;
		columns = 0;
		
	}
	
public void updateTheDashboard(int col,char ch) {
		
		int i =1;
		while(Array[i][col] == " - " && i < rows ) {
			
			i++;
			
			if(i == rows) {break;}
			
		}
		
		rowOfChip = i-1;
		
		Array[i-1][col] =" "+ String.valueOf(ch) + " "; 
	}
	
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns(){
		return columns;
	}
	
	public int getRowOfChip() {
		return rowOfChip;
	}
	public String getAChipFromArray(int r,int c) {
		
		return Array[r][c];
	}
	
	public void printTheDashboard() {
		for(int i = 0; i< rows; i++) {
			System.out.print(" | ");
			
			for(int j =0; j < columns; j++) {
				System.out.print(Array[i][j]);
				
			}
			System.out.println(" | ");
		}
		
		
		for(int i = 0;  i< 3*rows; i++) {
			System.out.print(  "--");
		}
		System.out.println("");
		
		System.out.print("    ");
		
		
		for(int j = 0; j < columns; j++) {
			
			System.out.print((j+1) +"  ");
		}
	}
	
	
	
	Scanner in = new Scanner(System.in);
	public void printGapDashboard()
	{  
		
		
		initializeTheArray();
		
		for(int i = 0; i< rows; i++) {
			
			System.out.print(" | ");
			
			for(int j =0; j < columns; j++) {
				System.out.print(Array[i][j]);
				
			}
			System.out.println(" | ");
		}
		
		for(int i = 0;  i<3* rows; i++) {
			System.out.print(  "--");
		}
		System.out.println("");
		System.out.print("    ");
		
		for(int j = 0; j <columns; j++) {
			System.out.print((j+1) +"  ");
		}
		
	
		
	}
	
public void readSizeOfDashBoard() {
	
		
		System.out.println("Please enter the number of rows:");
		rows = in.nextInt();
		
		while(rows < 4  || rows > 15) {
			
			System.out.println("Please enter the number of rows:");
			
			rows = in.nextInt();
			
		}
		
		System.out.println("Please enter the number of columns:");
		
		columns = in.nextInt();
		
		while(columns < 4  || columns> 15) {
			
			System.out.println("Please enter the number of columns:");
			
			columns = in.nextInt();
			
			in.close();
			
		}
		
		
	}
	
	
	
	public void initializeTheArray() {
		
		for(int i = 0; i< rows; i++) {
			
			for(int j =0; j < columns; j++) {
				
				Array[i][j] = " - ";
			}
		}
	}

}
