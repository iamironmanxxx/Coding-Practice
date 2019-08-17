#include<iostream>
using namespace std;
#include<bits/stdc++.h>
#include<map>
#include<iterator>
int  main() 
{
	int limit=1000002;
	int f[limit];
	for(int i=0;i<limit;i++)
	{
		f[i]=0;
	}
	for(int i=2;i*i<limit;i++)
	{
		if(f[i]==0)
		{
			for(int j=i*i;j<limit;j+=i)
			{
				if(f[j]==0)
					f[j]=i;
			}
		}
	}
	int t;
	scanf("%d",&t);
	while(t--)
	{
		int n;
		scanf("%d",&n);
		map<int,int> mp;
		while(f[n]!=0&&n%f[n]==0)
		{
			if(mp.find(f[n])==mp.end())
			{
				//printf("not found 2 so inserted\n");
				mp.insert(pair<int,int>(f[n],1));
			}
			else
			{
				mp.insert(pair<int,int>(f[n],(mp[f[n]]++)));
				//printf("found 2 and incremented %d\n",mp[f[n]]++);
			}
			n/=f[n];
		}
		if(mp.find(n)==mp.end())
		{
			//printf("not found 2 so inserted\n");
			mp.insert(pair<int,int>(n,1));
		}
		else
		{			
			mp.insert(pair<int,int>(n,mp[n]++));
			//printf("found 2 and incremented %d\n",mp[n]);
		}
		int max=0;
		map<int,int>::iterator itr;
		for(itr=mp.begin();itr!=mp.end();itr++)
		{
			//printf("%d , %d\n",itr->first,itr->second);
			if(max<itr->second)
			{
				max=itr->second;
			}
		}
		printf("%d\n",max);
	}
	return 0;
}