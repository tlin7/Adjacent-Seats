public class Sailship extends Navy{
    //Sailship is a subclass of Navy.
    public Sailship(){
	super();
	hp = 40;
	strength = 5;
	symbol = "%";
    }
    //set Owner, aka player 1 or player 2.
    public Sailship(int newOwner){
	this();
	owner = newOwner;}


}
