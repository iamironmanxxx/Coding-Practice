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
		int n=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n];
		int k[]=new int[n];
		for(int i=0;i<n;i++)
		{
			k[i]=in.nextInt();
		}
		for(int i=0;i<n-1;i++)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			a--;
			b--;
			if(ar[a]==null)
			{
				ar[a]=new ArrayList<>();
			}
			if(ar[b]==null)
			{
				ar[b]=new ArrayList<>();
			}
			ar[a].add(b);
			ar[b].add(a);
		}
		int dist[][]=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<n;i++)
		{
			bfs(ar,n,dist,i);
			Arrays.sort(dist[i]);
			//System.out.println(Arrays.toString(dist[i]));
			
		}
		int d[]=new int[n];
		for(int i=0;i<n;i++)
		{
			int max=dist[i][n-k[i]];
			d[i]=max-1;
		}
		print(d);
	}
	public static void print(int ar[])
	{
		PrintWriter pw=new PrintWriter(System.out);
		for(int i=0;i<ar.length;i++)
		{
			pw.print(ar[i]+" ");
		}
		pw.print("\n");
		pw.close();
	}
	public static void bfs(ArrayList<Integer> ar[],int n,int dist[][],int s)
	{
		int visited[]=new int[n];
		Queue<Integer> q=new LinkedList<>();
		dist[s][s]=0;
		q.add(s);
		visited[s]=1;
		while(!q.isEmpty())
		{
			int u=q.poll();
			for(int i=0;i<ar[u].size();i++)
			{
				int v=ar[u].get(i);
				if(visited[v]==0)
				{
					dist[s][v]=dist[s][u]+1;
					visited[v]=1;
					q.add(v);
				}
			}
		}
	}
}