#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define pb push_back
#define limit 1000000002
void init(int f[],int n)
{
	for(int i=0;i<n;i++)
	{
		f[i]=0;
	}
}
int main() 
{
	vector<int> primes;
	int lim=(int)sqrt(limit);
	int f[lim+1];
	init(f,lim+1);
	for(int i=3;i<=sqrt(lim);i+=2)
	{
		if(f[i]==0)
		{
			for(int j=i*i;j<=lim;j+=2*i)
			{
				f[j]=1;
			}
		}
	}
	primes.pb(2);
	for(int i=3;i<lim+1;i+=2)
	{
		if(f[i]==0)
		{
			primes.pb(i);
		}
	}



	int t;
	cin>>t;
	while(t--)
	{
		int m,n;
		cin>>m>>n;
		int ar[n-m+1];
		init(ar,n-m+1);
		for(int i=m;i<=n;i++)
		{
			if(i!=2&&i%2==0)
			{
				ar[i-m]=1;
			}
		}
		for(int i=0;(i<primes.size()&&primes[i]<=n);i++)
		{
			int prime=primes[i];
			for(int j=m;j<=n;j++)
			{
				if(prime==j)
					continue;
				//pw.println("No. "+j);
				if(j%prime==0||j==1)
				{
					ar[j-m]=1;
				}
			}
		}
		for(int i=0;i<n-m+1;i++)
		{
			if(ar[i]==0)
			{
				printf("%d\n",(i+m));
			}
		}
		printf("\n");
	}
}
