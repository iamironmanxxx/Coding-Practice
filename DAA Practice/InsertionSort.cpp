#include<iostream>
using namespace std;
int main()
{
	int n;
	cin>>n;
	int ar[n];
	for(int i=0;i<n;i++)
	{
		cin>>ar[i];
	}
	for(int i=1;i<n;i++)
	{
		int key=ar[i];
		int j=i-1;
		while(j>=0&&ar[j]>key)
		{
			ar[j+1]=ar[j];
			j-=1;
		}
		ar[j+1]=key;
	}
	for(int i=0;i<n;i++)
	{
		cout<<ar[i]<<" ";
	}
}