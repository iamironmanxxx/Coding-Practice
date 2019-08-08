import java.util.*;
import java.io.*;
class Abc implements Runnable
{
	static class Node
	{
		int x,y;
		public Node(int x,int y)
		{
			this.x=Math.min(x,y);
			this.y=(x+y)-this.x;
		}
		public void equals(Object obj)
		{
			if(this==obj)
				return true;
			if(this.getClass()!=obj.getClass())
				return false;
			Node n=(Node)obj;
			if(n.x==x&&x.y==y)
				return true;
			return fasle;
		}
		public int hashCode()
		{
			return 1000*x+y;
		}
	}
	public static void main(String[] args) {
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	public void run()
	{
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n];
		HashMap<Node,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			ar[i]=new ArrayList<>();
		}
		for(int i=0;i<m;i++)
		{
			int a,b;
			a=in.nextInt();
			b=in.nextInt();
			a--;
			b--;
			Node n=new Node(a,b);
			if(map.get(n)!=null)
			{
				map.put(n,map.get(n)+1);
				ar[a].add(b);
				ar[b].add(a);
			} 
			else
			{
				map.put(n,1);
			}
		}
		int visited[]=new int[n];
		int e[]=new int[n];
		int v[]=new int[n];
		for(int i=0;i<n;i++)
		{
			v[i]=1;
		}
		int components[]=new int[n];
		int ptr=0;
		for(int i=0;i<n;i++)
		{
			visited[i]=1;
			DFS(ar,i,-1,e,v,visited,map);
			ptr++;
		}
	}
	public static void DFS(ArrayList<Integer> ar[],int s,int parent,int e[],int v[],int visited[],HashMap<Node,Integer> map)
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int u=ar[s].get(i);
			if(visited[u]==0)
			{
				visited[u]=1;
				DFS(ar,u,s,e,v,visited,map);
				v[s]+=v[u];
				e[s]+=e[u]+map.get(new Node(s,u));
			}
			else if(u!=parent)
			{
				e[s]+=map.get(new Node(s,u));
			}
		}
	}
}