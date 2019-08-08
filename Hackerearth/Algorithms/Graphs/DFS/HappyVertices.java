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
	public static void main(String args[])
	{
		new Thread(null, new Abc(),"Abc",1<<26).start();
	}
	public void run()
	{
		FastReader in=new FastReader();
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n];
		init(ar);
		for(int j=0;j<m;j++)
		{
			int a,b;
			a=in.nextInt();
			b=in.nextInt();
			a--;
			b--;
			ar[a].add(b);
			ar[b].add(a);
		}
		int visited[]=new int[n];
		int parent[]=new int[n];
		int children[]=new int[n];
		int color=1;
		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{
				parent[i]=-1;
				visited[i]=color;
				DFS(ar,i,visited,parent,children,color);
				color++;
			}
		}
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(parent[i]==-1)
				continue;
			if(children[i]>children[parent[i]])
			{
				count++;
			}
		}
		System.out.println(count);
	}
	public static void DFS(ArrayList<Integer> ar[],int s,int visited[],int parent[],int children[],int color)
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				children[s]++;
				parent[v]=s;
				visited[v]=color;
				DFS(ar,v,visited,parent,children,color);
			}
		}
	}
	public static void init(ArrayList<Integer> ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=new ArrayList<>();
		}
	} 
}