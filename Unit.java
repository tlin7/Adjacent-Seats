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

    public boolean isLegalMove(int checkRow, int checkCol, Unit[][] inputArray){
	//Check if occupied by another unit
	if (inputArray[checkRow][checkCol] != null){
	    
	    return false;
	    
	}
	//Check if something is being moved out of the map
	if (checkRow==-1 ||
	    checkCol == -1 ||
	    checkRow > (inputArray.length-1) ||
	    checkCol > (inputArray[0].length-1))
	    {
	        
		return false;
	    }
	return true;
    }
    
    public void move(int travelDir, int row, int col, Unit[][] inputArray){
	Unit storedUnit = inputArray[row][col];
	inputArray[row][col]=null;
	if (travelDir==0 && isLegalMove(row-1,col-1,inputArray)){
	    inputArray[row-1][col-1] =storedUnit;
	    return;
	}
	//NORTH
	else if(travelDir==1 && isLegalMove(row-1,col,inputArray)){
	    inputArray[row - 1][col]=storedUnit;
	    return;
	}
	else if (travelDir==2 && isLegalMove(row-1,col+1,inputArray)){
	    inputArray[row-1][col+1]=storedUnit;
	    return;
	}
	//EAST
	else if (travelDir==3 && isLegalMove(row,col+1,inputArray)){
	    inputArray[row][col+1]=storedUnit;
	    return ;
	}
	else if (travelDir==4 && isLegalMove(row+1,col+1,inputArray)){
	    inputArray[row+1][col+1]=storedUnit;
	    return ;
	}
	//SOUTH
	else if (travelDir==5 && isLegalMove(row+1,col,inputArray)){
	    inputArray[row+1][col]=storedUnit;
	    return ;
	}
	else if (travelDir==6 && isLegalMove(row+1,col-1,inputArray)){
	    inputArray[row+1][col-1]=storedUnit;
	    return ;
	}
	//WEST
	else if (travelDir==7 && isLegalMove(row,col-1,inputArray)){
	    inputArray[row][col-1]=storedUnit;
	    return ;
	}

	else {
	    inputArray[row][col]=storedUnit;
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
