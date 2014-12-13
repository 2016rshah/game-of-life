public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;

	public Board(int r, int c) {
		rows = r;
		cols = c;
		board = new Cell[rows][cols];
	}
	public Cell getCell(int r, int c) {
		return board[r][c];
	}
	public Cell setCell(int row, int col, Cell c) {
		board[row][col] = c;
		return board[row][col];
	}
	public int getRows() {
		return rows;
	}
	public int getCols() {
		return cols;
	}
	public void killCell(int i, int j) {
		this.getCell(i, j).kill();
	}
	public void reviveCell(int i, int j) {
		this.getCell(i, j).revive();
	}
	public void initialize() {
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				this.setCell(i, j, new Cell(i, j, false));
			}
		}
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				s = s + this.getCell(i, j).toString() + " ";
			}
			s = s + "\n";
		}
		return s;
	}

	public void calcNeighboursOfCell(int row, int col) 
	{
		int n = 0;
		for(int i = -1; i<=1; i++)
		{
			for(int j = -1; j<=1; j++)
			{
				int r = row+i; 
				int c = col+j;
				if(this.withinBounds(r, c))
				{
					if(this.getCell(r, c).getAlive())
					{
						n++;
					}
				}
			}
		}
		if(this.getCell(row, col).getAlive())
			n = n - 1;
		this.getCell(row, col).setNeighbours(n);
	}
	public boolean withinBounds(int r, int c)
	{
		if(r<0 || c<0 || r>=rows || c>=cols)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void toggleAllAsNeeded()
	{
		for(int i = 0; i<this.getRows(); i++)
		{
			for(int j = 0; j<this.getCols(); j++)
			{
				Cell cell = this.getCell(i, j);
				int n = cell.getNeighbours();
				if(cell.getAlive()) //cell is alive
				{
					if(n<2)
						cell.kill();
					else if(n>3)
						cell.kill();
				}
				else //cell is dead
				{
					if(n == 3)
						cell.revive();
				}
				this.setCell(i, j, cell);
			}
		}
	}
}