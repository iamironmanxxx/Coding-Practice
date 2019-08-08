import queue
class Node:
	def __init__(self,value):
		self.left=None
		self.right=None
		self.key=value

def traverseInorder(root):
	cur=root
	s=[]
	while not cur == None or not len(s)==0 :
		while not cur == None :
			s.append(cur)
			cur=cur.left
		cur=s.pop()
		print(cur.key,end=" ")
		cur=cur.right
if __name__ == '__main__':

	n = int(input())
	arr=[]
	inpStr=input().split(" ")
	while inpStr[0]!="\n" :
		arr.append(inpStr[0])
		try:
			inpStr=input().split(" ")
		except EOFException:
			break
	nodeMap={}
	#print(arr)
	root=None
	for i in range(0,n):
		x=int(arr[3*i])
		if nodeMap.get(x)==None :
			nodeMap[x]=Node(x)
			if root==None :
				root=nodeMap[x]
		parent=nodeMap[x]
		y=int(arr[3*i+1])
		if nodeMap.get(y)==None :
			nodeMap[y]=Node(y)
		child=nodeMap[y]
		ch=str(arr[3*i+2]) 
		if ch=="L" :
			parent.left=child
		else :
			parent.right=child 
	traverseInorder(root) 
	print('')