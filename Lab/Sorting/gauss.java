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
	static class Node{
		int x,y;
		Node(int a,int b)
		{
			x=Math.max(a,b);
			y=Math.min(a,b);
		}
		public boolean equals(Object obj)
		{
			if(obj==this)
			{
				return true;
			}
			if(obj.getClass()!=this.getClass())
			{
				return false;
			}
			Node n=(Node)obj;
			if(x==n.x&&y==n.y)
			{
				return true;
			}
			return false;
		}
		public int hashCode()
		{
			return (int)(x*1000+y);
		}
	}
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		long ar[]=new long[1000];
		for(int g=0;g<t;g++)
		{
			int n=in.nextInt();
			for(int i=0;i<n;i++)
			{
				ar[i]=in.nextLong();
			}
			HashMap<Long,ArrayList<Node>> apSum=new HashMap<>();
			HashMap<Long,ArrayList<Node>> gpSum=new HashMap<>();
			HashMap<Node,Integer> set=new HashMap<>(); 
			for(int i=0;i<n-1;i++)
			{
				for(int j=i+1;j<n;j++)
				{
					long sum=ar[i]+ar[j];
					long gsum=ar[i]*ar[j];
					//System.out.println("Putting "+gsum);
					if(apSum.get(sum)==null)
					{
						ArrayList<Node> a=new ArrayList<>();
						a.add(new Node(i,j));
						apSum.put(sum,a);
					}
					else
					{
						ArrayList<Node> a=apSum.get(sum);
						a.add(new Node(i,j));
						apSum.put(sum,a);
					}
					if(gpSum.get(gsum)==null)
					{
						ArrayList<Node> a=new ArrayList<>();
						a.add(new Node(i,j));
						gpSum.put(gsum,a);
					}
					else
					{
						ArrayList<Node> a=gpSum.get(gsum);
						a.add(new Node(i,j));
						gpSum.put(gsum,a);
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				ArrayList<Node> a;
				a=apSum.get(2*ar[i]);
				if(a==null)
				{
					continue;
				}
				for(int j=0;j<a.size();j++)
				{
					Node u=a.get(j);
					//System.out.println("Found : "+(2*ar[i])+" "+ar[i]+" "+ar[u.x]+" "+ar[u.y]);
					if(u.x==i||u.y==i||ar[u.x]==ar[i])
					{
						continue;
					}
					//System.out.println("Found : "+(2*ar[i])+" "+ar[i]+" "+ar[u.x]+" "+ar[u.y]);
					Node v=new Node(i,u.x);
					if(set.get(v)==null)
						set.put(v,1);
					else
						set.put(v,set.get(v)+1);
					v=new Node(i,u.y);
					if(set.get(v)==null)
						set.put(v,1);
					else
						set.put(v,set.get(v)+1);
					if(set.get(u)==null)
						set.put(u,1);
					else
						set.put(u,set.get(u)+1);
				}
			}
			long count=0;
			for(int i=0;i<n;i++)
			{
				ArrayList<Node> a;
				a=gpSum.get(ar[i]*ar[i]);
				if(a==null)
				{
					continue;
				}
				for(int j=0;j<a.size();j++)
				{
					Node u=a.get(j);
					if(u.x==i||u.y==i||ar[u.x]==ar[i])
					{
						continue;
					}
					//System.out.println("Found : "+(ar[i]*ar[i])+" "+ar[i]+" "+ar[u.x]+" "+ar[u.y]);
					Node v=new Node(u.x,i);
					if(set.get(v)!=null)
					{
						count+=set.get(v);
					}
					//System.out.println(count);
					v=new Node(u.y,i);
					if(set.get(v)!=null)
					{
						count+=set.get(v);
					}
					//System.out.println(count);
					if(set.get(u)!=null)
					{
						count+=set.get(u);
					}
					//System.out.println(count);
				}
			}
			System.out.println(count);
		}
	}
}