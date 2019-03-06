import java.util.*;
import java.io.*;
public class Abc
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
		int n;
		long k,m;
		n=in.nextInt();
		k=in.nextLong();
		m=in.nextLong();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=in.nextInt();
		}
		Arrays.sort(arr);
		int ar[]=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			ar[i]=arr[n-1-i];
		}
		long cum[]=new long[n];
		cum[0]=ar[0];
		for(int i=1;i<n;i++)
		{
			cum[i]=cum[i-1]+ar[i];
		}
		//System.out.println(Arrays.toString(cum));
		double max=0;
		for(int x=0;x<n&&x<=m;x++)
		{
			double avg=(cum[n-1-x]+Math.min((n-x)*k,(m-x)));
			avg/=(n-x);
			if(avg>max)
			{
				max=avg;
			}
		}
		System.out.println(max);
	}
}