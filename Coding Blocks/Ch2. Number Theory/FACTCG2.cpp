#include <iostream>
#include<bits/stdc++.h>
using namespace std;
#define limit 10000002
void init(int f[],int n)
{
	for(int i=0;i<n;i++)
	{
		f[i]=0;
	}
}
int main() 
{
	int f[limit];
	init(f,limit);
	for(int i=2;i*i<=limit;i++)
	{
		if(f[i]==0)
		{
			for(int j=i*i;j<limit;j+=i)
			{
				if(!f[j])
				f[j]=i;
			}
		}
	}
	int n;
	while(scanf("%d",&n)!=EOF)
	{
		if(n==1)
		{
			printf("1\n");
			continue;
		}
		printf("1");
		while((f[n]!=0)&&(n%f[n]==0))
		{
			printf(" x %d",f[n]);
			n/=f[n];
		}
		printf(" x %d",n);
		printf("\n");
	}
	return 0;
} 