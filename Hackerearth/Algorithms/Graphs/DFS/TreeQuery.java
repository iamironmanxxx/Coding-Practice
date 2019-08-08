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
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n];
		ArrayList<Integer> arComp[]=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=new ArrayList<>();
			arComp[i]=new ArrayList<>();
		}
		for(int i=0;i<m;i++)
		{
			int a,b;
			a=in.nextInt();
			b=in.nextInt();
			a--;
			b--;
			ar[a].add(b);
			arComp[b].add(a);
		}
		int count1=0,count2=0;
		for(int i=0;i<n;i++)
		{
			if(ar[i].size()==0)
				count1++;
			if(arComp[i].size()==0)
				count2++;
		}
		System.out.println(Math.max(count1,count2));
	}
}