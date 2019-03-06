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
	static int ar[];
	static int n;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			n=in.nextInt();
			ar=new int[n];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			int start=2,end=n,mid=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				if(check(mid))
				{
					//System.out.println("For size = "+mid +" true ");
					start=mid+1;
				}
				else
				{
					//System.out.println("For size = "+mid +" false");
					end=mid-1;
				}
			}
			System.out.println(start-1);
		}
	}
	public static boolean check(int size)
	{
		int[] f=new int[3];
		for(int i=0;i<size;i++)
		{
			f[ar[i]-1]++;
		}
		if(calc(f,size))
		{
			return true;
		}

		int lptr=0,rptr=size;
		while(rptr<n)
		{
			f[ar[rptr]-1]++;
			f[ar[lptr]-1]--;
			if(calc(f,size))
			{
				return true;
			}
			lptr++;
			rptr++;
		}
		return false;
	}
	public static boolean calc(int f[],int size)
	{
		if(f[0]==size&&size<n-1){
			return true;
		}
		if(f[0]==size-1&&f[1]==1)
		{
			return true;
		}
		if(f[1]==size&&size<n-1)
		{
			return true;
		}
		if(f[1]==size-1&&size<n)
		{
			return true;
		}
		if(f[1]==size-2&&f[0]==1)
		{
			return true;
		}
		if(f[2]==size&&size<n-1)
		{
			return true;
		}
		if(f[2]==size-1&&f[1]==1)
		{
			return true;
		}
		return false;
	}
	public static int next(int i)
	{
		return (i+1)%3;
	}
}