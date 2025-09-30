import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main
{
   public static void main(String[] args)
    {
       try {
             processGames();
           } catch (IOException e){
                System.err.println("Error reading input file:"+e.getMessage());
           }
        }
private static void processGames() throws IOException {
         List<String> games=readGamesFromFile("input.txt");
  SearchStrategy[] strategies={ new HorizontalSweepStrategy(),new RandomSearchStrategy(), new StrategicSearchStrategy() 
};
  

BattleshipSearch searcher=new BattleshipSearch();


for(int gameNum=0; gameNum<games.size(); gameNum++)
{
  System.out.println("Game"+ (gameNum+1)+":");

for(SearchStrategy strategy: strategies) 
{
  searcher.loadGame(games.get(gameNum));
  searcher.setStrategy(strategy);

   int cellsSearched=searcher.executeSearch();
   Grid grid = searcher.getGrid();

	System.out.println("Strategy:" +strategy.getName());
	System.out.println("Number of cells searched:"+ cellsSearched);
	System.out.println("Carrier found:" +grid.getCarrierCoords());
	System.out.println("Submarine found:" +grid.getSubmarineCoords());
	System.out.println();
    }
  }
}
   private static List<String> readGamesFromFile(String filename) throws IOException
    {
         List<String> games=new ArrayList<String>();
  try(BufferedReader reader=new BufferedReader(new FileReader(filename)))
{
    String line;
    while((line=reader.readLine())!= null)
{
  	if(!line.trim().isEmpty())
{
  	games.add(line.trim());
	}
  }
}
return games;
  }
}
  
 