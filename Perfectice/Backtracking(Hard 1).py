class Node :
	def __init__(self,x,y):
		self.x=x
		self.y=y
def DFS(ar,x,y,pathStr) :
	global strList
	global n
	global visited
	if strList==None :
		strList=[]
	if x!=n-1 or y!=n-1 :
		if x+1<n and visited[x+1][y]==0 and ar[x+1][y]=="1":
			visited[x+1][y]=1
			DFS(ar,x+1,y,pathStr+"D")
			visited[x+1][y]=0
		if y+1<n and visited[x][y+1]==0 and ar[x][y+1]=="1":
			visited[x][y+1]=1
			DFS(ar,x,y+1,pathStr+"R")
			visited[x][y+1]=0
	else :
		strList.append(pathStr)


if __name__=="__main__":
	global n
	global visited
	global strList
	strList=None
	#inpStr=[]
	#inp=input().split(" ")
	#while True :
	#	inpStr.append(inp[0])
	#	try :
	#		inp=input().split(" ")
	#	except EOFError :
	#		break
	#count=0
	#n=int(inpStr[count])
	#count+=1
	#ar=[]
	#visited=[]
	#for i in range(0,n) :
	#	arList=[]
	#	vis=[]
	#	for j in range(0,n) :
	#		arList.append(inpStr[count])
	#		vis.append(0)
	#		count+=1
	#	ar.append(arList)
	#	visited.append(vis)

	DFS(ar,0,0,"")
	for x in strList :
		print(x,end= " ")