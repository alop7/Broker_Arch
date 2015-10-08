
class View:
	vals = [34,2,10]	
	
	def __init__(self, n):
		self.name = n
		
	def __str__(self):
		return self.name

	def update(self,value):
		self.vals.append(value)
	
	def getVals(self):
		return self.vals

view1 = View("lel")
print(str(view1))
print(view1.getVals())

view1.update(99)
print(view1.getVals())
