import cs1.Keyboard;

public class Woo{
    
    public static void main(String[] args){
	int choice = 0;
	while( choice == 0){
	    clear();
	    menu();
	    choice = Keyboard.readInt();
	    if (choice == 1){ start();}
	    if (choice == 2){ manual(); choice = 0;}
	}
	
    }

    public static void start(){

    }

    public static void manual(){
	clear();
	System.out.println("MANUAL\nThis is the manual, lorem ipsum etc");
	Keyboard.readString();
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
