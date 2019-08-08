import java.util.*;
import java.io.*;
class Main implements Runnable{
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
		new Thread(null, new Main(),"Main",1<<26).start();
	}
	public void run()
	{
		FastReader in=new FastReader();
		int q=in.nextInt();
		int m[]=new int[q];
		int n[]=new int[q];
		int ptr=0;

		ArrayList<Integer> ar[]=new ArrayList[q];
		init(ar);
		for(int j=0;j<q;j++)
		{
			int ch=in.nextInt();
			int x,y;
			x=in.nextInt();
			y=in.nextInt();
			if(ch==1)
			{
				m[ptr]=x;
				n[ptr]=y;
				for(int i=0;i<ptr;i++)
				{
					if(m[i]<x&&n[i]>x||m[i]<y&&n[i]>y)
					{
						ar[ptr].add(i);
					}
					if(x<m[i]&&y>m[i]||x<n[i]&&y>n[i])
					{
						ar[i].add(ptr);
					}
				}
				ptr++;
			}
			else
			{
				x--;
				y--;
				int visited[]=new int[ar.length];
				visited[x]=0;
				flag=0;
				DFS(ar,x,y,visited);
				if(flag==1)
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}

	}
	static int flag=0;
	public static void DFS(ArrayList<Integer> ar[],int src,int dest,int visited[])
	{	
		for(int i=0;i<ar[src].size();i++)
		{
			int v=ar[src].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				if(v==dest)
				{
					flag=1;
				}
				else
				{
					DFS(ar,v,dest,visited);
				}
			}
		}

	}
	public void init(ArrayList<Integer> ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=new ArrayList<>();
		}
	}
}