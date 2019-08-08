import queue
def BFS(a,b,target) :
	m=set([])
	isSolvable=False
	path=[]
	q=queue.Queue()
	q.put((0,0))
	while not q.empty() :
		u=q.get()
		if u in m :
			continue
		if u[0]>a or u[1]>b or u[0]<0 or u[1]<0 :
			continue
		path.append(u)
		m.add(u)
		if u[0]==target or u[1]==target :
			isSolvable=True
			if u[0]==target :
				if u[1]!=0 :
					path.append((u[0],0))
			else: 
				if u[0]!=0 :
					path.append((0,u[1]))
			sz=len(path)
			for i in range(0,sz) :
				print("(",end="")
				print(path[i][0],end="")
				print(",",end=" ")
				print(path[i][1],end="")
				print(")")
			break
		q.put((u[0],b))
		q.put((a,u[1]))
		for ap in range(0,max(a,b)) :
			c=u[0]+ap
			d=u[1]-ap

			if c==a or (d==0 and d>=0) :
				q.put((c,d))
			c=u[0]-ap
			d=u[1]+ap
			if (c==0 and c>=0) or d==b :
				q.put((c,d))

		q.put((a,0))
		q.put((0,b))

if __name__=="__main__" :
	jug1=4
	jug2=3
	target=2
	print("Path from initial state to solution state :")
	BFS(jug1,jug2,target)
