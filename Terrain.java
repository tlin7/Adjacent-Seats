public class Terrain{
    protected String name;
    protected String symbol="@";
    protected String description;
    

    //Randomizes symbol for testing purposes
    public Terrain(){
	int randInt = (int)(Math.random() * 2);
	if (randInt == 0){
	    symbol = "@";
	}
	else {
	    symbol = "$";
	}
    }
    
    public String getSymbol(){
	return symbol;
    }

    public String getname(){
	return name;
    }

    public String getDescription(){
	return description;
    }

    public static void main(String[] main){
	Terrain theTerrain = new Terrain();
	System.out.println(theTerrain.getSymbol());
    }




}
