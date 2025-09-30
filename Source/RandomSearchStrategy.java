import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class RandomSearchStrategy implements SearchStrategy
{
 private Random random;
   public RandomSearchStrategy()
    {
      random=new Random();
     }
public int search(Grid grid)
{
  int cellsSearched=0;
   Set<String> searchedCoords =new HashSet<String>();
   while (!grid.bothShipsFound() && cellsSearched< 625)
{
   int row =random.nextInt(25);
  int col=random.nextInt(25);
   String coord=row+","+col;
if(searchedCoords.contains(coord))
  {
   continue;
  }
   searchedCoords.add(coord);
   cellsSearched++;
   grid.searchCell(row,col);
}
  return cellsSearched;
}
  public String getName()
{
  return "Random Search";
 }
}


