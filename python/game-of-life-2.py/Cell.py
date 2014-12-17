from Board import *

class Cell(object):
	def __init__(self, r, c, a = False):
		self.row = r
		self.col = c
		self.alive = a
		self.neighbours = -1
	def __repr__(self):
		if self.alive:
			return str(1)
		else:
			return str(0)

#cell class is done.
