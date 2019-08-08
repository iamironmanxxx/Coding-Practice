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
	public static void main(String[] args) {
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int n=in.nextInt();
		double dist[]=new double[n];
		for(int i=0;i<n;i++)
		{
			long a,b;
			a=in.nextLong();
			b=in.nextLong();
			dist[i]=Math.sqrt((a*a)+(b*b));

		}
		Arrays.sort(dist);
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			long r=in.nextLong();
			int start=0,end=n,mid;
			while(start<end)
			{
				mid=(start+end)/2;
				if(dist[mid]<=r)
				{
					start=mid+1;
				}
				else
				{
					end=mid;
				}
			}
			pw.print(start+"\n");
		}
		pw.close();
	}
}