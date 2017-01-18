public class Scenarios{

    //This is Scenarios.java, the class with all the premade
    //scenarios
    
    //for now, each scenario is just hard coded in this file.

    /*
    public static void <battlename>(String[] playerNames, 
    Terrain[][] field, Unit[][] units){
				
    String 

    //Area to add terrain, units


    }
    */

    public static void stringTofield(String prefield, Terrain[][] field ){
	int height = 0;
	int width = 0;
	//SET HEIGHT AND WIDTH OF NEW ARRAY BY SEARCHING
	// FOR NEWLINES IN input string
	for(int x = 0; x < prefield.length() ; x++){
	    if ( prefield.substring(x,x+1).equals('\n')){
		height += 1;
	    }
	}
	for(int x = 0; x < prefield.length(); x++){
	    if ( prefield.substring(x,x+1).equals('\n')){
		width = x + 1;
		break;}
	}
	//==============================================

	field = new Terrain[height][width];

	//ADD an OBJECT for each corresponding character in the STRING
	int y = 0;
	for( int x = 0; x < prefield.length(); x++){
	    if( prefield.substring(x,x+1).equals('\n'))
		y+=1;
	    if( prefield.substring(x,x+1).equals('-') ) // - IS LAND
		field[y][x % width] =new Land();
	    //add more conditionals
	}}

	public static void test(Terrain[][] field, Unit[][] units){
	    String prefield = "-----\n-----\n-----\n-----\n-----";
	    stringTofield(prefield, field);
	}

	public static void main( String[] args){
	    Terrain[][] field;
	    Unit[] units;
	    test(field, units);
	}
	














}
