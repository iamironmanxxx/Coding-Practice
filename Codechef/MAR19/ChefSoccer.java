import java.util.*;
import java.io.*;
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
	static long count;
	static long mod=1000000007;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			count=0;
			int n=in.nextInt();
			int ar[]=new int[n];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			int visited[]=new int[n];
			visited[0]=1;
			func(ar,0,visited);
			System.out.println(count);
		}
	}
	public static void func(int ar[],int index,int visited[])
	{
		count++;
		count%=mod;
		if(index-1>=0&&visited[index-1]==0)
		{
			visited[index-1]=1;
			func(ar,index-1,visited);
			visited[index-1]=0;
		}
		if(index+1<ar.length&&visited[index+1]==0)
		{
			visited[index+1]=1;
			func(ar,index+1,visited);
			visited[index+1]=0;
		}
		if(ar[index]==2)
		{
			if(index-2>=0&&visited[index-2]==0)
			{

				visited[index-2]=1;
				func(ar,index-2,visited);
				visited[index-2]=0;
			}
			if(index+2<ar.length&&visited[index+2]==0)
			{

				visited[index+2]=1;
				func(ar,index+2,visited);
				visited[index+2]=0;
			}
		}

	}
}