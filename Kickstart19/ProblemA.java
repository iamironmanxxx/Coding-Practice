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
	static FastReader in=new FastReader();
	public static void main(String args[])
	{
		int t=in.nextInt();
		Outer :for(int g=0;g<t;g++)
		{
			long n,a,b;
			a=in.nextInt();
			b=in.nextInt();
			n=in.nextInt();
			int mid=0,flag=0,start=a+1,end=b,count=0;
			while(start<=end)
			{
				count++;
				mid=(start+end)/2;
				int ans=query(mid);
				if(ans==0)
				{
					flag=1;
					break;
				}
				else if(ans<0)
				{
					end=mid-1;
				}
				else if(ans!=2)
				{
					start=mid+1;
				}
				else
				{
					break Outer;
				}
				if(count>n)
				{
					break;
				}
			}
		}
	}
	public static int query(int x)
	{
		String res;
		System.out.println(x);
		System.out.flush();
		res=in.next();
		if(res.equals("TOO_SMALL"))
			return 1;
		else if(res.equals("TOO_BIG"))
			return -1;
		else if(res.equals("CORRECT"))
			return 0;
		else
			return 2;
	}
}
