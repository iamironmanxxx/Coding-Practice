#include<iostream> 
using namespace std;
#define MAX 100000000
int multiply(int p[],int n)
{
	int m[n][n];
	for(int i=0;i<n;i++)
	{
		m[i][i]=0;
	}
	for(int L=2;L<n;L++)
	{
		for(int i=0;i<n-L+1;i++)
		{
			int j=i+L-1;
			m[i][j]=MAX;
			for(int k=i;k<j;k++)
			{
				int q=m[i][k]+m[k+1][j]+p[i-1]*p[j]*p[k];
				if(q<m[i][j])
				{
					m[i][j]=q;
				}
			}
		}
	}
	return m[1][n-1];
}
int main()
{
	int n;
	cin>>n;
	int p[n];
	for(int i=0;i<n;i++)
	{
		cin>>p[i];
	}
	int res=multiply(p,n);
	cout<<res;
}