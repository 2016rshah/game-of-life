#imports
from Board import Board
from Cell import Cell

def main():
	board = Board(10, 10)
	board.makeEmptyBoard()
	print(board)
	board.reviveCell(1, 1)
	board.reviveCell(3, 2)
	print(board)


main()

"""

Basically everything. Look at GameOfLife.java for check list

"""