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
			int n=in.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=in.nextInt();
			}
			int d[]=new int[n];
			for(int i=0;i<n;i++)
			{
				d[i]=in.nextInt();
			}
			int val=-1;
			int max=Integer.MIN_VALUE;
			for(int i=0;i<n;i++)
			{
				if((a[prev(i,n)]+a[next(i,n)])<d[i])
				{
					val=d[i];
					if(val>max)
					{
						max=val;
					}
				}
			}
			if(val==-1){
				System.out.println(val);
			}
			else
			{
				System.out.println(max);
			}
		}
	}
	static int next(int i,int n)
	{
		if(i==n-1)
			return 0;
		return i+1;
	}
	static int prev(int i,int n)
	{
		if(i==0)
		{
			return n-1;
		}
		return i-1;
	}
}