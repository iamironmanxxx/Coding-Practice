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
		PrintWriter pw=new PrintWriter(System.out);
		int n=in.nextInt();
		int q=in.nextInt();
		int ar[]=new int[n];
		ArrayList<Integer> f[]=new ArrayList[20001];
		ArrayList<Integer> d[]=new ArrayList[20001];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		for(int i=1;i<20001;i++)
		{
			for(int j=i;j<20001;j+=i)
			{
				if(d[j]==null)
				{
					d[j]=new ArrayList<>();
				}
				d[j].add(i);
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<d[ar[i]].size();j++)
			{
				int v=d[ar[i]].get(j);
				if(f[v]==null)
				{
					f[v]=new ArrayList<>();
				}
				f[v].add(i);
			}
		}
		/*for(int i=0;i<20001;i++)
		{
			if(f[i]!=null)
			{
				pw.print(i+" : \n");
				for(int j=0;j<f[i].size();j++)
				{
					pw.print(f[i].get(j)+" ");
				}
				pw.print("\n");
			}
		}*/
		for(int i=0;i<q;i++)
		{
			int ind=in.nextInt();
			int x=in.nextInt();
			ind--;
			int ans=0;
			if(f[x]!=null){
				ans=Collections.binarySearch(f[x],ind);
				if(ans<0)
				{
					ans=(-ans)-1;
				}
				ans=f[x].size()-ans;
			}
			pw.print(ans+"\n");
		}
		pw.close();
	}
}