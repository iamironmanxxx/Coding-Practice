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
		int j=i-1;
		int key=ar[i];
		while(j>=0&&ar[j]>key)
		{
			ar[j+1]=ar[j];
			j--;
		}
		ar[j+1]=key;
		print(ar);
	}

	print(ar);
	return 0;
}