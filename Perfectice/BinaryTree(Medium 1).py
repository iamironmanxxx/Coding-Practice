import queue
class Node :
	def __init__(self,value):
		self.left=None
		self.right=None
		self.key=value
def levelOrder(root) :
	q=queue.Queue()  
	q.put(root)
	while not q.empty():
		u=q.get()
		print(u.key,end= " ")
		if u.left != None:
			q.put(u.left)
		if u.right != None :
			q.put(u.right)
if __name__=="__main__" :
	n=int(input())
	inpData=[]
	inpStr=input().split(" ")
	while inpStr[0] != "\n" :
		inpData.append(inpStr[0])
		try :
			inpStr=input().split(" ")
		except EOFError :
			break

	root=None
	nodeSet={}
	for i in range(0,n) :
		x=int(inpData[3*i])
		if nodeSet.get(x)==None :
			parent=Node(x)
			nodeSet[x]=parent
			if root==None :
				root=parent
		else :
			parent=nodeSet[x]
		y=int(inpData[3*i+1])
		if nodeSet.get(y)==None :
			child=Node(y)
			nodeSet[y]=child
		else: 
			child=nodeSet[y]
		ch=str(inpData[3*i+2])
		if(ch=="L") :
			parent.left=child
		else :
			parent.right=child
	levelOrder(root)