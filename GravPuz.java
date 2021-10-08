class GravPuz
{
  private String[][] board;
  //precondition for param: must be a square and have odd number of rows/cols
  public GravPuz(String[][] b)
  {
    board = b;
  }
  //prints the board
  public void printBoard()
  {
    for(int row = 0; row<board[0].length;row++)
    {
      for(int col = 0;col<board[0].length;col++)
      {
        System.out.print(board[row][col] + " ");
      }
      System.out.println();
    }
  }

  //rotates board clockwise
  public void rotateClock()
  {
    int len = board[0].length;
    String[][] temp = new String[len][len];
    for(int i = 0; i < len; i++)
    {
      for(int j = 0; j < len; j++)
      {
        temp[j][len-(1+i)] = board[i][j];
      }
    }

    for(int row = 0; row<len;row++)
    {
      for(int col = 0;col<len;col++)
      {
        board[row][col] = temp[row][col];
      }
    }
    physics();
  }

  
  //rotates board counterclockwise by setting the reverse of row 1 to column 1, reverse of row 2 to column row 2...
  public void rotateCounter()
  {
    int len = board[0].length;
    String[][] temp = new String[len][len];
    for(int i = 0; i<len; i++)
      {
        for(int j = len-1; j>-1; j--)
        {
          temp[len-(j+1)][i]=board[i][j];
        }
      }
  //set temp to board
      for(int row = 0; row<len;row++)
      {
        for(int col = 0;col<len;col++)
        {
          board[row][col] = temp[row][col];
        }
      }
      physics();
  }
    public void physics()
    {
      int len = board[0].length;
      String ac =" ";
      int x = -1;
      int y = -1;
      for(int row = 0; row<len;row++)
      {
        for(int col = 0;col<len;col++)
        {
          if(board[row][col].equals("o"))
          {
            x = row;
            y = col;
          }
        }
        if(!(x == -1))
        {break;}
      }
      board[x][y] = " ";
      while(!(board[x+1][y].equals("□")))
      {
        x+=1;
      }
      board[x][y] = "o";


    }
    //can be modified for a win condition
    public boolean winCheck()
        {
      for(String[] r : board)
      {
        for (String element : r)
        {
          if (element.equals("X"))
          {
            return false;
          }
        }
      }
      return true;
    }
}