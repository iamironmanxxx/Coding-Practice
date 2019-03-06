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
		PrintWriter pw=new PrintWriter(System.out);
		int n=in.nextInt();
		int ar[]=new int [n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		Arrays.sort(ar);
		long cum[]=new long[n];
		cum[0]=ar[0];
		for(int i=1;i<n;i++)
		{
			cum[i]=cum[i-1]+ar[i];
		}
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int x=in.nextInt();
			int start=0,end=n-1,mid=0,flag=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				long val=cum[mid]/(mid+1);
				if(val>=x)
				{
					end=mid-1;
				}
				else
				{
					start=mid+1;
				}
			}
			pw.print(start+"\n");
		}
		pw.close();
	}
}