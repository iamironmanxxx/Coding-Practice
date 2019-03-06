#include <iostream>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int f[n][26];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<26;j++)
			{
				f[i][j]=0;
			}
		}
		for(int i=0;i<n;i++)
		{
			string str;
			cin>>str;
			for(int j=0;j<str.length();j++)
			{
				char c=str[j];
				f[i][c-'a']++;
			}
		}
		int res=0;
		for(int i=0;i<26;i++)
		{
			int flag=0;
			for(int j=0;j<n;j++)
			{
				if(f[j][i]==0)
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
			{
				res++;
			}
		}
		cout<<res<<endl;

	}
	return 0;
}