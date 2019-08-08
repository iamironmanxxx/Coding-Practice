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
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	public void run()
	{
		FastReader in=new FastReader ();
		int n,k;
		n=in.nextInt();
		k=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n];
		int cost[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=new ArrayList<>();
		}
		for(int i=0;i<n;i++)
		{
			cost[i]=in.nextInt();
		}
		for(int i=1;i<n;i++)
		{
			int a=in.nextInt();
			a--;
			ar[a].add(i);
			ar[i].add(a);
		}
		int visited[]=new int[n];
		int xorSum[]=new int[n];
		int f[]=new int[1<<21];
		int parent[]=new int[n];
		parent[0]=-1;
		visited[0]=1;
		xorSum[0]=cost[0];
		f[0]=1;
		DFS(ar,0,cost,visited,parent,xorSum,f,0,k);
		System.out.println(count);
	}
	static long count=0;
	public static void DFS(ArrayList<Integer> ar[],int s,int cost[],int visited[],int parent[],int xorSum[],int f[],int xorVal,int k)
	{
		//System.out.println("There exists : "+xorSum[s]);
		xorVal^=cost[s];
		count+=f[xorVal^k];
		f[xorVal]++;
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				parent[v]=s;
				visited[v]=1;
				DFS(ar,v,cost,visited,parent,xorSum,f,xorVal,k);
			}
		}
		f[xorVal]--;
	}
}