class Node :
	def __init__(self,data):
		self.next=None
		self.data=data
def insert(root,data):
	global tail
	node=Node(data)
	if root==None:
		root=node
		tail=node
	else :
		tail.next=node
		tail=node
	return root

def remove(root,position):
	global tail
	position-=1
	if position==0 :
		if root==tail :
			root=None
			tail==None
		else :
			root=root.next
	else :
		count=0
		temp=root
		while temp.next!=None and count<position-1 :
			temp=temp.next
			count+=1
		if temp.next==None :
			tail=temp
			temp.next=None
		else:
			temp.next=temp.next.next
	return root


if __name__=="__main__" :
	global root
	global tail
	root=None
	tail=None
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
	for i in range(0,n) :
		root=insert(root,int(inpStr[count]))
		count+=1

	temp=root
	key=int(inpStr[count])
	root=remove(root,key)

	temp=root
	while temp!=None :
		print(temp.data,end=" ")
		temp=temp.next