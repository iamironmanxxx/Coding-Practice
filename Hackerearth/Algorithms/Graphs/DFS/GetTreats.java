import java.io.*;
import java.util.*;
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
	public static void main(String[] args) {
		new Thread(null,new Abc(),"Abc",1<<26).start();
	}
	static FastReader in=new FastReader();
	public void run()
	{
		int t=in.nextInt();
		while(t--!=0)
		{
			int n=in.nextInt();
			int val[]=new int[n];
			ArrayList<Integer> ar[]=new ArrayList[n];
			init(ar);
			for(int i=0;i<n;i++)
			{
				val[i]=in.nextInt();
			}
			for(int i=0;i<n-1;i++)
			{
				int a,b;
				a=in.nextInt();
				b=in.nextInt();
				a--;
				b--;
				ar[a].add(b);
				ar[b].add(a);
			}
			int sum[]=new int[n];
			int visited[]=new int[n];
			int parent[]=new int[n];
			int revSum[]=new int[n];
			visited[0]=1;
			sumDFS(ar,0,visited,sum,val,parent);
			//print(sum);
			visited=new int[n];
			int res[]=new int[n];
			visited[0]=1;
			DFS(ar,0,visited,sum,val,parent,revSum,res);
			//print(revSum);s
			print(res);
		}
		pw.close();
	}
	static PrintWriter pw=new PrintWriter(System.out);
	public static void print(int ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			pw.print(ar[i]+" ");
		}
		pw.print("\n");
	}
	public static void DFS(ArrayList<Integer> ar[],int s,int visited[],int sum[],int val[],int parent[],int revSum[],int res[])
	{
		int parentVal=revSum[s];
		int childVal=max(ar,s,sum,-1,parent[s]);
		res[s]=val[s]+Math.max(childVal,parentVal);
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				revSum[v]=val[s]+Math.max(revSum[s],max(ar,s,sum,v,parent[s]));
				DFS(ar,v,visited,sum,val,parent,revSum,res);
			}
		}
	}
	public static int max(ArrayList<Integer> ar[],int s,int[] sum,int block,int parent)
	{
		int maxSum=0;
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(v==block||v==parent)
			{
				continue;
			}
			maxSum=Math.max(maxSum,sum[v]);
		}
		return maxSum;
	}
	public static void sumDFS(ArrayList<Integer> ar[],int s,int visited[],int sum[],int val[],int parent[])
	{
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				parent[v]=s;
				sumDFS(ar,v,visited,sum,val,parent);
				sum[s]=Math.max(sum[s],sum[v]);
			}
		}
		sum[s]+=val[s];
	}
	public static void init(ArrayList<Integer> ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			ar[i]=new ArrayList<>();
		}
	}
}