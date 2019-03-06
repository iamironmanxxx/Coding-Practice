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
			int n,k,p;
			n=in.nextInt();
			k=in.nextInt();
			p=in.nextInt();
			int ar[]=new int[k];
			for(int i=0;i<k;i++)
			{
				ar[i]=in.nextInt();
			}
			int prev=0,cur;
			do{
				int ind=Arrays.binarySearch(ar,p);
				if(ind>=0)
				{
					ind++;
				}
				else
				{
					ind=(-ind)-1;
				}
				cur=ind;
				//System.out.println("p= "+p);
				p=p+(cur-prev);
				prev=cur;
				//System.out.println("New p="+p);
			}
			while((cur-prev)!=0&&p<n);
			if(p<n)
				System.out.println(p);
			else
				System.out.println(-1);
		}
	}
}