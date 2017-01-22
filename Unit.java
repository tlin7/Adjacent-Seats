public class Unit extends Tiles{
    protected int hp = 1;
    protected int strength = 1;
    protected int weapon;
    protected String viableTerrain;
    protected int attackRange = 2;
    protected int moveRange;
    protected String name;
    protected String symbol;
    protected int owner;
    
    public int getHp(){
	return hp;
    }
    public int getOwner(){
	return owner;
    }

    public String getName(){
	return "";
    }
    public int getStrength(){
	return strength;
    }
    public void takeDmg(int dmgs){
	hp -= dmgs;
    }

    //attack 
    public boolean attack(int myRow, int myCol, int attRow, int attCol, Unit[][] inputArray){
	int rowDelta = attRow - myRow;
	int colDelta = attCol - myCol;
	int distance = (int)(Math.sqrt((rowDelta * rowDelta) + (colDelta * colDelta)));
	if (distance <= attackRange){
	    int damage = this.strength * this.weapon;
	    inputArray[attRow][attCol].takeDmg(damage);
	    return true;
	}
	return false;
      
    }

    public boolean isLegalMove(int checkRow, int checkCol, Unit[][] inputArray, Terrain[][] inputTerrain){

	//Check if something is being moved out of the map
	if (checkRow==-1 ||
	    checkCol == -1 ||
	    checkRow > (inputArray.length-1) ||
	    checkCol > (inputArray[0].length-1))
	    {
	        
		return false;
	    }

	//Check if occupied by another unit
	if (inputArray[checkRow][checkCol] != null){
	    
	    return false;
	    
	}

	if(inputTerrain[checkRow][checkCol] instanceof Sea){
	    return false;
	}

	return true;
    }

    public boolean move(int travelDir, int row, int col, Unit[][] inputArray, Terrain[][] inputTerrain){
	Unit storedUnit = inputArray[row][col];
	inputArray[row][col]=null;
	if (isLegalMove(row-1,col-1,inputArray,inputTerrain) && travelDir==0){
	    inputArray[row-1][col-1] =storedUnit;
	    return true;
	}
	//NORTH
	else if(isLegalMove(row-1,col,inputArray,inputTerrain) && travelDir==1){
	    inputArray[row - 1][col]=storedUnit;
	    return true;
	}
	else if (isLegalMove(row-1,col+1,inputArray,inputTerrain) && travelDir ==2){
	    inputArray[row-1][col+1]=storedUnit;
	    return true;
	}
	//EAST
	else if (isLegalMove(row,col+1,inputArray,inputTerrain)&& travelDir==3){
	    inputArray[row][col+1]=storedUnit;
	    return true;
	}
	else if (isLegalMove(row+1,col+1,inputArray,inputTerrain) && travelDir==4){
	    inputArray[row+1][col+1]=storedUnit;
	    return true;
	}
	//SOUTH
	else if (isLegalMove(row+1,col,inputArray,inputTerrain) && travelDir==5){
	    inputArray[row+1][col]=storedUnit;
	    return true;
	}
	else if (isLegalMove(row+1,col-1,inputArray,inputTerrain) && travelDir==6){
	    inputArray[row+1][col-1]=storedUnit;
	    return true;
	}
	//WEST
	else if (isLegalMove(row,col-1,inputArray,inputTerrain) && travelDir==7){
	    inputArray[row][col-1]=storedUnit;
	    return true;
	}

	else {
	    inputArray[row][col]=storedUnit;
	    return false;
	}
	
    }
    public String getSymbol(){
	return this.symbol;
    }
}
