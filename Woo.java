import java.util.Scanner;

public class Woo{

    //contains the FIELD of TERRAIN tiles
    public static Terrain[][] field;
    public static Unit[][] units;
    public static Scanner input = new Scanner(System.in);
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static String[] playerNames = {"one","two"};
    public static int[] playerStrengths = {0,0};
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
	    if( playerStrengths[current] == 0){
		clear();
		System.out.println(" YOU HAVE BEEN DESTROYED ");
		return;
	    }
	    runTurn();
	    turns++;
	}


	
    }

    //Gets the player names and then generates the field.
    public static void start(boolean isRandom){

	clear();
	System.out.print("Welcome to AS Military, you have selected ");
	if(isRandom){ System.out.println(" a random game.");}
	else{ System.out.println(" to pick a scenario.");}
	System.out.println("Please check the manual for more info ('manual' or 'info' in game)\n");
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
	for(int x = 0; x < units.length; x++){
	    for( int y = 0; y < units[0].length;y++){
		if( units[x][y] != null){
		    playerStrengths[units[x][y].getOwner()] += 1;
		}
	    }
	}
    }

    //Picks from prewritten battle scenarios
    public static void pickScenario(){
	/*	for( Terrain[] terrainRow: field){
	    for( Terrain terrainSquare: terrainRow){
		terrainSquare = new Land();
	    }
	    }*/
	String[] scenarioList = 
	    {"Singlecombat.txt", "Guadalcanal.txt", "Hamptonroads.txt" };
	String scen = "";
	while(scen.equals("")){
	    clear();
	    System.out.println("Select a scenario from below:\n");
	    System.out.println("0 .Single Combat    -- One on one");
	    System.out.println("1 .Guadalcanal      -- Allies vs Japanese Empire, 1942");
	    System.out.println("2 .Hampton Roads    -- Clash of the Ironclads, Civil War 1862");
	    
	    String inputLine = input.nextLine();

	    int index = 0;
	    
	    try{
		index = Integer.parseInt(inputLine);
	    }catch(Exception e){}

	    if (0 <= index && index < scenarioList.length){
		scen = scenarioList[index];
	    }
	}
	clear();
	Scenarios.pick(scen, field, units);
	input.nextLine();
	return;
    }

    //Randomly creates a new battle
    public static void generateRandom(){
	
	//generate a random field =========================================
	for( int x = 0; x < field.length-10; x++){
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
	for( int x = field.length-10; x < field.length; x++){
	    for( int y = 0; y < field[0].length; y++){
		int randchoice = (int)(Math.random()*10); //<== INSERT number of choices
		if ( randchoice > 7){
		    field[x][y] = new Land();
		}
		if ( randchoice <= 7)
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
		units[x][y] = new Infantry(0);
		unitNum++;
	    }
	    else if(field[x][y].getSymbol() == "|"){
		units[x][y] = new Navy(0);
		unitNum ++;
	    }  
	}
	while(unitNumE < 4){
	    int x = (int)(Math.random() * field.length);
	    int y = (int)(Math.random() * field[0].length);
	    if(	field[x][y].getSymbol() == "-"){
		units[x][y] = new Infantry(1);
		unitNumE++;
	    }
	    else if(field[x][y].getSymbol() == "|"){
		units[x][y] = new Navy(1);
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
	System.out.println("\nStructure:\nWhen you and a friend play, you will take turns sending orders to the battlefield. The orders come in the form of simple commands. Examples are given below:\n\nA7 NORTH\nD4 attack D5");
	System.out.println("Page 1");
	//END ONE FULL 24-line PAGE
	input.nextLine();
	clear();
	System.out.println("\nSpecifics:\nHow to specify a particular unit: By letter and number. First comes the letter, which specifies ROW. (A-Z). Then comes number, which specifies column (0-80). All numbers are written vertically due to space issues.\nFor example, the number 54 would be written above its respective column like this:\n5\n4");
	System.out.println("Infantry is represented by a z. Navy is represented by a y. Some scenarios have special units, such as the weaker navy Sailship(%) and Artillery (#). Infantry and artilery units can only move on land, represented by a -. Navy units can only move on water, represented by |.");
	System.out.println("Player 1's units are blue. Player 2's are red. ");
	System.out.println("To Attack: Type in <your attacking unit coordinates> ATTACK <unit you want to attack's coordinates>. For example: A16 ATTACK A17");
	System.out.println("Infantry units can only attack enemies up to 2 tiles away from them. A navy unit can attack as far as 4 tiles away. Artiller can attack from 6 tiles away. If your attack is out of range it will still count as a turn taken.");
	System.out.println("Commands:\nDirection: NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST.\nAttacking: ATTACK\nMISC: SKIP, INFO");
	System.out.println("Page 2, END MANUAL, <ENTER> to exit.");
	input.nextLine();

    }

    public static void runTurn(){
	boolean passTurn = false;
	while( passTurn == false){
	    clear();
	    printField();

	    if( current == 0)
		System.out.print("\033[30;46mWhat is your command?\033[0m\t");
	    if( current == 1)
		System.out.print("\033[30;41mWhat is your command?\033[0m\t");
	    passTurn = playerParser( input.nextLine());
	}
    }

    public static void menu(){
	System.out.println("     ____       ________                  ");
	System.out.println("    /    |     /        |                 ");
	System.out.println("    | ._  |    |   ____|                  ");
	System.out.println("   || |_|  |    |      |                  ");
	System.out.println("   |   ___  |    |__    |                 ");
	System.out.println("  ||  ||  |  |______|    |    ========    ");
	System.out.println("  |   //   |  |          |===========     ");
	System.out.println("  |__//     |__|_________/==========      ");
	System.out.println("===========================================\n");
	System.out.println("-=. AS Historical Military Simulations .=-");
	System.out.println("Intended for 80 x 24 display.");
	System.out.println("Pick one: \n 1.Play Random\n 2.Pick Scenario\n 3.Manual\n 4.Exit");
    }



    //Gets the input string, does the appropriate action.
    //Returns TRUE iff the action should pass the turn to the other player.
    public static boolean playerParser(String com){
	message = "";
	//TESTING FOR: NO COMMAND
	if(com.length() == 0){
	    return false;}

	//TESTING FOR: MANUAL, INFO
	if(  (com.length() >= 4 && com.substring(0,4).toUpperCase().equals("INFO") )
	     || (com.length() >= 6 && com.substring(0,6).toUpperCase().equals("MANUAL")) )
	    {
	    manual();
	    message = "Ready for orders.";
	    return false;
	    }

	//TESTING FOR: TRAVEL DIRECTION: ANY, see directions list at top. Will loop and check 4 each.
	for( int count = 0; count < 8; count++){
	    if(com.length() >= 8
	       && com.substring(4,com.length()).toUpperCase().equals( directions[count] )
	       ){
		int x = 0;
		int y = 0;
		try{
		    y = Integer.parseInt(com.substring(1,3));}
		catch(Exception e){
		    message = "Not too sure we understood that.";
		    return false;
		}
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
		if( !(units[x][y].getOwner()==current)){
		    message = com.substring(0,3).toUpperCase() + " is an enemy unit.";
		    return false;
		}
		else{
		    if(units[x][y].move(count, x, y, units, field)){
			message = "Ready for orders.";
			return true;}
		    else{
			message = com.substring(0,3).toUpperCase() + " cannot move there!";
			return false;
		    }
		}
	    }
	}

	//TESTING FOR: ATTACK?
	if( com.length() >= 14 && com.substring(4,10).toUpperCase().equals("ATTACK")){
	    int x = 0;
	    int y = 0;
	    int k = 0;
	    try{
		y = Integer.parseInt(com.substring(1,3));
		k = Integer.parseInt(com.substring(12,14));
	    }
	    catch(Exception e){
		message = "Not too sure we understood that.";
		return false;
	    }
	    for(int i = 0; i < alphabet.length(); i++){
		if( alphabet.substring(i,i+1).equals(com.substring(0,1).toUpperCase()) ){
		    x = i;}}
	    int h = 0;

	    for(int i = 0; i < alphabet.length(); i++){
		if( alphabet.substring(i,i+1).equals(com.substring(11,12).toUpperCase()) ){
		    h = i;}}
	    if( !(0 <= x && x < field.length) || !(0 <= y && y < field[0].length) ||
		units[x][y] == null || units[x][y].getOwner() != current){
		message = "No friendly unit found at " + com.substring(0,3) + " !";
		return false;}
	    if( !(0 <= h && h < field.length) || !(0 <= k && k < field[0].length) ||
		units[h][k] == null){
		message = "Target not found!";
		return false;}
	    if( units[h][k].getOwner() == current){
		message = "Don't attack a friendly unit!";
		return false;}
	    else{
		message = "";
		if(units[x][y].attack(x,y,h,k,units))
		    message = "Received a hit at " + com.substring(11,14) + " !";
		if(units[h][k].getHp() <= 0){
		    playerStrengths[units[h][k].getOwner()] -= 1;
		    units[h][k] = null;
		    message += "Lost a unit at " + com.substring(11,14) + " !";
		}		
		message +=  " Ready for orders.";
		return true;}
	}
	if(com.toUpperCase().equals("SKIP")){
	    message = "Ready for orders.";
	    return true;}

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
		else if( units[x][y].getOwner() == 1){
		    toPrint += "\033[31m" + units[x][y].getSymbol() + "\033[0m";}
		else if( units[x][y].getOwner() == 0){
		    toPrint += "\033[36m" + units[x][y].getSymbol() + "\033[0m";}
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

    public static String getInfo(int row, int col){
	String retStr="";
	Unit theUnit = units[row][col];
	retStr+= "owned by player " + theUnit.getOwner() + "\n";
	retStr += "strength: " + theUnit.getStrength();
	return retStr;
    }
}
