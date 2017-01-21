public class Infantry extends Unit{

    public static String[] symbolList={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","s"};

    
    public Infantry(){
	hp = 50;
	strength = 10;
	weapon = 2;
	viableTerrain = "-";
	attackRange = 2;
	moveRange = 1;
	symbol = "z";
    }

    public Infantry(int newOwner){
	this();
	owner = newOwner;
	symbol = symbolList[(int)(Math.random()*19)];
	if (owner == 0){
	    symbol = symbol.toUpperCase();
	}

	    
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

}
