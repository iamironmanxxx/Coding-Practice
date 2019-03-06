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
		int n,k;
		n=in.nextInt();
		k=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		//Arrays.sort(ar);
		int start=1,end=10000001,mid;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(check(ar,n,mid)>k)
			{
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
		}
		System.out.println(start);
	}
	public static int check(int ar[],int n,int val)
	{
		//System.out.println("Val= "+val);
		int count=0;
		for(int i=0;i<n;i++)
		{
			int up=2*val+ar[i];
			//System.out.println("up= "+up);
			count++;
			int j;
			for(j=i;j<n;j++)
			{
				if(ar[j]>up)
				{
					break;
				}
			}
			i=j-1;
		}
		//System.out.println("Monks needed= "+(count));
		return count;
	}
}