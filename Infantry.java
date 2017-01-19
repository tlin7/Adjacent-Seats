public class Infantry extends Unit{
    public Infantry(){
	hp = 50;
	strength = 10;
	weapon = 2;
	viableTerrain = "-";
	attackRange = 2;
	moveRange = 1;
	symbol = "%";
    }

    public Infantry(String newOwner){
	this();
	owner = newOwner;
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

    public void move(int travelDir, int row, int col, Unit[][] inputArray, Terrain[][] inputTerrain){
	Unit storedUnit = inputArray[row][col];
	inputArray[row][col]=null;
	if (isLegalMove(row-1,col-1,inputArray,inputTerrain) && travelDir==0){
	    inputArray[row-1][col-1] =storedUnit;
	    return;
	}
	//NORTH
	else if(isLegalMove(row-1,col,inputArray,inputTerrain) && travelDir==1){
	    inputArray[row - 1][col]=storedUnit;
	    return;
	}
	else if (isLegalMove(row-1,col+1,inputArray,inputTerrain) && travelDir ==2){
	    inputArray[row-1][col+1]=storedUnit;
	    return;
	}
	//EAST
	else if (isLegalMove(row,col+1,inputArray,inputTerrain)&& travelDir==3){
	    inputArray[row][col+1]=storedUnit;
	    return ;
	}
	else if (isLegalMove(row+1,col+1,inputArray,inputTerrain) && travelDir==4){
	    inputArray[row+1][col+1]=storedUnit;
	    return ;
	}
	//SOUTH
	else if (isLegalMove(row+1,col,inputArray,inputTerrain) && travelDir==5){
	    inputArray[row+1][col]=storedUnit;
	    return ;
	}
	else if (isLegalMove(row+1,col-1,inputArray,inputTerrain) && travelDir==6){
	    inputArray[row+1][col-1]=storedUnit;
	    return ;
	}
	//WEST
	else if (isLegalMove(row,col-1,inputArray,inputTerrain) && travelDir==7){
	    inputArray[row][col-1]=storedUnit;
	    return ;
	}

	else {
	    inputArray[row][col]=storedUnit;
	}
       
	
    }
}
