class Node: 
	def __init__(self,val) :
		self.left=None
		self.right=None
		self.val=val
def inorder(root) :
	if root!=None :
		inorder(root.left)
		print(root.val,end=" ")
		inorder(root.right)
def traverseTree(root,sec) :
	if root==None or root.left ==None and root.right==None :
		return 
	nextNode=None
	comp=None

	if root.left.val==root.val :
		nextNode=root.left
		comp=root.right
	else :
		nextNode=root.right
		comp=root.left
	if comp.val<sec[0] :
		sec[0]=comp.val
	traverseTree(nextNode,sec)
def buildTournamentTree(arr) :
	MAX=1000000001
	if len(arr)==1 :
		print(arr[0])
		print("There is no second minimum")
		return
	ls=[]
	root=None
	for i in range(0,len(arr),2) :
		t1=Node(arr[i])
		t2=None
		if i+1<len(arr) :
			t2=Node(arr[i+1])
			if arr[i]<arr[i+1] :
				root=Node(arr[i])
			else: 
				root=Node(arr[i+1])
			root.left=t1
			root.right=t2
			ls.append(root)
		else :
			ls.append(t1)
	size=len(ls)
	while size>1 :
		for i in range(0,size,2) :
			t1=ls.pop()
			t2=None
			if i+1<size :
				t2=ls.pop()
				if t1.val<t2.val :
					root=Node(t1.val)
				else :
					root=Node(t2.val)
				root.left=t1
				root.right=t2
				ls.append(root)
			else :
				ls.append(t1)
		size=len(ls)
	firstMin=ls[0].val
	secMin=[MAX]
	traverseTree(root,secMin)
	if firstMin==secMin[0] :
		print("First min:",firstMin)
		print("There is no second minimum")
	else :
		print("Minimum:",firstMin,end="")
		print(", Second minimum:",secMin[0])

if __name__=="__main__" :
	inpStr=[]
	inp=input().split(" ")
	while True :
		inpStr.append(inp[0])
		try:
			inp=input().split(" ")
		except EOFError :
			break
	n=int(inpStr[0])
	arr=[]
	for i in range(1,n+1) :
		arr.append(int(inpStr[i]))
	buildTournamentTree(arr)