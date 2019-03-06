#include <stdio.h>
#define n 10
void print(int ar[])
{
	for(int i=0;i<n;i++)
	{
		printf("%d ",ar[i]);
	}
	printf("\n");
}
int main()
{
	int ar[n];
	for(int i=0;i<n;i++)
	{
		scanf("%d",&ar[i]);
	}
	for(int i=1;i<n;i++)
	{
		for(int j=n-1;j>=i;j--)
		{
			if(ar[j]<ar[j-1])
			{
				ar[j]=ar[j]+ar[j-1];
				ar[j-1]=ar[j]-ar[j-1];
				ar[j]=ar[j]-ar[j-1];
			}
		}
		print(ar);
	}

	print(ar);
	return 0;
}