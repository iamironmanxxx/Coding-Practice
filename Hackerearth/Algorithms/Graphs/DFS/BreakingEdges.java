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
	public static void main(String args[])
	{
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	static int count=0;
	public void run()
	{
		FastReader in=new FastReader();
		int n;
		n=in.nextInt();
		int val[]=new int[n];
		int or[]=new int[n];
		for(int i=0;i<n;i++)
		{
			val[i]=in.nextInt();
		}
		ArrayList<Integer> ar[]=new ArrayList[n];
		init(ar);
		for(int i=0;i<n-1;i++)
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
		visited[0]=1;
		parent[0]=-1;
		DFS(ar,0,visited,val,or,parent);
		visited=new int[n];
		visited[0]=1;
		int revOr[]=new int[n];
		revOr[0]=val[0];
		DFS2(ar,0,visited,val,or,revOr,parent);
		System.out.println(count);
	}
	public static void DFS2(ArrayList<Integer> ar[],int s,int visited[],int val[],int or[],int revOr[],int parent[])
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				int childVal=orValue(ar,s,or,v,parent[s]);
				int parentValue=revOr[s];
				int cumOr=parentValue|childVal;
				revOr[v]=cumOr|val[v];
				if(or[v]==cumOr)
				{
					count++;
				}
				DFS2(ar,v,visited,val,or,revOr,parent);
			}
		}
	}
	public static int orValue(ArrayList<Integer> ar[],int s,int or[],int block,int parent)
	{
		int sum=0;
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(v==block||v==parent)
			{
				continue;
			}
			sum|=or[v];
		}
		return sum;
	}
	public static void DFS(ArrayList<Integer> ar[],int s,int visited[],int val[],int or[],int parent[])
	{
		or[s]=val[s];
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				parent[v]=s;
				DFS(ar,v,visited,val,or,parent);
				or[s]=or[s]|or[v];
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