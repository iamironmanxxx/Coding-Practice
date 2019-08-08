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
	static class Subset
	{
		int parent;
		int rank;
	}
	static class Node
	{
		int a,b;
		String s;
	}
	public static int find(Subset sets[],int i)
	{
		if(sets[i].parent!=i)
		{
			sets[i].parent=find(sets,sets[i].parent);
		}
		return sets[i].parent;
	}
	public static void union(Subset sets[],int x,int y)
	{
		int xRoot=find(sets,x);
		int yRoot=find(sets,y);
		if(sets[xRoot].rank<sets[yRoot].rank)
		{
			sets[xRoot].parent=yRoot;
		}
		else if(sets[xRoot].rank>sets[yRoot].rank)
		{
			sets[yRoot].parent=xRoot;
		}
		else
		{
			sets[xRoot].parent=yRoot;
			sets[yRoot].rank++;
		}
	}
	public static void main(String[] args) {
		new Thread(null, new Abc(),"Abc",1<<26).start();
	}
	public void run()
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		while(t--!=0)
		{
			int n,k;
			n=in.nextInt();
			k=in.nextInt();
			int flag=0;
			Subset sets[]=new Subset[n];
			for(int i=0;i<n;i++)
			{
				sets[i]=new Subset();
				sets[i].parent=i;
			}
			Node nodes[]=new Node[k];
			for(int i=0;i<k;i++)
			{
				nodes[i]=new Node();
				nodes[i].a=in.nextInt()-1;
				nodes[i].s=in.next();
				nodes[i].b=in.nextInt()-1;
			}
			Arrays.sort(nodes,new Comparator<Node>(){
				public int compare(Node a,Node b)
				{
					if(a.s.equals(b.s))
						return 0;
					else if(a.s.equals("="))
						return -1;
					else
						return 1;
				}
			});
			for(int i=0;i<k;i++)
			{
				if(nodes[i].s.equals("="))
				{
					union(sets,nodes[i].a,nodes[i].b);
				}
				else
				{
					if(find(sets,nodes[i].a)==find(sets,nodes[i].b))
					{
						flag=1;
						break;
					}
				}
			}
			if(flag==1)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
	}
}