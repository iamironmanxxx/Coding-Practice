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
	public static void main(String[] args) {
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int n,q;
		n=in.nextInt();
		q=in.nextInt();
		long l[]=new long[n];
		long r[]=new long[n];
		long size[]=new long[n];
		for(int i=0;i<n;i++)
		{
			l[i]=in.nextLong();
			r[i]=in.nextLong();
			size[i]=r[i]-l[i]+1;
		}
		for(int i=1;i<n;i++)
		{
			size[i]+=size[i-1];
		}
		//System.out.println(Arrays.toString(size));
		for(int i=0;i<q;i++)
		{
			long x=in.nextLong();
			int ind=Arrays.binarySearch(size,x);
			if(ind<0)
			{
				ind=(-ind)-1;
			}
			//System.out.println("Index = "+ind);
			long res;
			if(ind>0)
			{
				res=l[ind]+(x-size[ind-1]-1);
			}
			else
			{
				res=l[ind]+x-1;
			}
			pw.print(res+"\n");
		}
		pw.close();
	}
}