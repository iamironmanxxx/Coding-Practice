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
	static int parent[];
	static int rank[];
	static int sum[];
	static int team[];
	public static int find(int i)
	{
		if(parent[i]==i)
			return i;
		else
		{
			parent[i]=find(parent[i]);
			return parent[i];
		}
	}
	public static void union(int x,int y)
	{
		int xroot=find(x);
		int yroot=find(y);
		if(xroot==yroot)
			return;
		if(rank[xroot]<rank[yroot])
		{
			parent[xroot]=yroot;
			sum[yroot]+=sum[xroot];
		}
		else if(rank[xroot]>rank[yroot])
		{
			parent[yroot]=xroot;
			sum[xroot]+=sum[yroot];
		}
		else
		{
			parent[xroot]=yroot;
			rank[yroot]++;
			sum[yroot]+=sum[xroot];
		}
	}
	static class Query
	{
		int l, r, idx;
	}
	static int cmp(Query a,Query b)
	{
		if(a.r<b.r)
			return -1;
		else if(a.r>b.r)
			return 1;
		return 0;
	}
	static int query(int idx, int bit[], int n) 
	{ 
	    int sum = 0; 
	    for (; idx>0; idx-=(idx&-idx)) 
	        sum += bit[idx]; 
	    return sum; 
	} 
	static int MAX=1000001;
	static int ans[];
	static void answeringQueries(int arr[], int n, Query queries[], int q) 
	{ 
	    int bit[]=new int[n+1]; 
	    int last_visit[]=new int[MAX]; 
	    for(int i=0;i<last_visit.length;i++)
	    {
	    	last_visit[i]=-1;
	    } 
	  
	    // answer for each query 
	    ans=new int[q]; 
	    int query_counter = 0; 
	    for (int i=0; i<n; i++) 
	    { 
	        if (last_visit[arr[i]] !=-1) 
	            update (last_visit[arr[i]] + 1, -1, bit, n); 
	  
	        last_visit[arr[i]] = i; 
	        update(i + 1, 1, bit, n); 
	  
	        while (query_counter < q && queries[query_counter].r == i) 
	        { 
	            ans[queries[query_counter].idx] = 
	                     query(queries[query_counter].r + 1, bit, n)- 
	                     query(queries[query_counter].l, bit, n); 
	            query_counter++; 
	        } 
	    } 
	} 
	public static void update(int idx, int val, int bit[], int n) 
	{ 
	    for(; idx<=n;idx+=idx&-idx) 
	        bit[idx] += val; 
	} 

	public static void main(String args[])
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int n=in.nextInt();
		int m=in.nextInt();
		int q=in.nextInt();
		parent=new int[n];
		rank=new int[n];
		sum=new int[n];
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
			sum[i]=1;
		}
		for(int i=0;i<m;i++)
		{
			int a=in.nextInt();
			int b=in.nextInt();
			a--;
			b--;
			int aParity=(sum[find(a)]%2);
			int bParity=(sum[find(b)]%2);
			if(aParity==bParity)
			{
				union(a,b);
			}
		}
		team=new int[n];
		for(int i=0;i<n;i++)
		{
			team[i]=find(i);
		}
		//pw.println(Arrays.toString(team));

		Query query[]=new Query[q];
		for(int i=0;i<q;i++)
		{
			query[i]=new Query();
			query[i].l=in.nextInt()-1;
			query[i].r=in.nextInt()-1;
			query[i].idx=i;
		}
		Arrays.sort(query,new Comparator<Query>(){
			public int compare(Query a,Query b)
			{
				return cmp(a,b);
			}
		});
		answeringQueries(team,team.length,query,q);
		//ans=new int[q];
		for(int i=0;i<q;i++)
		{
			pw.println(ans[i]);
		}
		pw.close();
	}
}