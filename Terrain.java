public class Terrain{
    protected String name;
    protected String symbol="@";
    protected String description;
    
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
