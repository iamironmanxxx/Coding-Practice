#include<iostream>
using namespace std;
#define MAX 100000000
int sum(int freq[],int i,int j)
{
	int s=0;
	for(int a=i;a<=j;a++)
	{
		s+=freq[a];
	}
	return s;
}
int calculate(int keys[],int freq[],int *cost[],int n)
{
	for(int i=0;i<n;i++)
	{
		cost[i][i]=freq[i];
	}
	for(int L=2;L<=n;L++)
	{
		for(int i=0;i<=n-L+1;i++)
		{
			int j=i+L-1;
			cost[i][j]=MAX;
			for(int r=i;r<=j;r++)
			{
				int c=((r>i)?cost[i][r-1]:0)+((r<j)?cost[r+1][j]:0)+sum(freq,i,j);
				if(c<cost[i][j])
				{
					cost[i][j]=c;
				}
			}
		}
	}
	return cost[0][n-1];
}
int main()
{
	int n;
	cin>>n;
	int keys[n];
	int freq[n];
	for(int i=0;i<n;i++)
	{
		cin>>keys[i];
	}
	for(int i=0;i<n;i++)
	{
		cin>>freq[i];
	}
	int *cost[n];
	for(int i=0;i<n;i++)
	{
		cost[i]=new int[n];
	}
	int result=calculate(keys,freq,cost,n);
	cout<<result;
}