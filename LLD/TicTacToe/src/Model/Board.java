package Model;


public class Board {
    public int size;
   public PlayingPiece[][] board;
   public Board(int size)
   {
       this.size=size;
       board=new PlayingPiece[size][size];
   }
   public boolean addPiece(PlayingPiece playingPiece,int row,int column)
   {
       if(board[row][column]!=null)
       {
           return false;
       }
       else
       {
           board[row][column]=playingPiece;
       }
       return true;
   }
  public void printBoard()
  {

      for (int i = 0; i < size; i++) {
          for (int j = 0; j < size; j++) {
              if (board[i][j] != null) {
                  System.out.print(board[i][j].playingPieceType.name() + "   ");
              } else {
                  System.out.print("    ");

              }
              System.out.print(" | ");
          }
          System.out.println();

      }
  }
}
