primes = [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,
          79,83,89,97,101]
for _ in range(0,20):
	n = int(input())
	px = 1
	for p in primes:
		if px*p > n: break
		px*=p
	print (px) 