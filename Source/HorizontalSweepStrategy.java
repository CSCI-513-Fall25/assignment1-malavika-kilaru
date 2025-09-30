public class HorizontalSweepStrategy implements SearchStrategy
{
  public int search(Grid grid)
   {
     int cellsSearched=0;
    for(int row=0;row<25;row++)
      {
        for(int col=0; col<25;col++)
         {
           cellsSearched++;
           grid.searchCell(row,col);
         if(grid.bothShipsFound())
       {
            return cellsSearched;
       }
   }
 }
    return cellsSearched;
}
public String getName()
 {
   return "Horizontal Sweep";
 }
}