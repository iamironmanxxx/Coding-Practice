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
		int n,q;
		n=in.nextInt();
		q=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		Arrays.sort(ar);
		//System.out.println(Arrays.toString(ar));
		BIT bt=new BIT(n);
		for(int i=0;i<n;i++)
		{
			bt.update(i,1);
		}
		for(int g=0;g<q;g++)
		{
			int k=in.nextInt();
			int start=0,end=n,mid=0;
			while(start<end)
			{
				mid=(start+end)/2;
				int valSum=bt.getSum(mid);
				if(valSum>=k)
				{
					end=mid;
				}
				else
				{
					start=mid+1;
				}
			}
			pw.print(ar[start]+"\n");
			bt.update(start,-1);
		}
		pw.close();
	}
	static class BIT
	{
		int ar[];
		int n;
		public BIT(int x)
		{
			n=x;
			ar=new int[n+1];
		}
		void update(int index,int val)
		{
			index++;
			while(index<=n)
			{
				ar[index]+=val;
				index+=((index)&(-index));
			}
		}
		int getSum(int index)
		{
			index++;
			int sum=0;
			while(index>0)
			{
				sum+=ar[index];
				index-=(index&(-index));
			}
			return sum;
		}
	}
}