import cs1.Keyboard;

public class Woo{

    //contains the FIELD of TERRAIN tiles
    public static Terrain[][] field;
    public static Unit[][] units;
    
    //main
    public static void main(String[] args){
	field = new Terrain[20][20];
	int choice = 0;
	while( choice == 0){
	    clear();
	    menu();
	    choice = Keyboard.readInt();
	    if (choice == 1){ start();}
	    if (choice == 2){ manual(); choice = 0;}
	}
	
    }

    //intializes a new random field and some new random units
    public static void start(){
	
	//generate a random field
	for( int x = 0; x < field.length; x++){
	    for( int y = 0; y < field.length; y++){
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

	Keyboard.readStringAny();
    }

    public static void runTurn(){
    }

    public static void menu(){
	System.out.println("-=. Historical Military Simulations .=-");
	System.out.println("Pick one: \n 1.Play Random\n 2.Manual\n");
    }

    public static void playerParser(){
    }

    public static void clear(){
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");
	System.out.println("\n");

    }

}
