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
	static long count;
	static long mod=1000000007;
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		while(t--!=0)
		{
			int n=in.nextInt();
			int ar[]=new int[n];
			dp=new long[n][8];
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			int visited[]=new int[n];
			visited[0]=1;
			long count=func(ar,0,0,visited);
			/*for(int i=0;i<8;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(dp[j][i]+" ");
				}
				System.out.println();
			}*/
			System.out.println(count);
		}
	}
	static long dp[][];
	static long func(int ar[],int index,int caller,int visited[])
	{
		int a1,a2,a3,a4;

		if(index-2<0)
			a1=1;
		else 
			a1=visited[index-2];
		if(index-1<0)
			a2=1;
		else 
			a2=visited[index-1];
		if(index+1>=ar.length)
			a3=1;
		else 
			a3=visited[index+1];
		if(index+2>=ar.length)
			a4=1;
		else 
			a4=visited[index+2];
		if(caller==index)
		{
			if(dp[index][0]==0)
			{
				dp[index][0]=1;
				if(index+1<ar.length)
				{
					funcCaller(index,index+1,ar,visited,0);
				}
				if(ar[index]==2&&index+2<ar.length)
				{
					funcCaller(index,index+2,ar,visited,0);
				}
			}
			return dp[index][0];
		}
		else if(caller==index-2)
		{
			if(a2==0)
			{
				if(dp[index][0]==0)
				{
					dp[index][0]=1;
					if(index+1<ar.length)
					{
						funcCaller(index,index+1,ar,visited,0);
					}
					if(index+2<ar.length&&ar[index]==2)
					{
						funcCaller(index,index+2,ar,visited,0);
					}
					if(index-1>=0)
					{
						funcCaller(index,index-1,ar,visited,0);
					}
				}
				return dp[index][0];
			}
			else
			{
				if(dp[index][1]==0)
				{
					dp[index][1]=1;
					if(index+1<ar.length)
					{
						funcCaller(index,index+1,ar,visited,1);
					}
					if(index+2<ar.length&&ar[index]==2)
					{
						funcCaller(index,index+2,ar,visited,1);
					}
				}
				return dp[index][1];
			}
		}
		else if(caller==index-1)
		{
			if(a1==0)
			{
				if(dp[index][2]==0)
				{
					dp[index][2]=1;
					if(index+1<ar.length)
					{
						funcCaller(index,index+1,ar,visited,2);
					}
					if(index+2<ar.length&&ar[index]==2)
					{
						funcCaller(index,index+2,ar,visited,2);
					}
				}
				return dp[index][2];
			}
			else
			{
				if(dp[index][3]==0)
				{
					dp[index][3]=1;
					if(index+1<ar.length)
					{
						funcCaller(index,index+1,ar,visited,3);
					}
					if(index+2<ar.length&&ar[index]==2)
					{
						funcCaller(index,index+2,ar,visited,3);
					}
					if(index-2>=0&&ar[index]==2)
					{
						funcCaller(index,index-2,ar,visited,3);
					}
				}
				return dp[index][3];
			}
		}
		else if(caller==index+1)
		{
			if(a1==0)
			{
				if(dp[index][4]==0)
				{
					dp[index][4]=1;
					if(ar[index]==2&&index-2>=0)
					{
						funcCaller(index,index-2,ar,visited,4);
					}
					if(index+2<ar.length&&ar[index]==2)
					{
						funcCaller(index,index+2,ar,visited,4);
					}
				}
				return dp[index][4];
			}
			else
			{
				if(dp[index][5]==0)
				{
					dp[index][5]=1;
					if(index+2<ar.length&&ar[index]==2)
					{
						funcCaller(index,index+2,ar,visited,5);
					}
				}
				return dp[index][5];
			}
		}
		else
		{
			if(a1==0)
			{
				if(dp[index][6]==0)
				{
					dp[index][6]=1;
					if(ar[index]==2&&index-2>=0)
					{
						funcCaller(index,index-2,ar,visited,6);
					}
				}
				return dp[index][6];
			}
			else
			{
				if(dp[index][7]==0)
					dp[index][7]=1;
				return dp[index][7];
			}
		}
		
	}
	static void funcCaller(int index,int dest,int ar[],int visited[],int ch)
	{
		if(visited[dest]==0){
			visited[dest]=1;
				dp[index][ch]+=func(ar,dest,index,visited);
				dp[index][ch]%=mod;
			visited[dest]=0;
		}
	}
}