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
	public static void main(String[] args) {
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	static class Node
	{
		int x;
		int y;
		public Node(int a,int b)
		{
			x=a;
			y=b;
		}
	}
	public void run()
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		while(t--!=0)
		{
			int n=in.nextInt();
			int ar[][]=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					ar[i][j]=in.nextInt();
				}
			}
			int visited[][]=new int[n][n];
			Node s=new Node(0,0);
			count=0;
			if(ar[0][0]==1||ar[n-1][n-1]==1)
			{

			}
			else
			{
				visited[0][0]=1;
				DFS(ar,s,visited);
			}
			System.out.println(count);
		}
	}
	static long count=0;
	public static void DFS(int ar[][],Node u,int visited[][])
	{
		int n=ar.length;
		if(u.x==n-1&&u.y==n-1)
			count++;
		else
		{
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					if(Math.abs(i)+Math.abs(j)==1)
					{
						int l,m;
						l=u.x+i;
						m=u.y+j;
						if(l>=0&&l<n&&m>=0&&m<n&&visited[l][m]==0&&ar[l][m]==0)
						{
							visited[l][m]=1;
							DFS(ar,new Node(l,m),visited);
							visited[l][m]=0;
						}
					}
				}
			}
		}
	}
}