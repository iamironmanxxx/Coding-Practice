def compareFunc(a,b):
	global freq
	if freq[a]<freq[b]:
		return -1
	elif freq[a]>freq[b]:
		return 1
	else:
		if a<b :
			return -1
		elif a>b:
			return 1
		return 0 
def cmp_to_key(mycmp):
    'Convert a cmp= function into a key= function'
    class K:
        def __init__(self, obj, *args):
            self.obj = obj
        def __lt__(self, other):
            return mycmp(self.obj, other.obj) < 0
        def __gt__(self, other):
            return mycmp(self.obj, other.obj) > 0
        def __eq__(self, other):
            return mycmp(self.obj, other.obj) == 0
        def __le__(self, other):
            return mycmp(self.obj, other.obj) <= 0
        def __ge__(self, other):
            return mycmp(self.obj, other.obj) >= 0
        def __ne__(self, other):
            return mycmp(self.obj, other.obj) != 0
    return K
if __name__=="__main__":
	global freq
	inpStr=[]
	inp=input().split(" ")
	while True :
		inpStr.append(inp[0])
		try :
			inp=input().split()
		except EOFError :
			break
	count=0
	n=int(inpStr[count])
	count+=1
	arr=[]
	for i in range(0,n):
		arr.append(inpStr[count])
		count+=1
	freq={}
	for x in arr :
		if freq.get(x)==None :
			freq[x]=1
		else :
			freq[x]+=1

	arr=sorted(arr,key=cmp_to_key(compareFunc),reverse=True)
	for x in arr :
		print(x,end=" ")