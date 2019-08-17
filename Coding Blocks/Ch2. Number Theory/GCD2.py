t=int(input())
def gcd(a,b) :
	if(b==0) :
		return a
	else :
		return gcd(b,a%b)
for x in range(0,t) :
	inp=input().split(" ")
	a=int(inp[0])
	b=int(inp[1])
	print(gcd(a,b))
