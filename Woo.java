import java.util.Scanner;

public class Woo{

    //contains the FIELD of TERRAIN tiles
    public static Terrain[][] field;
    public static Unit[][] units;
    public static Scanner input = new Scanner(System.in);
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  
    
    //main
    public static void main(String[] args){

	field = new Terrain[20][50];

	String choice = "";
	while( choice.equals("")){
	    clear();
	    menu();
	    choice = input.nextLine();
	    if (choice.equals("1")){ start(); break;}
	    if (choice.equals("2")){ manual(); choice = "";}
	    else{choice = "";}
	}

	while(true){
	    runTurn();
	}


	
    }

    //intializes a new random field and some new random units
    public static void start(){
	
	//generate a random field
	for( int x = 0; x < field.length; x++){
	    for( int y = 0; y < field[0].length; y++){
		int randchoice = (int)(Math.random()*2); //<== INSERT number of choices
		if ( randchoice == 0)
		    field[x][y] = new Land();
		if ( randchoice == 1)
		    field[x][y] = new Sea();
		//if (randchoice == 2)
	    }
	}
    }

    public static void manual(){
	clear();
	System.out.println("MANUAL\nEnter anything to advance the pages.");
	System.out.println("Welcome to AdjacentSeats's Historical Military Simulator.");
	System.out.println("\nThis is the instruction manual for our program. If you need to view it at any time during the game, just use the INFO command.");
	System.out.println("\nBasics:\nThis is a historically-themed wargame; If you've ever played Risk, Diplomacy, Advanced Squad Leader, or any of the Avalon Hill boardgames, you already have an idea of how this works.");
	System.out.println("\nThe game is played on the army-fleet scale; you and your opponent are generals of opposing sides. You must play at the same computer. The objective is to destroy the enemy completely!");
	System.out.println("\nStructure:\nWhen you and a friend play, you will take turns sending orders to the battlefield. The orders come in the form of simple commands. Examples are given below:\n\nA7 NORTH\nD4 STRIKE NORTH\nINFO");
	System.out.println("Page 1");
	//END ONE FULL 24-line PAGE
	input.nextLine();
	clear();
	System.out.println("\nSpecifics:\nHow to specify a particular unit: By letter and number. First comes the letter, which specifies ROW. (A-Z). Then comes number, which specifies column (0-80). All numbers are written vertically due to space issues.\nFor example, the number 54 would be written above its respective column like this:\n5\n4");
	System.out.println("Page 2");

	System.out.println("END MANUAL, <ENTER> to exit.");
	input.nextLine();

    }

    public static void runTurn(){
	printField();
	System.out.print("What is your command?\t");
	playerParser( input.nextLine() );
	
    }

    public static void menu(){
	System.out.println("-=. AS Historical Military Simulations .=-");
	System.out.println("Pick one: \n 1.Play Random\n 2.Manual");
    }

    public static void playerParser(String com){
	if(com.length() == 0){
	    return;}

    }

    public static void printField(){
	String toPrint = " ";
	for(int x = 0; x < field[0].length;x++){
	    toPrint += (int)(x / 10);
	}
	toPrint += "\n ";
	for(int x = 0; x < field[0].length;x++){
	    toPrint += (x % 10);
	}
	toPrint += "\n";

	for(int x = 0; x < field.length; x++){
	    toPrint += alphabet.substring(x,x+1);
	    for(int y = 0; y < field[0].length;y++){
		toPrint += field[x][y].getSymbol();
	    }
	    toPrint += "\n";
	}
	System.out.println(toPrint);
    }

    public static void clear(){
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

}
