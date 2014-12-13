public class GameOfLife{
	public static void main(String[] args){
		System.out.println("Hello World");
		Board board = new Board(10, 10);
		board.initialize();
		board = glider(board);
		System.out.println(board); //initial board
		
		for(int i = 0; i<5; i++)
		{
			board = nextGeneration(board);
			System.out.println(board);
		}
	}
	
	public static Board glider(Board board)
	{
		board.reviveCell(1, 2);
		board.reviveCell(2, 3);
		board.reviveCell(3, 1);
		board.reviveCell(3, 2);
		board.reviveCell(3, 3);
		return board;
	}
	public static Board nextGeneration(Board board)
	{
		board = calcAllNeighbours(board);
		board.toggleAllAsNeeded();
		return board;
	}
	public static Board calcAllNeighbours(Board board)
	{
		for(int i = 0; i<board.getRows(); i++)
		{
			for(int j = 0; j<board.getCols(); j++)
			{
				board.calcNeighboursOfCell(i, j);
				// System.out.print(board.getCell(i, j).getNeighbours() + " ");
			}
			// System.out.println();
		}	
		// System.out.println();
		return board;
	}
}