//Hey nibbas
//LDS LITWEEK ENGLISH GRAMMAR
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		cin>>s;
		int f[26];
		for(int i=0;i<26;i++)
		{
			f[i]=0;
		}
		for(int i=0;i<s.length();i++)
		{
			f[s[i]-'A']++;
		}
		int min=s.length();
		for(int i=1;i<=26;i++)
		{
			if(s.length()%i==0){
				int lim=s.length()/i;
				sort(f,f+26);
				int ptr=25;
				int count=0;
				int diff=0;
				for(int j=0;j<i;j++)
				{
					diff=lim-f[ptr--];
					if(diff>0)
					{
						count+=diff;
					}
				}
				if(count<min)
				{
					min=count;
				}
			}
		}
		cout<<min<<endl;
	}
	return 0;
}