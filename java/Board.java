public class Board{
    private int[][] board;
    private int rows;
    private int cols;
    
    public Board(int r, int c){
        rows = r;
        cols = c;
        board = new int[rows][cols];
    }
}