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
	def setCell(self, i, j, cell):
		self.board[i][j] = cell
	def withinBound(self, i, j):
		if(i<0 or i>self.rows or j<0 or j>self.cols):
			return False
		else:
			return True
	def calculateNeighbours(self, row, col):
		n = 0
		for i in range(-1, 2, 0):
			for j in range(-1, 2, 0):
				r = row + i 
				c = col + j
				if(self.withinBounds(r, c)):
					if(self.getCell(r, c).alive):
						n += 1 
		if this.getCell(row, col).alive:
			n -= 1
		self.getCell(row, col).neighbours = n
	def toggleAsNeeded(self):
		for i in range(self.rows):
			for j in range(self.cols):
				cell = this.getCell(i, j)
				n = cell.neighbours
				if(cell.alive):
					if(n<2 or n>3):
						self.killCell(i, j)
				else:
					if(n == 3):
						self.reviveCell(i, j)
