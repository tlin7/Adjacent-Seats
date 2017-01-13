public class Navy extends Unit{
    public Navy(){
	strength = 10;
	weapon = 10;
	viableTerrain = new String[1];
	attackRange = 10;
	moveRange = 1;
	symbol = "^";
    }

    public Navy(String newOwner){
	this();
	owner = newOwner;
    }
}
