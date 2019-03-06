#include <stdio.h>
#define n 10
int main()
{
	int ar[n];
	for(int i=0;i<n;i++)
	{
		scanf("%d",&ar[i]);
	}
	for(int i=0;i<n-1;i++)
	{
		for(int j=i+1;j<n;j++)
		{
			if(ar[j]<ar[i])
			{
				ar[i]=ar[i]+ar[j];
				ar[j]=ar[i]-ar[j];
				ar[i]=ar[i]-ar[j];
			}
		}
	}

	for(int i=0;i<n;i++)
	{
		printf("%d ",ar[i]);
	}
	return 0;
}