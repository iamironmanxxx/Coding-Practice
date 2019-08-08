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
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		int visited[]=new int[n];
		ArrayList<Integer> ar[]=new ArrayList[n];
		init(ar);
		for(int i=0;i<m;i++)
		{
			int a,b;
			a=in.nextInt();
			b=in.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		int x=in.nextInt();
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(visited[i]==0&&i!=x)
			{
				count++;
				if(count>1)
    			{
    				break;
    			}
				visited[i]=1;
				DFS(ar,i,visited,x);
			}
		}
		if(count>1)
		{
			System.out.println("Not Connected");
		}
		else
		{
			System.out.println("Connected");
		}

	}
	public static void DFS(ArrayList<Integer> ar[],int s,int visited[],int x)
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0&&v!=x)
			{
				visited[v]=1;
				//System.out.println("Discovered "+v);
				DFS(ar,v,visited,x);
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