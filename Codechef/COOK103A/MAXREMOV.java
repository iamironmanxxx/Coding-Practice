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
	static class Node{
		int l,r,ind;
		Node()
		{

		}
		Node(int x,int y,int i)
		{
			l=x;
			r=y;
			ind=i;
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
			if(n.l==l&&n.r==r)
			{
				return true;
			}
			return false;
		}
		public int compare(Node n)
		{
			if(l<n.l)
			{
				return -1;
			}
			else if(l>n.l)
			{
				return 1;
			}
			else 
			{
				if(r<n.r)
					return -1;
				else if(r>n.r)
					return 1;
				return 0;
			}
		}
	}
	public static void print(int ar[])
	{
		for(int i=0;i<10;i++)
		{
			System.out.print(ar[i]+" ");
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		int C=100001;
		for(int g=0;g<t;g++)
		{
			int q=in.nextInt();
			int k=in.nextInt();
			Node qr[]=new Node[q];
			for (int i=0;i<q;i++)
			{
				qr[i]=new Node();
			}
			int ar[]=new int[C+1];
			for(int i=0;i<q;i++)
			{
				int x,y;
				x=in.nextInt();
				y=in.nextInt();
				x--;
				y--;
				qr[i].l=x;
				qr[i].r=y;
				ar[x]+=1;
				ar[y+1]-=1;
			}



			for(int i=1;i<C;i++)
			{
				ar[i]=ar[i-1]+ar[i];
			}
			/*for(int i=0;i<C;i++)
			{
				ar[i]=ar[i]+1;
			}*/
			//print(ar);

			int f[]=new int[C];
			int f2[]=new int[C];
			for(int i=0;i<C;i++)
			{	
				if(ar[i]==k)
				{
					f[i]++;
				}
				if(ar[i]==k+1)
				{
					f2[i]++;
				}
			}
			for(int i=1;i<C;i++)
			{
				f[i]=f[i-1]+f[i];
				f2[i]=f2[i-1]+f2[i];
			}
			int total=f[C-1];
			//print(f);

			int ans[]=new int[q];
			for(int i=0;i<q;i++)
			{
				int left=(qr[i].l==0)?0:f[qr[i].l-1];
				int right=f[qr[i].r];
				int left2=(qr[i].l==0)?0:f2[qr[i].l-1];
				int right2=f2[qr[i].r];
				//System.out.println("left= "+left+" right= "+right);
				ans[i]=total-(right-left)+(right2-left2);
			}
			//System.out.println(Arrays.toString(ans));
			int max=0;
			for(int i=0;i<q;i++)
			{
				if(ans[i]>=max)
				{
					max=ans[i];
				}
			}
			System.out.println(max);
		}
	}
}