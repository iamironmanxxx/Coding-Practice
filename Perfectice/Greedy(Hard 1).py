
def dfs(w) :

	global cd
	global wt
	global ans

	if cd[w]==0 :
		return w
	if wt[w]<ans :
		ans=wt[w]
	return dfs(cd[w])
def solve (ar,n,m) :

	global rd
	global cd
	global wt
	global ans
	global a
	global b
	global c

	i=0
	while i< m :
		q=ar[i][0]
		h=ar[i][1]
		t=ar[i][2]

		cd[q]=h
		wt[q]=t
		rd[h]=q

		i+=1

	a=[]
	b=[]
	c=[]

	for i in range(1,n+1) :
		if rd[i]==0 and cd[i]>0 :
			ans=1000000000
			w=dfs(i)
			a.append(i)
			b.append(w)
			c.append(ans)
	print(len(a))
	for j in range(0,len(a)) :
		print(str(a[j])+" "+str(b[j])+" "+str(c[j]))


if __name__=="__main__" :

	global rd
	global cd
	global wt
	global ans
	global a
	global b
	global c

	rd=[]
	cd=[]
	wt=[]
	for i in range(0,1100) :
		rd.append(0)
		cd.append(0)
		wt.append(0)

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
	m=int(inpStr[count+1])
	count+=2
	ar=[]
	for i in range (0,m) :
		a=int(inpStr[count])
		b=int(inpStr[count+1])
		d=int(inpStr[count+2])
		count+=3
		ar.append([a,b,d])

	solve (ar,n,m)