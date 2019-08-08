import queue
class Node :
	def __init__(self,value):
		self.left=None
		self.right=None
		self.key=value
def levelOrder(root) :
	q=queue.Queue()  
	q.put(root)
	flag=0
	while not q.empty():
		u=q.get()
		if u.key==-1 :
			flag=0
			print("$",end=" ")
		else :
			print(u.key,end= " ")
		if u.left != None:
			if flag==0 :
				q.put(Node(-1))
				flag=1	
			q.put(u.left)
		if u.right != None :
			if flag==0 :
				q.put(Node(-1))
				flag=1
			q.put(u.right)
	print("$")
if __name__=="__main__" :
	n=int(input())
	inpData=[]
	inpStr=input().split(" ")
	while inpStr[0]!="\n" :
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