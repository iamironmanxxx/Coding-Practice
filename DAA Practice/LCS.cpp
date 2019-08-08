#include<iostream>
using namespace std;
int LCS(string a,string b,int n,int m)
{
	int L[n+1][m+1];
	for(int i=0;i<=n;i++)
	{
		for(int j=0;j<=m;j++)
		{
			if(i==0||j==0)
			{
				L[i][j]=0;
			}
			else if(a[i-1]==b[j-1])
			{
				L[i][j]=L[i-1][j-1]+1;
			}
			else
			{
				L[i][j]=max(L[i-1][j],L[i][j-1]);
			}
		}
	}
	int index=L[n][m];
	string lcs;
	int i=n,j=m;
	while(i>=0&&j>=0)
	{
		if(a[i]==b[j])
		{
			lcs=a[i]+lcs;
			index--;
			i--;
			j--;
		}
		else if(L[i-1][j]>L[i][j-1])
		{
			i--;
		}
		else
		{
			j--;
		}
	}
	cout<<lcs;
	return L[n][m];
}
int main()
{
	string a,b;
	cin>>a>>b;
	int n=a.length();
	int m=b.length();
	cout<<a<<" "<<b<<endl;
	int lcs=LCS(a,b,n,m);
	cout<<lcs;
}