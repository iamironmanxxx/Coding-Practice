import queue
class Node:
	def __init__(self,value):
		self.left=None
		self.right=None
		self.key=value
def insert(root,node):
	q=queue.Queue()
	q.put(root)
	while not q.empty():
		u=q.get()
		if u.left==None :
			u.left=node
			break
		else :
			q.put(u.left)
		if u.right == None :
			u.right= node
			break
		else :
			q.put(u.right)

def traverseInorder(root):
	if root is not None:
		traverseInorder(root.left) 
		print(root.key, end=" ") 
		traverseInorder(root.right)
if __name__ == '__main__':

	n = int(input())
	arr=input().split(" ")
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
	key=int(input())
	insert(root, Node(key)) 
	traverseInorder(root) 
	print('')