#include<iostream>
using namespace std;
#define limit 10000009
int f[limit];
int count[limit];
void sieve()
{
	for(int i=3;i<3163;i+=2)
	{
		if(f[i]==0)
		{
			for(int j=i*i;j>0&&j<10000000;j+=2*i)
			{
				f[j]=1;
			}
		}
	}
	count[2]=1;
	for(int i=3;i<limit;i++)
	{
		if(!f[i] && i%2==1)
			count[i]=1+count[i-1];
		else
			count[i]=count[i-1];
	}
	//printf("\n");
}
int main() 
{
	int t;
	cin>>t;
	sieve();
	while(t--)
	{
		int n;
		scanf("%d",&n);
		printf("%d\n",count[n]-count[(n>>1)]);
	}
	return 0;
}
	