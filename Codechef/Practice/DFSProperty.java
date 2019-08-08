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
	public static void main(String[] args) {
		new Thread(null,new Abc(),"Abc",1<<26).start(); 
	}
	public static void update(int index,int val)
	{
		while(index<bit.length)
		{
			bit[index]+=val;
			index+=-index&index;
		}
	}
	public static int getSum(int index)
	{
		int sum=0;
		while(index>0)
		{
			sum+=bit[index];
			index-=index&(-index);
		}
		return sum;
	}
	static int inTime[];
	static int out[];
	static int val[];
	static int visited[];
	static int bit[];
	static int count=0;
	public static void DFS(ArrayList<Integer> ar[],int s)
	{
		count++;
		//System.out.println(count+" "+s);
		val[count]=s;
		inTime[s]=count;
		for(int i=0;i<ar[s].size();i++)
		{
			int v=ar[s].get(i);
			if(visited[v]==0)
			{
				visited[v]=1;
				DFS(ar,v);
			}
		}
		out[s]=count;
	}
	public void run()
	{
		FastReader in=new FastReader();
		int n,q;
		n=in.nextInt();
		q=in.nextInt();
		ArrayList<Integer> ar[]=new ArrayList[n+1];
		inTime=new int[n+1];
		out=new int[n+1];
		val=new int[n+1];
		bit=new int[n+1];
		visited=new int[n+1];
		count=0;
		int cost[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			ar[i]=new ArrayList<>();
		}
		for(int i=0;i<n-1;i++)
		{
			int b,a;
			a=in.nextInt();
			b=in.nextInt();
			ar[a].add(b);
			ar[b].add(a);
		}
		visited[1]=1;
		DFS(ar,1);
		for(int i=1;i<=n;i++)
		{
			cost[i]=in.nextInt();
			if(cost[i]==0)
			{
				update(i,1);
			}
		}
		for (int i=0;i<q;i++)
		{
			char c=in.next().charAt(0);
			int x=in.nextInt();
			int start,end;
			start=inTime[x];
			end=out[x];
			if (c=='Q')
			{
				int endSum=getSum(end);
				int startSum=getSum(start-1);
				System.out.println(endSum-startSum);
			}
			else
			{
				int v=in.nextInt();
				if(cost[x]==0)
				{
					cost[x]+=v;
					if(cost[x]!=0)
					{
						update(start,-1);
					}
				}
				else
				{
					cost[x]+=v;
					if(cost[x]==0)
					{
						update(start,1);
					}
				}

			}
		}
	}
}