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
	public static void main(String args[])
	{
		new Thread(null, new Abc(),"Abc",1<<26).start();
	}
	public void run()
	{
		FastReader in=new FastReader();
		int root=in.nextInt();
		int rootVal=in.nextInt();
		HashMap<Integer,Integer> values=new HashMap<>();
		HashMap<Integer,Integer> parent=new HashMap<>();
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
		parent.put(root,-1);
		map.put(root,new ArrayList<>());
		values.put(root,rootVal);
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int ch=in.nextInt();
			if(ch==0)
			{
				int u,v,val;
				u=in.nextInt();
				v=in.nextInt();
				val=in.nextInt();
				parent.put(v,u);
				values.put(v,val);

				ArrayList<Integer> ar=map.get(u);
				ar.add(v);
				ArrayList<Integer> br=new ArrayList<>();
				br.add(u);
				map.put(u,ar);
				map.put(v,br);
			}
			else if(ch==1)
			{
				int v,k;
				v=in.nextInt();
				k=in.nextInt();
				int maxXorVal=0;
				int maxVal=0;
				int source=v;
				int rootXor=k^rootVal;
				if(rootXor>maxXorVal)
				{
					maxXorVal=rootXor;
					maxVal=rootVal;
				}
				while(parent.get(source)!=-1)
				{
					int xorVal=k^values.get(source);
					if(xorVal>maxXorVal)
					{
						maxXorVal=xorVal;
						maxVal=values.get(source);
					}
					source=parent.get(source);
				}
				source=v;
				int maxXorFreq=0;
				if((values.get(root))==maxVal)
				{
					maxXorFreq++;
				}
				while(parent.get(source)!=-1)
				{
					if((values.get(source))==maxVal)
					{
						maxXorFreq++;
					}
					source=parent.get(source);
				}
				System.out.println(maxVal+" "+maxXorFreq);
			}
			else
			{
				int u,v,k;
				u=in.nextInt();
				v=in.nextInt();
				k=in.nextInt();
				int valCount=0;
				HashMap<Integer,Integer> visited=new HashMap<>();
				for(HashMap.Entry<Integer,Integer> entry:values.entrySet())
				{
					visited.put(entry.getKey(),0);
				}
				visited.put(u,1);
				DFS(map,values,visited,k,u,v,0);
				System.out.println(reqCount);
			}
		}
	}
	static int reqCount;
	public static void DFS(HashMap<Integer,ArrayList<Integer>> map,HashMap<Integer,Integer> values,HashMap<Integer,Integer> visited,int k,int s,int dest,int count)
	{
		if(values.get(s)<k)
		{
			count++;
		}
		if(s!=dest)
		{
			ArrayList<Integer> ar=map.get(s);
			for(int i=0;i<ar.size();i++)
			{
				int v=ar.get(i);
				if(visited.get(v)==0)
				{
					visited.put(v,1);
					DFS(map,values,visited,k,v,dest,count);
				}
			}
		}
		else
		{
			reqCount=count;
		}
	}
}