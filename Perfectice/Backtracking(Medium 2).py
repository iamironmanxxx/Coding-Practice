def checkPallindrome(string) :
	l=len(string)
	l-=1
	for i in range(0,l):
		if string[i]!=string[l] :
			return False
		l-=1
	return True
def printSolution(partitions) :
	for x in partitions :
		for j in x :
			print(j,end=" ")
		print()
def addStrings(v,s,temp,index) :
	l=len(s)
	string=""
	current=[]
	for x in temp :
		current.append(x)
	if index==0 :
		temp=[]

	for i in range(index,l) :
		string=string+s[i]
		if checkPallindrome(string) :
			temp.append(string)
			if i+1<l :
				v=addStrings(v,s,temp,i+1)
			else :
				v.append(temp)
			temp=[]
			for x in current :
				temp.append(x)
	return v

def partition(s ,v) :
	temp=[]
	v=addStrings(v,s,temp,0)
	printSolution(v)
if __name__=="__main__" :
	partitions=[]
	s=input()
	partition(s,partitions)