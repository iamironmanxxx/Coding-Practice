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
		for(int g=0;g<t;g++)
		{
			int n,k;
			n=in.nextInt();
			k=in.nextInt();
			int ar[]=new int[n];
			long p[]=new long[n+1];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
				for(int y=1;y<=Math.sqrt(ar[i]);y++)
				{
					int up = ar[i]/y;
					int down = Math.max(ar[i]/(y+1),(int)Math.sqrt(ar[i]));
					//System.out.println("UP : "+up+" DOWN : "+down+" Y : "+y);
					int left,right;
					right=i-down;
					left=i-up+1;
					//System.out.println("For : "+ar[i]+" at y= "+y+" left= "+left+" right= "+right);
					if(left>=0&&left<n&&right>=0&&right<n)
					{
						p[left]+=y;
						p[right+1]-=y;
					}
					else if(left<0&&right<n&&right>=0)
					{
						p[0]+=y;
						p[right+1]-=y;
					}
					else if(left>=0&&right>n&&left<n)
					{
						p[left]+=y;
						p[n]-=y;
					}
					if(i-y+1>=0&&i-y+1<n)
					{
						p[i-y+1]+=up;
						p[i-y+2]-=up;
					}
				}
			}
			for(int i=1;i<=n;i++)
			{
				p[i]=p[i-1]+p[i];
			}
			//System.out.println(Arrays.toString(p));
			int flag=0;
			for(int i=0;i<n;i++)
			{
				if(p[i]<=k)
				{
					flag=1;
					System.out.println(i+1);
					break;
				}
			}
			if(flag==0)
			{
				System.out.println(n+1);
			}
		}
	}
}