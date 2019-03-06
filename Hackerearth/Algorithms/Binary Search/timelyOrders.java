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
	static class Node{
		int time;
		long load;
		Node(int t,long l)
		{
			time=t;
			load=l;
		}
		public boolean equals(Object obj)
		{
			if(this==obj)
			{
				return true;
			}
			if(this.getClass()!=obj.getClass())
			{
				return false;
			}
			Node n=(Node)obj;
			if(n.time==time&&n.load==load)
			{
				return true;
			}
			return false;
		}
		int compare(Node n)
		{
			if(time<n.time)
				return -1;
			else if(time>n.time)
				return 1;
			return 0;
		}
	}
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int q=in.nextInt();
		Node ar[]=new Node[q];
		int ptr=0;
		for(int g=0;g<q;g++)
		{
			int ch=in.nextInt();
			if(ch==1)
			{
				int w,t;
				w=in.nextInt();
				t=in.nextInt();
				if(ptr==0)
				{
					ar[ptr++]=new Node(t,w);
				}
				else
				{
					ar[ptr]=new Node(t,ar[ptr-1].load+w);
					ptr++;
				}
			}
			else
			{
				int k,t;
				k=in.nextInt();
				t=in.nextInt();
				int l=t-k;

				int ind=Arrays.binarySearch(ar,0,ptr,new Node(l,0),new Comparator<Node>(){
					public int compare(Node a,Node b)
					{
						return a.compare(b);
					}
				});
				if(ind<0)
				{
					ind=(-ind)-1;
				}
				long lval=(ind==0)?0:ar[ind-1].load;
				long rval=(ptr>0)?ar[ptr-1].load:0;
				pw.print(rval-lval+"\n");
			}
		}
		pw.close();
	}
}