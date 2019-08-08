import java.util.*;
import java.io.*;
class Abc implements Runnable
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
	static class Node
	{
		int x;
		long y;
		public Node(int a,long b)
		{
			x=a;
			y=b;
		}
	}
	static long finalSum=0;
	public static void DFS(ArrayList<Integer> ar[],int s,int visited[])
	{
		count++;
		in[s]=count;
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				DFS(ar,v,visited);
			}
		}
		out[s]=count;
	}
	static ArrayList<Integer> tree[];
	static int val[];
	static ArrayList<Integer> merge(ArrayList<Integer> a,ArrayList<Integer> b)
	{
		ArrayList<Integer> ar=new ArrayList<>();
		int p1=0,p2=0;
		while(p1<a.size()&&p2<b.size())
		{
			if(a.get(p1)<=b.get(p2))
			{
				ar.add(a.get(p1));
				p1++;
			}
			else
			{
				ar.add(b.get(p2))
				p2++;
			}
		}
		while(p1<a.size())
		{
			ar.add(a.get(p1));
			p1++;
		}
		while(p2<b.size())
		{
			ar.add(b.get(p2));
			p2++;
		}

	}
	public static void buildTree(int n,int l,int r)
	{
		if(l==r)
		{
			if(tree[n]==null)
				tree[n]=new ArrayList<>();
			tree[n].add(cost[l]);
			return;
		}
		int mid=(l+r)/2;
		buildTree(2*n+1,l,mid);
		buildTree(2*n+2,mid+1,r);
		tree[n]=merge(tree[2*n+1],tree[2*n+2]);
	}
	public static int query(int n,long k,int l,int r,int start ,int end)
	{
		if(start>r||end<l)
		{
			return 0;
		}
		if (start>=l&&end<=r)
		{
			if(tree[n].size()==0)
			{
				return 0;
			}
			int pos=lowerBound();
			return tree.size()-pos;
		}
		int mid=(l+r)/2;
		q1=query(2*n+1,l,mid);
		q2=query(2*n+2,mid+1,r);
		return (q1+q2);
	}
	public static void main(String ags[])
	{
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	public static int lowerBound(ArrayList<Node> ar,long x)
	{
		int start=0,end=ar.size()-1,mid;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(ar.get(mid).y>=x)
				end=mid-1;
			else
				start=mid+1;
		}
		return start;

	}
	public static int upperBound(ArrayList<Node> ar,long y)
	{
		int start=0,end=ar.size()-1,mid;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(ar.get(mid).y<=y)
			{
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
		}
		return end;
	}
	static int in[];
	static int out[];
	static int count=0;
	static int visited[];
	static long cost[];
	public void run()
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int n,q,d;
		n=in.nextInt();
		q=in.nextInt();
		d=in.nextInt();
		d--;
		cost=new long[n];
		for(int i=0;i<n;i++)
		{
			cost[i]=in.nextLong();
		}
		ArrayList<Integer> ar[]=new ArrayList[n];
		tree=new ArrayList[4*n];
		val=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=new ArrayList<>();
		}
		for (int i=0;i<n-1;i++)
		{
			int a,b;
			a=in.nextInt();
			b=in.nextInt();
			a--;
			b--;
			ar[a].add(b);
			ar[b].add(a);
		}
		count=0;
		visited=new int[n];
		DFS(ar,d,visited);
		buildTree(0,0,n-1);
		int last=0;
		for(int i=0;i<q;i++)
		{
			int in1;
			long in2,in3;
			in1=in.nextInt();
			in2=in.nextLong();
			in3=in.nextLong();
			long x,y;
			int r;
			r=in1^last;
			x=in2^last;
			y=in3^last;

			int left,right;
			left=lowerBound(ans[r-1],x,y);
			right=upperBound(ans[r-1],x,y);
			int res=right-left+1;
			pw.println(res);
			last=res;//answer
		}
		pw.close();
	}
}