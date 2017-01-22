public class Sailship extends Navy{
    public Sailship(){
	super();
	hp = 40;
	strength = 5;
	symbol = "%";
    }
    
    public Sailship(int newOwner){
	this();
	owner = newOwner;}


}
