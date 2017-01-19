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

	if(!(inputTerrain[checkRow][checkCol] instanceof Sea)){
	    return false;
	}

	return true;
    }

    public void move(int travelDir, int row, int col, Unit[][] inputArray){
	Unit storedUnit = inputArray[row][col];
	inputArray[row][col]=null;
	if (isLegalMove(row-1,col-1,inputArray) && travelDir==0){
	    inputArray[row-1][col-1] =storedUnit;
	    return;
	}
	//NORTH
	else if(isLegalMove(row-1,col,inputArray) && travelDir==1){
	    inputArray[row - 1][col]=storedUnit;
	    return;
	}
	else if (isLegalMove(row-1,col+1,inputArray) && travelDir ==2){
	    inputArray[row-1][col+1]=storedUnit;
	    return;
	}
	//EAST
	else if (isLegalMove(row,col+1,inputArray)&& travelDir==3){
	    inputArray[row][col+1]=storedUnit;
	    return ;
	}
	else if (isLegalMove(row+1,col+1,inputArray) && travelDir==4){
	    inputArray[row+1][col+1]=storedUnit;
	    return ;
	}
	//SOUTH
	else if (isLegalMove(row+1,col,inputArray) && travelDir==5){
	    inputArray[row+1][col]=storedUnit;
	    return ;
	}
	else if (isLegalMove(row+1,col-1,inputArray) && travelDir==6){
	    inputArray[row+1][col-1]=storedUnit;
	    return ;
	}
	//WEST
	else if (isLegalMove(row,col-1,inputArray) && travelDir==7){
	    inputArray[row][col-1]=storedUnit;
	    return ;
	}

	else {
	    inputArray[row][col]=storedUnit;
	}
       
	
    }
}
