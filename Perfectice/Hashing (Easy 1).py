class Node :
	def __init__(self,value) :
		self.left=None
		self.right=None
		self.key=value
def traverseBST(root,val,nodeSet) :
	if root.left != None :
		nodeSet[root.left]=val-1
		traverseBST(root.left,val-1,nodeSet)
	if root.right !=None :
		nodeSet[root.right]=val+1
		traverseBST(root.right,val+1,nodeSet)

if __name__=="__main__":
	inpStr=[]
	inp=input().split(" ")
	while True:
		inpStr.append(inp[0])
		try :
			inp=input().split(" ")
		except EOFError :
			break
	count=0
	n=int(inpStr[count])
	count+=1
	arr=[]
	for i in range(0,n) :
		arr.append(inpStr[count])
		arr.append(inpStr[count+1])
		arr.append(inpStr[count+2])
		count+=3
	root = None
	nodeMap={}
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

	nodeSet={}
	if root != None :
		nodeSet[root]=0
		traverseBST(root,0,nodeSet)
	valList=nodeSet.values()
	s=[(k, nodeSet[k]) for k in sorted(nodeSet, key=nodeSet.get)]
	prev = min (valList)
	for k,v in s :
		if prev != v :
			print("$",end=" ")
			prev=v
		print(k.key,end=" ")
	print("$")

