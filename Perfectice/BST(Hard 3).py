class Node:
	def __init__(self,value):
		self.left=None
		self.right=None
		self.key=value
def insertBST(root,key):
	node=Node(key)
	if root==None:
		return node
	if root.key>key :
		root.left=insertBST(root.left,key)
	else :
		root.right=insertBST(root.right,key)
	return root
def findPair(root,rootSum,nodeSet):
	if root==None :
		return False
	if findPair(root.left,rootSum,nodeSet) :
		return True
	diff=(nodeSum-root.key)
	if diff in nodeSet :
		print("Pair found","(",end="")
		print(min(diff,root.key),end="")
		print(",",max(diff,root.key),end="")
		print(")")
		return True
	else :
		nodeSet.add(root.key)
	return findPair(root.right,rootSum,nodeSet)
if __name__ == "__main__" :
	inpStr=[]
	inp=input().split(" ")
	while True :
		inpStr.append(inp[0])
		try :
			inp=input().split(" ")
		except EOFError :
			break
	count=0
	n=int(inpStr[count])
	count+=1
	nodeList=[]
	for i in range(0,n) :
		nodeList.append(inpStr[count])
		count+=1
	nodeSum=int(inpStr[count])
	count+=1
	root=None
	for x in nodeList :
		root=insertBST(root,int(x))
	nodeSet=set([])
	if not findPair(root,nodeSum,nodeSet) :
		print("Pairs do not exist")