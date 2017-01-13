import java.util.Scanner;

public class Woo{

    //contains the FIELD of TERRAIN tiles
    public static Terrain[][] field;
    public static Unit[][] units;
    public static Scanner input = new Scanner(System.in);
  
    
    //main
    public static void main(String[] args){

	field = new Terrain[20][20];

	String choice = "";
	while( choice.equals("")){
	    clear();
	    menu();
	    choice = input.nextLine();
	    if (choice.equals("1")){ start(); break;}
	    if (choice.equals("2")){ manual(); choice = "";}
	    if (choice.equals("3")){ return;}
	    else{choice = "";}
	}

	printField();
	input.nextLine();
	
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
	System.out.println("MANUAL\nEnter anything to close the manual.");
	System.out.println("Welcome to AdjacentSeats's Historical Military Simulator.");
	System.out.println("\nThis is the instruction manual for our program. If you need to view it at any time during the game, just use the INFO command.");
	System.out.println("\nBasics:\nThis is a historically-themed wargame; If you've ever played Risk, Diplomacy, Advanced Squad Leader, or any of the Avalon Hill boardgames, you already have an idea of how this works.");
	System.out.println("\nThe game is played on the army-fleet scale; you and your opponent are generals of opposing sides. You must play at the same computer. The objective is to destroy the enemy completely!");
	System.out.println("\nStructure:\nWhen you and a friend play, you will take turns sending orders to the battlefield. The orders come in the form of simple commands. Examples are given below:\n\nA7 NORTH\nD4 STRIKE NORTH\nINFO");
	//END ONE FULL 24-line PAGE
	input.nextLine();

    }

    public static void runTurn(){
    }

    public static void menu(){
	System.out.println("-=. AS Historical Military Simulations .=-");
	System.out.println("Pick one: \n 1.Play Random\n 2.Manual\n 3.Exit");
    }

    public static void playerParser(){
    }

    public static void printField(){
	String toPrint = "";
	for(int x = 0; x < field.length; x++){
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
