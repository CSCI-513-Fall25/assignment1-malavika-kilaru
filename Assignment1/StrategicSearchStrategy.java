public class StrategicSearchStrategy implements SearchStrategy
{
 public int search(Grid grid)
  {
    int cellsSearched=0;

    cellsSearched+=diagonalSweep(grid);
     if(grid.bothShipsFound()) 
     return cellsSearched;

     cellsSearched +=spaceSearch(grid);
     if(grid.bothShipsFound()) return cellsSearched;

    cellsSearched +=remainingCells(grid);
    return cellsSearched;
}
  private int diagonalSweep(Grid grid)
{
    int searched=0;
    for(int i=0; i<25 && ! grid.bothShipsFound();i++)
{
  searched++;
  grid.searchCell(i,i);
}
for(int i=0;i<25 && !grid.bothShipsFound();i++)
{
 searched++;
 grid.searchCell(i,24-i);
}
return searched;
}

  private int spaceSearch(Grid grid)
{
   int searched=0;
   for(int row=0; row<25 && ! grid.bothShipsFound(); row+=3)
   {
     for( int col=0;col< 25 && ! grid.bothShipsFound();col+=3)
      { 
         searched++;
       grid.searchCell(row,col);
     }
  }
    return searched;
}
private int remainingCells(Grid grid)
 {
    int searched=0;
   for(int row=0; row<25 && ! grid.bothShipsFound(); row++)
   {
     for( int col=0;col< 25 && ! grid.bothShipsFound();col++)
      { 
         searched++;
       grid.searchCell(row,col);
     }
  }
    return searched;
}
public String getName()
{
 return "Strategic search";
 }
}
