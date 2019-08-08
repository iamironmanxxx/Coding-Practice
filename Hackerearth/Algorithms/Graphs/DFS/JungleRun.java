import java.io.*;
import java.util.*;
class Abc
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
		FastReader in=new FastReader();
		int n=in.nextInt();
		char ar[][]=new char[n][n];
		int start_x=0,start_y=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				ar[i][j]=in.next().charAt(0);
				if(ar[i][j]=='S')
				{
					start_x=i;
					start_y=j;
				}
			}
		}
		int dest[][]=new int[n][n];
		BFS(ar,start_x,start_y,dest);
		System.out.println(dest[dest_x][dest_y]);

	}
	static class Node
	{
		int a,b;
		Node(int x,int y)
		{
			a=x;
			b=y;
		}
	}
	static int dest_x,dest_y;
	public static void BFS(char ar[][],int x,int y,int dest[][])
	{
		Node s=new Node(x,y);
		int n=ar.length;
		Queue<Node> q=new LinkedList<>();
		q.add(s);
		while(!q.isEmpty())
		{
			Node u=q.poll();
			for(int i=-1;i<2;i++)
			{
				for(int j=-1;j<2;j++)
				{
					if(Math.abs(i+j)==1)
					{
						int l=u.a+i;
						int m=u.b+j;
						if(l>=0&&l<n&&m>=0&&m<n&&!(l==x&&m==y)&&dest[l][m]==0)
						{
							dest[l][m]=dest[u.a][u.b]+1;
							if(ar[l][m]=='P')
							{
								q.add(new Node(l,m));
							}
							else if(ar[l][m]=='E')
							{
								dest_x=l;
								dest_y=m;
							}
						}
					}
				}
			}
		}
	}
}