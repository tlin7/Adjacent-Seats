import java.io.*;

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
	System.out.println(prefield);
	for(int x = 0; x < prefield.length() ; x++){
	    if ( prefield.substring(x,x+1).equals("\n")){
		height += 1;
	    }
	}
	for(int x = 0; x < prefield.length(); x++){
	    if ( prefield.substring(x,x+1).equals("\n")){
		width = x + 1;
		break;}
	}
	//==============================================

	//field = new Terrain[height][width];

	//ADD an OBJECT for each corresponding character in the STRING
	int y = 0;
	for( int x = 0; x < prefield.length(); x++){
	    if( prefield.substring(x,x+1).equals("\n"))
		y+=1;
	    if( prefield.substring(x,x+1).equals("-") ) // - IS LAND"
		field[y][x % width] = new Land();
	    if( prefield.substring(x,x+1).equals("|") ) // | IS Sea"
		field[y][x % width] = new Sea();
	    //add more conditionals
	}}
    
    public static Unit unitPicker(String type, int owner){
	Unit retUnit;
	System.out.print(type);
	System.out.println("//");
	if(type.equals("Infantry")){
	    retUnit = new Infantry(owner);}
	else if((type.equals("Navy"))){
	    retUnit = new Navy(owner);}
	else{
	    retUnit = null;
	}	
	return retUnit;
    }


    public static boolean pick(String scen, Terrain[][] field, Unit[][] units){
	//	String prefield = "-----\n-----\n-----\n-----\n-----";
	String prefield = "";
	stringTofield(prefield, field);

	BufferedReader input = null;
	String inputline = "";

	try{
	    input = new BufferedReader(new FileReader(scen));
	    while( (inputline = input.readLine()) != null){
		if(inputline.substring(0,5).toUpperCase().equals("UNITS")){
		    units[Integer.parseInt(inputline.substring(6,8))]
			[Integer.parseInt(inputline.substring(9,11))] = unitPicker(inputline.substring(14),Integer.parseInt(inputline.substring(12,13)));
		}
		prefield += inputline + "\n";
	    }
		
	}
	catch(IOException e){
	    e.printStackTrace();
	    return false;
	}
	stringTofield(prefield, field );
	return true;
    }

    public static void main( String[] args){
	Terrain[][] field = new Terrain[5][5];
	Unit[][] units = new Unit[5][5];
	pick("testing.txt",field, units);
    }

}
