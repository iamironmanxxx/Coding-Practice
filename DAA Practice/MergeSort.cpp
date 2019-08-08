#include<iostream>
using namespace std;
int* merge(int *ar,int *br,int n,int m)
{
	int *cr;
	cr=new int[n+m];
	int p1=0,p2=0;
	int p=0;
	while(p1<n&&p2<m)
	{
		if(ar[p1]<br[p2])
		{
			cr[p++]=ar[p1++];
		}
		else
		{
			cr[p++]=br[p2++];
		}
	}
	while(p1<n)
	{
		cr[p++]=ar[p1++];
	}
	while(p2<m)
	{
		cr[p++]=br[p2++];
	}
	return cr;
}
int* mergeSort(int *ar,int n,int s,int e)
{
	if(s==e)
	{
		int *nr;
		nr=new int[1];
		nr[0]=ar[s];
		return nr;
	}
	int mid=(s+e)/2;
	int *a,*b,*c;
	a=mergeSort(ar,n,s,mid);
	b=mergeSort(ar,n,mid+1,e);
	c=merge(a,b,mid-s+1,e-mid);
	return c;
}
void print(int ar[],int n)
{
	for(int i=0;i<n;i++)
	{
		cout<<ar[i]<<" ";
	}
	cout<<endl;
}

int main()
{
	int n;
	cin>>n;
	int *ar;
	ar=new int[n];
	for(int i=0;i<n;i++)
	{
		cin>>ar[i];
	}
	ar=mergeSort(ar,n,0,n-1);
	print(ar,n);
}