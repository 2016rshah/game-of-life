import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GOLPanel extends JPanel implements FocusListener, KeyListener, ActionListener, MouseListener {
	private MosaicPanel arena;  
	                            
	
	private JLabel message;   

	private Timer timer;  
	
	private final static int ROWS = 60;         // Number of rows in the arena.
	private final static int COLUMNS = 80;      // Number of columns in the arena.
	private final static int BLOCKSIZE = 10;    // Size of each square in the arena-- used only in creating the arena object.
	private final static int BORDER_WIDTH = 5;  // The width of the colored border around the arena.
	public FocusEvent v;
	private Board board = new Board(ROWS, COLUMNS);
	
	public GOLPanel() 
	{
		setFocusable(true);
		arena = new MosaicPanel(ROWS, COLUMNS, BLOCKSIZE, BLOCKSIZE, Color.WHITE, BORDER_WIDTH);
		message = new JLabel("To Start, Click the Arena", JLabel.CENTER);
		message.setBackground(Color.LIGHT_GRAY);
		message.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		bottom.setBackground(Color.LIGHT_GRAY);
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(3,3));
		bottom.add(message,BorderLayout.CENTER);

		add(bottom, BorderLayout.SOUTH);
		add(arena, BorderLayout.CENTER);
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
		arena.setGroutingColor(null);
		arena.addFocusListener(this);
		arena.addKeyListener(this);
		arena.addMouseListener(this);
		message.addMouseListener(this);
		
				
		
		
		
		
		System.out.println("Hello World");
		board.initialize();
		board = this.glider(board, 1, 1);
		board = this.glider(board, 20, 20);
		board = this.glider(board, 40, 34);
		board.reviveCell(29, 10);
		board.reviveCell(29, 11);
		board.reviveCell(29, 12);
		//System.out.println(board); //initial board
		
		
		
		
		
		
		
	}
	
	
	public Board glider(Board board, int initialI, int initialJ)
	{
		board.reviveCell(initialI + 1, initialJ + 2);
		board.reviveCell(initialI + 2, initialJ + 3);
		board.reviveCell(initialI + 3, initialJ + 1);
		board.reviveCell(initialI + 3, initialJ + 2);
		board.reviveCell(initialI + 3, initialJ + 3);
		return board;
	}
	public Board nextGeneration(Board board)
	{
		board = calcAllNeighbours(board);
		board.toggleAllAsNeeded();
		return board;
	}
	public Board calcAllNeighbours(Board board)
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
	public void displayBoard()
	{
		for(int i = 0; i<board.getRows(); i++)
		{
			for(int j = 0; j<board.getRows(); j++)
			{
				if(board.getCell(i, j).getAlive())
				{
					arena.setHSBColor(i, j, 1, 1, 1);
				}
			}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		board = this.nextGeneration(board);
		arena.fill(null);//reset all cells to black
		this.displayBoard();
		//System.out.println(board);
	}
	
	
	
	public void focusGained(FocusEvent v) 
	{
		arena.setBorder(BorderFactory.createLineBorder(Color.CYAN, BORDER_WIDTH));
		arena.fill(null);  // This resets all the squares to black to erase the picture from the previous run.
// 		arena.setColor(currentRow,currentColumn,255,(int)(Math.random()*19),0);  // color first square red
// 		arena.setColor(currentRow, currentColumn, (int)(Math.random()*18), 0, 0);
		message.setText("Welcome to the Game of Life");
		
		
		
		
		timer = new Timer(50,this); // timer generates an ActionEvent every 50 milliseconds
		timer.start();
	}

	/**
	 * This method is called when the arena loses focus, which means that it will not
	 * receive Key events.  When this happens, the game is suspended (by turning off 
	 * the timer that drives the game), the color of the arena's border is changed to
	 * gray, and the text of the message is changed.
	 */
	public void focusLost(FocusEvent e) 
	{
		arena.setBorder(BorderFactory.createLineBorder(Color.GRAY, BORDER_WIDTH));
		if (timer != null)
			timer.stop();
		timer = null;
		message.setText("To START, Click the Arena");
		
			
	}
	/**
	 * Mouse clicks on the arena and on the message are simply used to move the focus to
	 * the component that was clicked.  (The point of giving the focus to the message is
	 * simply to make the arena lose focus, which causes the game to be paused.)
	 */
	public void mousePressed(MouseEvent e) 
	{
		if (e.getSource() == arena)
			arena.requestFocus();
		else
			message.requestFocus();
	}
	public void keyPressed(KeyEvent e) {}
	//public void focusGained(FocusEvent v) {}
	//public void focusLost(FocusEvent e) {}
	// public void mousePressed(MouseEvent e){}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}