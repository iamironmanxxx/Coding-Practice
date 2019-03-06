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
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		while(t--!=0)
		{
			int n=in.nextInt();
			int ar[]=new int[n];
			int l[]=new int[n];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				l[i]=in.nextInt();
			}
			int init=ar[0];
			long sum=0;
			long cost=0;
			for(int i=0;i<n;i++)
			{
				if(ar[i]<init)
				{
					cost+=sum*init;
					init=ar[i];
					sum=l[i];
				}
				else
				{
					sum+=l[i];
				}
			}
			cost+=sum*init;
			System.out.println(cost);
		}
	}
}