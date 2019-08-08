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
		int x,y;
		Node(int a,int b)
		{
			x=a;
			y=b;
		}
		public boolean equals(Object obj)
		{
			if(this==obj)
				return true;
			if(this.getClass()!=obj.getClass())
				return false;
			Node n=(Node)obj;
			if((n.x==x&&n.y==y)||(n.x==y&&n.y==x))
				return true;
			return false;
		}
		public int hashCode()
		{
			return x+y;
		}
	}
	static int height=0;
	static int rootSum[];
	static int visited[];
	static int parent[];
	static int count=0;
	static HashMap<Node,Integer> map;
	static int begin[];
	static int end[];
	static int tree[];
	static int level[];
	static int preprocessArr[];

	public static void main(String[] args) {
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}

	public static void build(int n,int start,int end)
	{
		if(start==end)
		{
			tree[n]=rootSum[start];
			return;
		}
		int mid=(start+end)/2;
		build(2*n+1,start,mid);
		build(2*n+2,mid+1,end);
		tree[n]=tree[2*n+1]+tree[2*n+2];
	}
	public static void update(int root,int leftMin,int rightMax,int start,int end,int c)
	{
		if(leftMin>=start&&rightMax<=end)
			tree[root]+=c;
		else
		{
			update(2*root+1,leftMin,(rightMax+leftMin)/2,start,end,c);
			update(2*root+2,(rightMax+leftMin)/2+1,rightMax,start,end,c);
		}
	}
	public static int getSum(int u)
	{
		int sum=tree[u];
		while(u!=0)
		{
			//System.out.println("stuck");
			sum+=tree[u];
			u=(u-2)/2;
		}
		return sum;
	} 
	public static void DFS(ArrayList<Integer> ar[],int s,int sum)
	{
		count++;
		begin[s]=count;
		rootSum[s]=sum;
		//System.out.println();
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				parent[v]=s;
				level[v]=level[s]+1;
				height=Math.max(height,level[v]);
				DFS(ar,v,sum+map.get(new Node(s,v)));
			}
		}
		end[s]=count;
	}
	static void preprocess()
	{
		int nr=(int)(Math.sqrt(height));
		for(int i=1;i<level.length;i++)
		{
			if(level[i]<nr)
			{
				preprocessArr[i]=1;
			}
			else if(level[i]%nr==0)
			{
				preprocessArr[i]=parent[i];
			}
			else
			{
				preprocessArr[i]=preprocessArr[parent[i]];
			}
		}
	}
	public static int lca(int x,int y)
	{
		int lcaNode=0;
		while(preprocessArr[x]!=preprocessArr[y])
		{
			if(level[x]>level[y])
				x=preprocessArr[x];
			else
				y=preprocessArr[y];
		}
		while(x!=-1&&y!=-1&&x!=y)
		{
			if(level[x]>level[y])
				x=parent[x];
			else
				y=parent[x];
		}
		return x;
	}

	public void run()
	{
		FastReader in=new FastReader();
		int n=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n+1];
		map=new HashMap<>();
		Node vert[]=new Node[n-1];
		for(int i=0;i<=n;i++)
		{
			ar[i]=new ArrayList<>();
		}
		for(int i=0;i<n-1;i++)
		{
			int a,b,w;
			a=in.nextInt();
			b=in.nextInt();
			w=in.nextInt();
			ar[a].add(b);
			ar[b].add(a);
			vert[i]=new Node(a,b);
			map.put(new Node(a,b),w);
		}
		init(n);
		visited[1]=1;
		count=0;
		parent[1]=-1;
		DFS(ar,1,0);
		preprocess();
		build(1,1,n);
		//System.out.println(Arrays.toString(parent));
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int ch,a,b;
			ch=in.nextInt();
			a=in.nextInt();
			b=in.nextInt();
			if(ch==1)
			{
				a--;
				Node node=vert[a];
				int childNode=(parent[node.x]==node.y)?node.x:node.y;
				int prev=map.get(node);
				update(childNode,begin[childNode],end[childNode],1,n,b-prev);
				map.put(node,b-prev);
			}
			else
			{
				int aDist,bDist,lcaDist;
				aDist=getSum(a);
				bDist=getSum(b);
				int res=aDist+bDist-(2*getSum(lca(a,b)));
				System.out.println(res);
			}
		}
	}
	static void init(int n)
	{
		preprocessArr=new int[n+1];
		rootSum=new int[n+1];
		visited=new int[n+1];
		parent=new int[n+1];
		begin=new int[n+1];
		level=new int[n+1];
		end=new int[n+1];
		tree=new int[2*n+10];
	}
}