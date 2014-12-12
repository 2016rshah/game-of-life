

class Cell(object):
	def __init__(self, row, col, alive = False):
		self.alive = alive
		self.row = row
		self.col = col
	def __repr__(self):
		if self.alive:
			return str(1)
		else:
			return str(0)
	def addBoardReference(self, board):
		self.board = board
		return self
	def neighboursAndCheck(self):
		self.aliveNeighbours = self.calcNeighbours()
		return self.shouldBeAlive()
	def shouldBeAlive(self):
		aliveN = self.aliveNeighbours
		if(self.alive):
			if(aliveN < 2):
				# print("cut off at ", self.row, self.col)
				return False
			elif(aliveN > 3):
				print("killed 2", self.row, self.col)
				return False
			else:
				return True
		elif(not self.alive):
			if(aliveN == 2):
				# print("back at ", self.row, self.col)
				return True
			else:
				return False
	def calcNeighbours(self):
		aN = 0
		for i in range(-1, 2):
			if(i!=0):
				for j in range(-1, 2):
					if(j != 0): #not yourself
						r = self.row + i
						c = self.col +j
						if((r<self.board.height and c<self.board.width) and (r>-1 and c>-1)): #not to big or small indices
							if(self.board.board[self.row+i][self.col+j].alive):
								aN+=1
								# print("alive neighbour")
					# else:
					# 	print("made it through")
		return aN



from random import randint
from copy import deepcopy
class Board(object):
	def __init__(self, height, width):
		self.height = height
		self.width = width
		self.board = self.createRandomBoard()
		self.board = self.addBoardReferences()
	def __repr__(self):
		for i in range(self.height):
			for j in range(self.width):
				print(self.board[i][j], end = "\t")
			print("\n"*2)
		return ''
	def createRandomBoard(self):
		board = []
		for i in range(self.height):
			row = []
			for j in range(self.width):
				x = randint(1, 2)
				if(x == 1):
					# print("alive")
					row.append(Cell(i, j, True))
				else:
					row.append(Cell(i, j, False))
			board.append(row)
		return board
	def createEmptyBoard(self):
		board = []
		for i in range(self.height):
			row = []
			for j in range(self.width):
				x = randint(1, 2)
				if(x == 1):
					# print("alive")
					row.append(Cell(i, j, True))
				else:
					row.append(Cell(i, j, False))
			board.append(row)
		return board
	def addBoardReferences(self):
		for i in range(self.height):
			for j in range(self.width):
				self.board[i][j] = self.board[i][j].addBoardReference(self)
		return self.board
	def runGeneration(self):
		# newBoard = deepcopy(self.board)
		newBoard = self.board
		for i in range(self.height):
			for j in range(self.width):
				newBoard[i][j].alive = self.board[i][j].neighboursAndCheck()
		# self.board = deepcopy(newBoard)
		self.board = newBoard
		return self




# HEIGHT = int(input("Height of board: "))
# WIDTH = int(input("Width of board: "))
HEIGHT = 10
WIDTH = 10
board = Board(HEIGHT, WIDTH)
import time
while(True):
	print("\n"*50, board)
	board = board.runGeneration()
	time.sleep(.5) # delays for 5 seconds
