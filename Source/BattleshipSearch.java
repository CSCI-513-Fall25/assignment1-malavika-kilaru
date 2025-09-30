 import java.util.StringTokenizer;

public class BattleshipSearch{

  private SearchStrategy strategy;
   private Grid grid;

  public  BattleshipSearch(){

 grid=new Grid();
}
  public void setStrategy(SearchStrategy strategy){
  
	  this.strategy=strategy;
  }
  
     public int executeSearch(){
     
       if( strategy==null){

  throw new IllegalStateException("NO search stratregy set");
 }
 return strategy.search(grid);
}
  public void loadGame(String gameData){

   grid.reset();
StringTokenizer tokenizer=new StringTokenizer (gameData,"()");

   
   
int[][] carrierCoords=new int[5][2];
int[][] subCoords =new int[3][2];

for(int i=0; i<5;i++){

  if(tokenizer.hasMoreTokens()){

  String coords=tokenizer.nextToken();
  String[] pair= coords.split(",");
  carrierCoords[i][0]=Integer.parseInt(pair[0]);
  carrierCoords[i][1]=Integer.parseInt(pair[1]);
 }
   }
      

for(int i=0; i<3;i++){
if(tokenizer.hasMoreTokens())
{
  String coords=tokenizer.nextToken();
  String[] pair=coords.split(",");
  subCoords[i][0]=Integer.parseInt(pair[0]);
  subCoords[i][1]=Integer.parseInt(pair[1]);
 }
}      
   grid.placeShip(carrierCoords,true);
   grid.placeShip(subCoords,false);
}
   public Grid getGrid()
   {
     return grid;
    }
}

