class Node: 

	# Constructor to initialize the node object 
	def __init__(self, data): 
		self.data = data 
		self.next = None
		self.tail=None

class LinkedList: 

	def __init__(self): 
		self.head = None

	def push(self, new_data): 
		new_node = Node(new_data)
		if self.head==None :
			self.head=new_node
			self.tail=new_node
		else :
			self.tail.next=new_node
			self.tail=new_node

	def deleteNode(self, position): 
		position-=1
		# If linked list is empty 
		if self.head == None: 
			return

		# Store head node 
		temp = self.head 

		# If head needs to be removed 
		if position == 0: 
			self.head = temp.next
			temp = None
			return

		# Find previous node of the node to be deleted 
		for i in range(position -1 ): 
			temp = temp.next
			if temp is None: 
				break

		# If position is more than number of nodes 
		if temp is None: 
			return
		if temp.next is None: 
			return

		next = temp.next.next

		temp.next = None

		temp.next = next


	def printList(self): 
		temp = self.head 
		while(temp): 
			print(temp.data, end =" ") 
			temp = temp.next


# Driver program to test above function 
llist = LinkedList() 
n = int(input())

for i in range(n):
    x = int(input())
    llist.push(x) 
    
key = int(input())

llist.deleteNode(key) 
llist.printList() 
