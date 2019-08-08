import java.io.*;
import java.util.*;
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
	public static void main(String arhs[])
	{
		new Thread(null, new Abc(), "Abc", 1<<26).start();
	}
	static int idVal=0;
	static int count=0;
	public static void DFS2(ArrayList<Integer> ar[],int s,int parent,int visited[],int low[],int id[],int sum[],int p,int root)
	{

		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);

			if(v==parent)
				continue;

			if(visited[v]==0)
			{
				visited[v]=1;
				DFS2(ar,v,s,visited,low,id,sum,p,root);
				if(low[v]>id[s])
				{
					if(sum[root]-sum[v]<p&&sum[v]<p)
					{
						count++;
					}
				}
			}
		}
	}
	public static void DFS(ArrayList<Integer> ar[],int s,int parent,int visited[],int low[],int id[],int sum[])
	{
		id[s]=idVal++;
		low[s]=id[s];
		
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			
			if(v==parent)
				continue;
			
			if(visited[v]==0)
			{
				visited[v]=1;
				DFS(ar,v,s,visited,low,id,sum);
				low[s]=Math.min(low[s],low[v]);
			    sum[s]+=sum[v];
			}
			else
			{
			    low[s]=Math.min(low[s],id[v]);
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
	public void run()
	{
		FastReader in=new FastReader();
		int n,m,p;
		n=in.nextInt();
		m=in.nextInt();
		p=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n];
		init(ar);
		for(int i=0;i<m;i++)
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
		int low[]=new int[n];
		int id[]=new int[n];
		int sum[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			sum[i]=1;
		}

		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{
				visited[i]=1;
				DFS(ar,i,i,visited,low,id,sum);
			}
		}
		visited=new int[n];
		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{
				visited[i]=1;
				DFS2(ar,i,i,visited,low,id,sum,p,i);
			}
		}
		//System.out.println(Arrays.toString(sum));

		System.out.println(count);
	}
}