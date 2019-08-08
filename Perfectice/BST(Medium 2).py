class Node :
	def __init__(self,key) :
		self.left=None
		self.right=None
		self.key=key
def lca(node,n1,n2) :
	if node==None :
		return None
	if node.key>n1 and node.key>n2 :
		return lca(node.left,n1,n2)
	if node.key<n1 and node.key<n2 :
		return lca(node.right,n1,n2)
	return node
def insert(root,key) :
	if root==None :
		root=Node(key)
	elif root.key>=key :
		root.left=insert(root.left,key)
	else :
		root.right=insert(root.right,key)
	return root
if __name__=="__main__" :
	root=None
	root=Node(20)
	insert(root,8)
	insert(root,22)
	insert(root,4)
	insert(root,12)
	insert(root,10)
	insert(root,14)

	for i in range(0,3) :
		if i==0 :
			n1=10
		elif i==1 :
			n1=14
		else :
			n1=10
		if i==0 :
			n2=14
		elif i==1 :
			n2=8
		else :
			n2=22
		t=lca(root,n1,n2)
		print("LCA of",end="")
		print(str(n1),"and",n2,"is",t.key)