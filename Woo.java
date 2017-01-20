
import java.util.Scanner;

public class Woo{

    //contains the FIELD of TERRAIN tiles
    public static Terrain[][] field;
    public static Unit[][] units;
    public static Scanner input = new Scanner(System.in);
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String[] playerNames = {"one","two"};
    public static int current = 0;

    public static String message = "Welcome.";
    public static String[] directions = {"NORTHWEST", "NORTH", "NORTHEAST", "EAST", "SOUTHEAST", "SOUTH", "SOUTHWEST", "WEST"};
  
    
    //main
    public static void main(String[] args){

	field = new Terrain[20][50];
	units = new Unit[20][50];

	String choice = "";
	while( choice.equals("")){
	    clear();
	    menu();
	    choice = input.nextLine();
	    if (choice.equals("1")){ start(true); break;}
	    if (choice.equals("2")){ start(false); break;}
	    if (choice.equals("3")){ manual(); choice = "";}
	    if (choice.equals("4")){ return;}
	    else{choice = "";}
	}

	int turns = 0;
	while(true){
	    current = turns % 2;
	    runTurn();
	    turns++;
	}


	
    }

    //intializes a new random field and some new random units
    public static void start(boolean isRandom){

	clear();
	System.out.println("Welcome to AS Military, you have selected a RANDOM game.");
	System.out.println("Please check the manual for any questions you might have.\n");
	System.out.print("First player, please enter a name:\n::");
	playerNames[0]=input.nextLine();
	System.out.println(playerNames[0] + " registered as first player.");
	System.out.print("Second player, please enter a name:\n::");
	playerNames[1]=input.nextLine();
	System.out.println(playerNames[1] + " registered as second player.\n");
	System.out.println("<enter> to proceed.");
	
	if(isRandom)
	    generateRandom();

	else{
	    pickScenario();
	}
    }
    public static void pickScenario(){
	System.out.println(". . . ");
	Scenarios.pick("hastings", field, units);
    }

    public static void generateRandom(){
	
	//generate a random field =========================================
	for( int x = 0; x < field.length; x++){
	    for( int y = 0; y < field[0].length; y++){
		int randchoice = (int)(Math.random()*10); //<== INSERT number of choices
		if ( randchoice > 3){
		    field[x][y] = new Land();
		}
		if ( randchoice <= 3)
		    field[x][y] = new Sea();
		//if (randchoice == 2)
	    }
	}
	//random generation of units
	int unitNum = 0;
	int unitNumE = 0;
	while(unitNum < 4){
	    int x = (int)(Math.random() * field.length);
	    int y = (int)(Math.random() * field[0].length);
	    if(	field[x][y].getSymbol() == "-"){
		units[x][y] = new Infantry(playerNames[0]);
		unitNum++;
	    }
	    else if(field[x][y].getSymbol() == "|"){
		units[x][y] = new Navy(playerNames[0]);
		unitNum ++;
	    }  
	}
	while(unitNumE < 4){
	    int x = (int)(Math.random() * field.length);
	    int y = (int)(Math.random() * field[0].length);
	    if(	field[x][y].getSymbol() == "-"){
		units[x][y] = new Infantry(playerNames[1]);
		unitNumE++;
	    }
	    else if(field[x][y].getSymbol() == "|"){
		units[x][y] = new Navy(playerNames[1]);
		unitNumE ++;
	    }  
	}

	// END random generation ==========================================

	
    }

    public static void manual(){
	clear();
	System.out.println("MANUAL\nEnter anything to advance the pages.");
	System.out.println("Welcome to AdjacentSeats's Historical Military Simulator.");
	System.out.println("\nThis is the instruction manual for our program. If you need to view it at any time during the game, just use the INFO command.");
	System.out.println("\nBasics:\nThis is a historically-themed wargame; If you've ever played Risk, Diplomacy, Advanced Squad Leader, or any of the Avalon Hill boardgames, you already have an idea of how this works.");
	System.out.println("\nThe game is played on the army-fleet scale; you and your opponent are generals of opposing sides. You must play at the same computer. The objective is to destroy the enemy completely!");
	System.out.println("\nStructure:\nWhen you and a friend play, you will take turns sending orders to the battlefield. The orders come in the form of simple commands. Examples are given below:\n\nA7 NORTH\nD4 STRIKE NORTH");
	System.out.println("Page 1");
	//END ONE FULL 24-line PAGE
	input.nextLine();
	clear();
	System.out.println("\nSpecifics:\nHow to specify a particular unit: By letter and number. First comes the letter, which specifies ROW. (A-Z). Then comes number, which specifies column (0-80). All numbers are written vertically due to space issues.\nFor example, the number 54 would be written above its respective column like this:\n5\n4");
	System.out.println("\nCommands:\nDirection: NORTH, EAST, SOUTH, WEST.");
	System.out.println("Page 2");

	System.out.println("END MANUAL, <ENTER> to exit.");
	input.nextLine();

    }

    public static void runTurn(){
	boolean passTurn = false;
	while( passTurn == false){
	    clear();
	    printField();
	    System.out.print("What is your command?\t");
	    passTurn = playerParser( input.nextLine());
	}
    }

    public static void menu(){
	System.out.println("-=. AS Historical Military Simulations .=-");
	System.out.println("Pick one: \n 1.Play Random\n 2.Pick Scenario\n 3.Manual\n 4.Exit");
    }



    //Gets the input string, does the appropriate action.
    //Returns TRUE iff the action should pass the turn to the other player.
    public static boolean playerParser(String com){
	if(com.length() == 0){
	    return false;}

	if(  (com.length() >= 4 && com.substring(0,4).toUpperCase().equals("INFO") )
	     || (com.length() >= 6 && com.substring(0,6).toUpperCase().equals("MANUAL")) )
	    {
	    manual();
	    message = "Ready for orders.";
	    return false;
	    }

	//TRAVEL DIRECTION: ANY, see directions list at top. Will loop and check 4 each.
	for( int count = 0; count < 8; count++){
	    if(com.length() >= 8
	       && com.substring(4,com.length()).toUpperCase().equals( directions[count] )
	       ){
		int x = 0;
		int y = Integer.parseInt(com.substring(1,3));
		for(int i = 0; i < alphabet.length(); i++){
		    if( alphabet.substring(i,i+1).equals(com.substring(0,1).toUpperCase()) ){
			x = i;
		    }
		}
		//	    System.out.println(x + "-" + y);
		//	    input.nextLine();
		if( !(0<=x && x<field.length) || !(0<=y && y<field[0].length) || units[x][y] == null){
		    message = "No unit detected there, sir! Your order couldn't be carried out.";
		    return false;}
		if( !(units[x][y].getOwner().equals(playerNames[current]))  ){
		    message = com.substring(0,3).toUpperCase() + " is an enemy unit.";
		    return false;
		}
		else{
		    units[x][y].move(count, x, y, units, field);
		    message = "Ready for orders.";
		    return true;
		}
	    }
	}
	message = "Not too sure we understood that.";
	return false;
	}

    //PRINT THE BATTLESCREEN
    public static void printField(){
	int messageWidth = 74 - field[0].length;
	String toPrint = " ";
	
	message = "Communications for " + playerNames[current] + ": " + message;
	//ADD THE numbering to the top of the printjob
	for(int x = 0; x < field[0].length;x++){
	    toPrint += (int)(x / 10);
	}
	toPrint += "\n ";
	for(int x = 0; x < field[0].length;x++){
	    toPrint += (x % 10);
	}
	toPrint += "\n";

	//now add the actual grid:
	for(int x = 0; x < field.length; x++){
	    toPrint += alphabet.substring(x,x+1);
	    for(int y = 0; y < field[0].length;y++){
		if( units[x][y] == null){
		    toPrint += field[x][y].getSymbol();}
		else{
		    toPrint += units[x][y].getSymbol();}
	    }
	    if (x*messageWidth+messageWidth <= message.length() )
		toPrint += "   " +  message.substring(x*messageWidth, x*messageWidth+messageWidth   )   ;
	    else if (x*messageWidth+messageWidth < message.length() + messageWidth){
		toPrint += "   " +  message.substring(x*messageWidth)   ;
	    }
	    
	    toPrint += "\n";
	}
	System.out.println(toPrint);
    }

    public static void clear(){
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }

}
