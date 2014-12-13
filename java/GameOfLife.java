public class GameOfLife{
    public static void main(String[] args){
        System.out.println("Hello World");
        Board board = new Board(10, 10);
        for(int i = 0; i<board.getRows(); i++)
        {
            for(int j = 0; j<board.getCols(); j++)
            {
                System.out.print(board.setCell(i, j, new Cell(i, j, false)) + "\t");
            }
            System.out.println();
        }
    }
}