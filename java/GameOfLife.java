public class GameOfLife{
   public static void main(String[] args){
      System.out.println("Hello World");
      Board board = new Board(5, 5);
      board.initialize();
	  board.reviveCell(2, 3);
      System.out.println(board);
   }
}