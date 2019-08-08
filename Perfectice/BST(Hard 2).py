class Node :
	def __init__(self,key) :
		self.left=None
		self.right=None
		self.key=key
def insert(root, key) :
	if root==None :
		root=Node(key)
	elif root.key>=key :
		root.left=insert(root.left,key)
	else :
		root.right=insert(root.right,key)
	return root
def distanceRoot(root ,a) :
	if root.key==a :
		return 0
	elif root.key>a:
		return 1+distanceRoot(root.left,a)
	return 1+distanceRoot(root.right,a)

def distance(root ,a,b) :
	if root==None :
		return 0
	if root.key>a and root.key>b :
		return distance(root.left,a,b)
	if root.key <a and root.key<b :
		return distance(root.right,a,b)
	if root.key>=a and root.key<=b :
		return distanceRoot(root,a)+distanceRoot(root,b)
	else :
		return 0
def findDist(root,a,b) :
	if a>b :
		temp=a
		a=b
		b=temp
	return distance(root,a,b)
def inorder(root) :
	if root!=None :
		inorder(root.left)
		print(root.key)
		inorder(root.right)
if __name__=="__main__" :
	root=None
	inpStr=[]
	inp=input().split(" ")
	while True :
		inpStr.append(inp[0])
		try:
			inp=input().split(" ")
		except EOFError :
			break
	n=int(inpStr[0])
	count=1
	for i in range(0,n) :
		root=insert(rooot,int(inpStr[count]))
		count+=1
	a=int(inpStr[count])
	b=int(inpStr[count+1])

	print(findDist(root,a,b))