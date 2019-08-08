#include<iostream>
using namespace std;
void quickSort(int *ar,int n,int s,int e)
{
	if(s>=e)
		return;
	int p=ar[s];
	int r=s;
	for(int i=s+1;i<=e;i++)
	{
		if(ar[i]<p)
		{
			r++;
			int temp=ar[r];
			ar[r]=ar[i];
			ar[i]=temp;
		}
	}
	ar[s]=ar[r];
	ar[r]=p;
	quickSort(ar,n,s,r-1);
	quickSort(ar,n,r+1,e);
}
void print(int *ar,int n)
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
	quickSort(ar,n,0,n-1);
	print(ar,n);
}