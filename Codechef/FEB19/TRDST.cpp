//LDS
//LITWEEK
//CHICKS 
//HOLA AMIGOS
#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int n=0;
void bfs(vector<int> ar[], int dist[],int s)
{
	int visit[n];
	for(int i=0;i<n;i++)
	{
		visit[i]=0;
	}
	queue<int> q;
	q.push(s);
	visit[s]=1;
	dist[s]=0;
	while(!(q.empty()))
	{
		int u=q.front();
		q.pop();
		for(int i=0;i<ar[u].size();i++)
		{
			int v=ar[u][i];
			if(visit[v]==0)
			{
				visit[v]=1;
				dist[v]=dist[u]+1;
				q.push(v);
			}
		}
	}
}
int main()
{
	int n;
	cin>>n;
	int k[n];
	vector<int> ar[n];
	for(int i=0;i<n;i++)
	{
		cin>>k[i];
	}
	for(int i=0;i<n-1;i++)
	{
		int a,b;
		cin>>a>>b;
		a--;
		b--;
		ar[a].push_back(b);
		ar[b].push_back(a);
	}
	int dist[n][n];
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			dist[i][j]=1000000000;
		}
	}
	int d[n];
	for(int i=0;i<n;i++)
	{
		bfs(ar,dist[i],i);
		sort(dist[i],dist[i]+n);
		for(int j=0;j<n;j++)
		{
			cout<<dist[i][j]<<" ";
		}
		cout<<endl;*/
	}
	for(int i=0;i<n;i++)
	{
		d[i]=dist[i][n-k[i]]-1;
	}
	for(int i=0;i<n;i++)
	{
		cout<<d[i]<<" ";
	}
	cout<<endl;
}