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
	static int max=0;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			max=0;
			int n=in.nextInt();
			long ar[]=new long[n];
			long br[]=new long[n];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextLong();
			}
			for(int i=0;i<n;i++)
			{
				br[i]=in.nextLong();
			}
			for(int i=0;i<n;i++)
			{
				find(i,i,br,ar);
			}
			System.out.println(max);
		}
	}
	public static void find(int x,int start,long br[],long ar[])
	{
		int end=br.length-1,mid=0;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(br[mid]>=ar[x])
			{
				start=mid+1;
				max=Math.max(max,mid-x);
			}
			else
			{
				end=mid-1;
			}
		}
	}
}