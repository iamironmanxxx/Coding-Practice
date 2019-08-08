import java.util.*;
import java.io.*;
class Abc implements Runnable
{
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 
	
	    public FastReader() 
	    { 
	        br = new BufferedReader(new
	                 InputStreamReader(System.in)); 
	    } 
	
	    String next() 
	    { 
	        while (st == null || !st.hasMoreElements()) 
	        { 
	            try
	            { 
	                st = new StringTokenizer(br.readLine()); 
	            } 
	            catch (IOException  e) 
	            { 
	                e.printStackTrace(); 
	            } 
	        } 
	        return st.nextToken(); 
	    } 
	
	    int nextInt() 
	    { 
	        return Integer.parseInt(next()); 
	    } 
	
	    long nextLong() 
	    { 
	        return Long.parseLong(next()); 
	    } 
	
	    double nextDouble() 
	    { 
	        return Double.parseDouble(next()); 
	    } 
	
	    String nextLine() 
	    { 
	        String str = ""; 
	        try
	        { 
	            str = br.readLine(); 
	        } 
	        catch (IOException e) 
	        { 
	            e.printStackTrace(); 
	        } 
	        return str; 
	    } 
	} 
	public static void main(String[] args) {
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	static class Node
	{
		int x,y;
		Node(int a,int b)
		{
			x=a;
			y=b;
		}
		public boolean equals(Object obj)
		{
			if(this==obj)
				return true;
			if(this.getClass()!=obj.getClass())
				return false;
			Node n=(Node)obj;
			if((n.x==x&&n.y==y)||(n.y==x&&n.x==y))
				return true;
			return false;
		}
		public int hashCode()
		{
			return x+y;
		}
	}
	static int visited[];
	static int parent[];
	public static void DFS(ArrayList<Integer> ar[],int s)
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				parent[v]=s;
				DFS(ar,v);
			}
		}
	}
	public static int lca(int a,int b)
	{
		HashMap<Integer,Integer> set=new HashMap<>();
		int source=b;
		int sum=0;
		int cost=0;
		while(source!=-1)
		{
			sum+=cost;
			set.put(source,sum);
			cost=0;
			if(parent[source]!=-1)
			{
				//System.out.println("Getting "+source+" "+parent[source]);
				cost=map.get(new Node(source,parent[source]));
			}
			source=parent[source];
		}
		source=a;
		int lcaNode=0;
		cost=0;
		sum=0;
		int finalSum=0;
		while(source!=-1)
		{
			sum+=cost;
			cost=0;
			if(parent[source]!=-1)
			{
				//System.out.println("Getting "+source+" "+parent[source]);
				cost=map.get(new Node(source,parent[source]));
			}
			if(set.get(source)!=null)
			{
				lcaNode=source;
				break;
			}
			source=parent[source];
		}
		finalSum=sum+set.get(lcaNode);
		return finalSum;

	}
	static HashMap<Node,Integer> map=new HashMap<>();
	public void run()
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int n=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n+1];
		for(int i=0;i<=n;i++)
		{
			ar[i]=new ArrayList<>();
		}
		Node vert[]=new Node[n-1];
		for(int i=0;i<n-1;i++)
		{
			int a,b,w;
			a=in.nextInt();
			b=in.nextInt();
			w=in.nextInt();
			ar[a].add(b);
			ar[b].add(a);
			//System.out.println("Putting :"+a+" "+b);
			Node node=new Node(a,b);
			map.put(node,w);
			vert[i]=node;
		}
		parent=new int[n+1];
		visited=new int[n+1];
		visited[1]=1;
		parent[1]=-1;
		DFS(ar,1);
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int ch,a,b;
			ch=in.nextInt();
			a=in.nextInt();
			b=in.nextInt();
			if(ch==1)
			{
				a--;
				map.put(vert[a],b);
			}
			else
			{
				int dist=lca(a,b);
				pw.println(dist);
			}
		}
		pw.close();
	}
}