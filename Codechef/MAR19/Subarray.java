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
	static class BIT{
		int ar[];
		int n;
		public BIT(int x)
		{
			n=x+1;
			ar=new int[n];
		}
		void update(int index,int val)
		{
			index++;
			while(index<n)
			{
				ar[index]+=val;
				index+=index&(-index);
			}
		}
		int getSum(int index)
		{
			index++;
			int sum=0;
			while(index>0)
			{
				sum+=ar[index];
				index-=index&(-index);
			}
			return sum;
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
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			int count=0;
			for(int l=1;l<=n;l++)
			{
				BIT tree=new BIT(2001);
				int f[]=new int[2001];

				for(int i=0;i<l;i++)
				{
					f[ar[i]]++;
				}

				int m=(int)Math.ceil(k/(double)l);

				for(int i=0;i<l;i++)
				{
					tree.update(ar[i],m);
				}

				//kth smallest element
				int x=search(tree,k);

				if(f[f[x]]>=1)
				{
					count++;
				}

				int lptr=0;
				for(int i=l;i<n;i++)
				{
					//remove from freq array and add new element
					f[ar[i]]++;
					f[ar[lptr]]--;

					//remove from tree and add new element
					tree.update(ar[i],m);
					tree.update(ar[lptr],-m);

					//kth smallest element
					x=search(tree,k);
					if(f[f[x]]>=1)
					{
						count++;
					}

					lptr++;
				}

			}
			System.out.println(count);
		}
	}
	public static int search(BIT tree, int k)
	{
		int start=1,end=2001,mid;
		while(start<end)
		{
			mid=(start+end)/2;
			if(tree.getSum(mid)>=k)
			{
				end=mid;
			}
			else
			{
				start=mid+1;
			}
		}
		return start;
	}
}