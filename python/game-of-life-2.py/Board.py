from Cell import *
class Board(object):
	def __init__(self, r, c):
		self.rows = r
		self.cols = c
		self.board = []
	def __repr__(self):
		s = ""
		for i in range(self.rows):
			for j in range(self.cols):
				s+=self.board[i][j].__repr__() + " "
			s+="\n"
		return s
	def makeEmptyBoard(self):
		for i in range(self.rows):
			self.board.append([])
		for i in range(self.rows):
			for j in range(self.cols):
				self.board[i].append(Cell(i, j))
	def killCell(self, i, j):
		self.board[i][j].alive = False
	def reviveCell(self, i, j):
		self.board[i][j].alive = True
"""
	To Do:
		check if in bounds method for coordinates
		calculate all neighbours of one cell
		toggleAsNeeded method
"""