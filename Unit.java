public class Unit extends Tiles{

    protected int strength;
    protected int weapon;
    protected String[] viableTerrain;
    protected int attackRange;
    protected int moveRange;
    protected String name;
    protected String symbol;
    protected String owner;

    public String getOwner(){
	return owner;
    }

    public String getName(){
	return "";
    }
    public int getStrength(){
	return 0;
    }
    public int attack(Unit beingAttacked){
	return 0;
    }
    public void move(int travelDir, int row, int col, Unit[][] inputArray){
	Unit storedUnit = inputArray[row][col];
	inputArray[row][col]=null;
	if (travelDir==0){
	    inputArray[row-1][col-1] =storedUnit;
	}
	//NORTH
	else if(travelDir==1){
	    inputArray[row - 1][col]=storedUnit;
	}
	else if (travelDir==2){
	    inputArray[row-1][col+1]=storedUnit;
	}
	//EAST
	else if (travelDir==3){
	    inputArray[row][col+1]=storedUnit;
	}
	else if (travelDir==4){
	    inputArray[row+1][col+1]=storedUnit;
	}
	//SOUTH
	else if (travelDir==5){
	    inputArray[row+1][col]=storedUnit;
	}
	else if (travelDir==6){
	    inputArray[row+1][col-1]=storedUnit;
	}
	//WEST
	else if (travelDir==7){
	    inputArray[row][col-1]=storedUnit;
	}
	    
	
    }
    public String getSymbol(){
	return this.symbol;
    }

    public static void main(String[] args){
	Unit theUnit = new Unit();
	System.out.println(theUnit.getSymbol());
	
    }




}
