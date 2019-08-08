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
	public static void main(String srgs[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		while(t--!=0)
		{
			int k=in.nextInt();
			String s=in.next();
			int n=s.length();
			int weight[]=new int[n];
			for(int i=0;i<n;i++)
			{
				weight[i]=s.charAt(i)-'a'+1;
			}
			for(int i=1;i<n;i++)
			{
				weight[i]+=weight[i-1];
			}
			int count=0;
			for(int i=0;i<n;i++)
			{
				int start=i,end=n,mid;
				while(start<end)
				{
					mid=(start+end)/2;
					if(total(weight,i,mid)<k)
					{
						start=mid+1;
					}
					else
					{
						end=mid;
					}
				}
				int low=start;
				start=i;
				end=n;
				while(start<end)
				{
					mid=(start+end)/2;
					if(total(weight,i,mid)>k)
					{
						end=mid;
					}
					else
					{
						start=mid+1;
					}
				}
				int up=end-1;
				count+=up-low+1;
			}
			System.out.println(count);
		}
	}
	public static int total(int weight[],int i,int mid)
	{
		int left;
		if(i==0)
		{
			left=0;
		}
		else
		{
			left=weight[i-1];
		}
		return weight[mid]-left;
	}
}