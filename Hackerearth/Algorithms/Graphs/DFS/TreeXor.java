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
		new Thread(null, new Abc(),"Abc",1<<26).start();
	}
	public void run()
	{
		FastReader in=new FastReader();
		int n,k;
		n=in.nextInt();
		k=in.nextInt();
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
		int xorAr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{
				visited[i]=1;
				DFS(ar,i,visited,xorAr,k,i);
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(xorAr[i]);
		}
	}
	public static void DFS(ArrayList<Integer> ar[],int s,int visited[],int xorAr[],int k,int root)
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				if(s!=root)
				    xorAr[v]=xorAr[s]^((ar[s].size()-1>=k)?s+1:0);
				else
				    xorAr[v]=xorAr[s]^((ar[s].size()>=k)?s+1:0);
				DFS(ar,v,visited,xorAr,k,root);
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