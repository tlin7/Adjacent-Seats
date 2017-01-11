public class Unit extends Tiles{

    protected int strength;
    protected int weapon;
    protected String[] viableTerrain;
    protected int attackRange;
    protected int moveange;
    protected String name;
    protected String symbol = "%";

    public String getName(){
	return "";
    }
    public int getStrength(){
	return 0;
    }
    public int attack(Unit beingAttacked){
	return 0;
    }
    public int move(int direction){
	return 0;
    }
    public String getSymbol(){
	return this.symbol;
    }

    public static void main(String[] args){
	Unit theUnit = new Unit();
	System.out.println(theUnit.getSymbol());
	
    }




}
