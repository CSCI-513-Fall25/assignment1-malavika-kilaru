public class Grid
{
 private static final int ROWS=25;
 private static final int COLS=25;
 private char[][] grid;
 private boolean carrierFound;
 private boolean submarineFound;
 private String carrierCoords;
 private String submarineCoords;
 
   public Grid() 
    {
     grid =new char[ROWS][COLS];
     reset();
    }
     public void reset()
      {
        for(int i=0;i<ROWS;i++)
      {
        for(int j=0;j<COLS; j++)
         {
          grid[i][j]='.';
         }
      }
        carrierFound=false;
       submarineFound=false;
       carrierCoords="";
       submarineCoords="";
     }
      public void placeShip(int[][] coordinates,boolean isCarrier)
      {
        char shipChar=isCarrier?'c':'s';
        StringBuilder coords = new StringBuilder();
 
        for(int i=0;i<coordinates.length;i++)
         {
           int row=coordinates[i][0];
            int col=coordinates[i][1];
            grid[row][col]=shipChar;

           }
           coords.append("(").append(coordinates[0][0]).append(",").append(coordinates[0][1]).append(")");

coords.append("to");

coords.append("(").append(coordinates[coordinates.length-1][0]).append(",").append(coordinates[coordinates.length-1][1]).append(")");
          
      if(isCarrier) {
      carrierCoords=coords.toString();
     }  else
       {
        submarineCoords=coords.toString();
       }
    }
      public boolean searchCell(int row, int col)
      {
           if(row <0 || row>= ROWS || col<0 || col>=COLS)
            {
             return false;
             }
            char cell = grid[row][col];
            if(cell =='c')
             {
            checkIfCarrierFullyFound();
            return true;
            } else if (cell=='s')
              {
            checkIfSubmarineFullyFound();
            return true;
           }
             return false;
           }

       private void checkIfCarrierFullyFound()
       {
        int carrierParts=0;
        for(int i=0; i<ROWS;i++)
       {
        for(int j=0;j<COLS;j++)
        {
        if(grid[i][j]=='c') carrierParts++;
        }
       }
       carrierFound=true;
       }
        private void checkIfSubmarineFullyFound()
       {
         submarineFound=true;
       }
         public boolean isCarrierFound()
           {
            return carrierFound;
           }
        public boolean isSubmarineFound()
        {
          return submarineFound;
        }
       public boolean bothShipsFound()
        {
          return carrierFound && submarineFound;
        }
        public String getCarrierCoords()
        {
           return carrierCoords;
        }
         public String getSubmarineCoords()
         {
            return submarineCoords;
          }
}