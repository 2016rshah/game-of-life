public class Board{
   private Cell[][] board;
   private int rows;
   private int cols;
   
   public Board(int r, int c)
   {
      rows = r;
      cols = c;
      board = new Cell[rows][cols];
   }
   public Cell getCell(int r, int c)
   {
      return board[r][c];
   }
   public Cell setCell(int row, int col, Cell c)
   {
      board[row][col] = c;
      return board[row][col];
   }
   public int getRows(){
      return rows;
   }
   public int getCols(){
      return cols;
   }
   public void killCell(int i, int j)
   {
      this.getCell(i, j).kill();
   }
   public void reviveCell(int i, int j)
   {
      this.getCell(i, j).revive();
   }
   public void initialize()
   {
      for(int i = 0; i<this.getRows(); i++)
      {
         for(int j = 0; j<this.getCols(); j++)
         {
            this.setCell(i, j, new Cell(i, j, false));
         }
      }
   }
   public String toString()
   {
      String s = "";
      for(int i = 0; i<this.getRows(); i++)
      {
         for(int j = 0; j<this.getCols(); j++)
         {
            s = s + this.getCell(i, j).toString() + " ";
         }
         s = s + "\n";
      }
      return s;
   }
}