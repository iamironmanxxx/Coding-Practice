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
    static int connected[];
    static Stack<Integer> st;
    static int visited[];
    static ArrayList<Integer> ar[],aComplement[];
    static int compVisit[];
	static Queue<Integer> queue;
	static long mod=1000000021;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int n,m,k;
			n=in.nextInt();
			m=in.nextInt();
			k=in.nextInt();
			long b[]=new long[n];
			for(int i=0;i<n;i++)
			{
				b[i]=in.nextLong();
			}
			ar=new ArrayList[n];
			init(ar);
			for(int i=0;i<m;i++)
			{
				int u,v;
				u=in.nextInt();
				v=in.nextInt();
				u--;
				v--;
				ar[u].add(v);
			}
			

			connected=new int[n];

			//generate Complement of G
			aComplement=new ArrayList[n];
			init(aComplement);
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<ar[i].size();j++)
				{
					int v=ar[i].get(j);
					aComplement[v].add(i);
				}
			}

			st=new Stack<>();
			visited=new int[n];
			for(int i=0;i<n;i++)
			{
				if(visited[i]==0){
					DFS(ar,i,1,0);
				}	
			}

			int color=0;

			visited=new int[n];
			while(!st.isEmpty())
			{
				int val=st.pop();
				if(visited[val]==0){
					color++;
					DFS(aComplement,val,0,color);
				}

			}
			

			ArrayList<Integer> scc[]=new ArrayList[color];
			init(scc);
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<ar[i].size();j++)
				{
					int v=ar[i].get(j);
					if(connected[i]!=connected[v])
					{
						if(!scc[connected[i]-1].contains(connected[v]-1))
						{
							scc[connected[i]-1].add(connected[v]-1);
						}
					}
				}
			}


			queue=new LinkedList<>();
			topologicalSort(scc);



			//System.out.println(Arrays.toString(connected));
			//Now we have connected components
			long sum[]=new long[color];
			long min[]=new long[color];
			int count[]=new int[color];
			for(int i=0;i<color;i++)
			{
				min[i]=Long.MAX_VALUE;
			}

			for(int i=0;i<n;i++)
			{
				if(b[i]<min[connected[i]-1])
				{
					min[connected[i]-1]=b[i];
				}
				count[connected[i]-1]++;
			}

			for(int i=0;i<color;i++)
			{
				sum[i]=(count[i]*min[i])%mod;
			}
			//System.out.println(Arrays.toString(sum));
			long nodeSum[]=new long[color];
			

			while(!queue.isEmpty())
			{
				int u=queue.poll();
				nodeSum[u]=sum[u];
				long max=0;
				for(int i=0;i<scc[u].size();i++)
				{
					int v=scc[u].get(i);
					max=Math.max(max,nodeSum[v]);
				}
				//System.out.println("for node "+u+" sum is "+max+" nodesum= "+nodeSum[u]);
				nodeSum[u]=(nodeSum[u]+max)%mod;
			}
			//System.out.println(Arrays.toString(nodeSum));
			System.out.println(max(nodeSum));
		}
	}
	
	
	public static void DFS(ArrayList<Integer> ar[],int index,int flag,int color)
	{
		visited[index]=1;
		for(int i=0;i<ar[index].size();i++)
		{
			//System.out.println("Going for "+ar[index].get(i));
			if(visited[ar[index].get(i)]==0){
				DFS(ar,ar[index].get(i),flag,color);
			}
		}
		if(flag==1)
		{
			st.push(index);	
		}
		else
		{
			connected[index]=color;
		}
	}
	public static void init (ArrayList<Integer> ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=new ArrayList<>();
		}
	}
	static long max(long ar[])
	{
		long m=0;
		for(int i=0;i<ar.length;i++)
		{
			if(ar[i]>m)
			{
				m=ar[i];
			}
		}
		return m;
	}
	public static void topologicalSort(ArrayList<Integer> scc[])
	{
		int vis[]=new int[scc.length];

		for(int i=0;i<scc.length;i++)
		{
			if(vis[i]==0)
			{
				topologicalSortUtil(scc,vis,i);
			}
		}

	}
	public static void topologicalSortUtil(ArrayList<Integer> scc[],int vis[],int v)
	{
		vis[v]=1;
		for(int i=0;i<scc[v].size();i++)
		{
			int u=scc[v].get(i);
			if(vis[u]==0)
			{
				topologicalSortUtil(scc,vis,u);
			}
		}

		queue.add(v);
	}
}