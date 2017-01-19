public class Navy extends Unit{
    public Navy(){
	hp = 100;
	strength = 10;
	weapon = 3;
	viableTerrain = "|";
	attackRange = 4;
	moveRange = 1;
	symbol = "^";
    }

    public Navy(String newOwner){
	this();
	owner = newOwner;
    }
}
