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
	static long sum;
	static int N;
	public static void main(String[] args) {
		FastReader in=new FastReader();
		int t=in.nextInt();
		int x=1;
		while(t-->0)
		{
			sum=0l;
			N=in.nextInt();
			ArrayList<Integer> ar[]=new ArrayList[N];
			Integer map[][]=new Integer[N][N];
			for(int i=0;i<N;i++)
			{
				ar[i]=new ArrayList<>();
			}
			for(int i=0;i<N-1;i++)
			{
				int a,b,c;
				a=in.nextInt();
				b=in.nextInt();
				c=in.nextInt();
				a--;
				b--;
				ar[a].add(b);
				ar[b].add(a);
				int A,B;
				A=Math.min(a,b);
				B=Math.max(a,b);
				map[A][B]=c;
			}
			int visited[]=new int[N];
			int children[]=new int[N];
			int parent[]=new int[N];
			parent[0]=-1;
			visited[0]=1;
			sum=0;
			DFS(ar,visited,children,map,parent,0);
			System.out.println("Case #"+x+": "+sum);
			x++;
		}
	}
	public static void DFS(ArrayList<Integer> ar[],int visited[],int children[],Integer map[][],int parent[],int s)
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				parent[v]=s;
				DFS(ar,visited,children,map,parent,v);
				children[s]+=children[v]+1;
			}
		}
		if (parent[s]==-1)
			return;
		int n=children[s]+1;
		int A,B;
		A=Math.min(s,parent[s]);
		B=Math.max(s,parent[s]);
		long cost=2*Math.min(n,N-n)*map[A][B];
		sum+=cost;
		//System.out.println("Children : "+children[s]+" weight "+map.get(node));
		//System.out.println("Cost "+s+" : "+cost);
	}
}