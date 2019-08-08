#include<iostream>
#include<bits/stdc++.h>
#define ll long long
using namespace std;
int idVal=0;
int countNodes=0;
void DFS(vector<int> ar[],int s,int parent,int visited[],int id[],int low[],ll sum[])
{
	id[s]=idVal++;
	low[s]=id[s];

	for(int i=0;i<(int)ar[s].size();i++)
	{
		int v=ar[s][i];
		if(v==parent)
			continue;
		if(visited[v]==0)
		{
			visited[v]=1;
			DFS(ar,v,s,visited,id,low,sum);
			
			low[s]=min(low[s],low[v]);
			sum[s]+=sum[v];
		}
		else
		{
			low[s]=min(low[s],id[v]);
		}
	}
}
void DFS2(vector<int> ar[],int s,int parent,int visited[],int id[],int low[],ll sum[],int p,int root)
{
	for(int i=0;i<(int)ar[s].size();i++)
	{
		int v=ar[s][i];
		if(v==parent)
			continue;
		if(visited[v]==0)
		{
			visited[v]=1;
			DFS2(ar,v,s,visited,id,low,sum,p,root);
			if(low[v]>id[s])
			{
				if(abs((sum[root]-sum[v])-sum[v])<p)
				{
					countNodes++;
				}
			}
		}
	}
}
void print(int ar[],int n)
{
	for(int i=0;i<n;i++)
	{
		cout<<ar[i]<<" ";
	}
	cout<<endl;
}
template<class t>
void init(t ar[],int ch,int n)
{
	for(int i=0;i<n;i++)
	{
		ar[i]=ch;
	}
}
int main()
{
	int n,m,p;
	cin>>n>>m>>p;
	vector<int> ar[n];
	for(int i=0;i<m;i++)
	{
		int a,b;
		cin>>a>>b;
		a--;
		b--;
		ar[a].push_back(b);
		ar[b].push_back(a);
	}

	int visited[n];
	int id[n];
	int low[n];
	ll sum[n];
	init<ll>(sum,1,n);
	init<int>(low,0,n);
	init<int>(id,0,n);
	init<int>(visited,0,n);

	//print(sum,n);

	for(int i=0;i<n;i++)
	{
		if(visited[i]==0)
		{
			//cout<<visited[i]<<endl;
			visited[i]=1;
			DFS(ar,i,i,visited,id,low,sum);
		}
	}

	init(visited,0,n);
	//print(id,n);
	//print(low,n);

	for(int i=0;i<n;i++)
	{
		if(visited[i]==0)
		{
			visited[i]=1;
			DFS2(ar,i,i,visited,id,low,sum,p,i);
		}
	}

	//print(sum,n);

	cout<<countNodes<<endl;

	return 0;
}