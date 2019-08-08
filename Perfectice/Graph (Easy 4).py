import queue
class Node :
	def __init__(self,a,b) :
		self.jug1=a#contents of 3 gallon jug
		self.jug2=b#contents of 4 gallon jug

def BFS(node,dest) :
	jug1Max=3
	jug2Max=4
	visited={}
	q=queue.Queue()
	q.put(node)
	while not q.empty() :
		u=q.get()
		v=None
		if u.jug2==dest.jug2 :
			print(u.jug1,u.jug2)
			break
		#fill 4 gallon jug
		if u.jug2<jug2Max :
			v=Node(u.jug1,jug2Max)
		#fill 3 gallon jug
		if u.jug1<jug1Max :
			v=Node(jug1Max,u.jug2)
		#transfer 4 gallon to 3 gallon
		#keep remaining
		v=Node()
		q.add(v)

if __name__ =="__main__" :
	# -1 means the content of 3 gallon
	#jug does'nt matter
	dest=Node(-1,2)
	node=Node(3,0)
	BFS(node,dest)
	node=Node(0,4)
	BFS(node,dest)