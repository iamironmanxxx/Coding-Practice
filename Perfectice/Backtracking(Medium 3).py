def DFS(ar, s):
	global pointer
	global freq
	flag=0
	for x in freq:
		if x==0 :
			flag=1
			break
	if flag==0 :
		pointer=1
	else :
		for x in ar[s] :
			if freq[x]==0 :
				freq[x]=1
				DFS(ar,x)
				freq[x]=0
if __name__=="__main__":
	global freq
	global pointer
	pointer=0
	freq=[]
	ar=[]
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
	m=int(inpStr[count])
	count+=1
	for i in range(0,n):
		freq.append(0)
		ar.append([])
	for i in range(0,m):
		a=int(inpStr[count])
		b=int(inpStr[count+1])
		count+=2
		a-=1
		b-=1
		ar[a].append(b)
		ar[b].append(a)


	freq[0]=1
	DFS(ar,0)
	print(pointer)