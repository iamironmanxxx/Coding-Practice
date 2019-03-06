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
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		long x=in.nextLong();
		long ar[][]=new long[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				ar[i][j]=in.nextInt();
			}
		}
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{	
				ar[i][j]=ar[i-1][j]+ar[i][j];
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=1;j<m;j++)
			{
				ar[i][j]=ar[i][j-1]+ar[i][j];
			}
		}
		//print(ar);
		int start=1,end=Math.min(n,m),mid=0;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(check(ar,mid,x,n,m))
			{
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
		}
		System.out.println((start-1)*(start-1));
	}
	public static void print(long ar[][])
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean check(long ar[][],int k,long x,int n,int m)
	{
		long sum=0;
		for(int i=k-1;i<n;i++)
		{
			for(int j=k-1;j<m;j++)
			{
				long t1,t2,t3;
				t1=(i-k>=0)?ar[i-k][j]:0;
				t2=(j-k>=0)?ar[i][j-k]:0;
				t3=(i-k>=0&&j-k>=0)?ar[i-k][j-k]:0;
				sum=ar[i][j]-t1-t2+t3;
				if(sum<=x)
				{
					//System.out.println("K= "+k+ " sum= "+sum);
					return true;
				}
			}
		}
		return false;
	}

}