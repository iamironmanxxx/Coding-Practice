class Node :
	def __init__(self,value):
		self.left=None
		self.right=None
		self.key=value
def construct(root,key) :
	node=Node(key)
	if root==None :
		return node
	if key>root.key :
		root.right=construct(root.right,key)
	else :
		root.left=construct(root.left,key)
	return root 
def constructBST(bstList,n) :
	root=construct(None,bstList[0])
	for i in range (1,n) :
		construct(root,bstList[i])
	return root
def inorder(root) :
	if root != None :
		inorder(root.left)
		print(root.key, end= " ")
		inorder(root.right)
def printCommon(root1,root2) :
	stack1=[]
	stack2=[]
	while True :
		if root1!=None :
			stack1.append(root1)
			root1=root1.left
		elif root2 != None :
			stack2.append(root2)
			root2=root2.left
		elif not len(stack2)==0 and not len(stack1)==0 :
			root1=stack1[-1]
			root2=stack2[-1]
			if root1.key == root2.key :
				print(stack2[-1].key,end= " ")
				stack1.pop()
				stack2.pop()
				root1=root1.right
				root2=root2.right
			elif root1.key < root2.key :
				stack1.pop()
				root1=root1.right
				root2=None
			elif root1.key > root2.key:
				stack2.pop()
				root2=root2.right
				root1= None
		else : 
			break
if __name__=="__main__" :
	inpStr=[]
	inp=input().split(" ")
	while True :
		inpStr.append(inp[0])
		try :
			inp=input().split(" ")
		except EOFError :
			break
	count=0
	n1=int(inpStr[count])
	count+=1
	bstList1=[]
	for i in range(0,n1) :
		bstList1.append(inpStr[count])
		count+=1
	n2=int(inpStr[count])
	count+=1
	bstList2=[]
	for i in range(0,n2) :
		bstList2.append(inpStr[count])
		count+=1
	root1=constructBST(bstList1,n1)
	root2=constructBST(bstList2,n2)
	#inorder(root1)
	#inorder(root2)
	printCommon(root1,root2)