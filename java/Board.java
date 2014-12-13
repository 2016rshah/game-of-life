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
}