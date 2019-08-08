import java.util.*;
import java.io.*;
public class Abc
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
  
	static long ten=(long)Math.pow(10,18);
	static PrintWriter pw=new PrintWriter(System.out);
	public static void main(String[] args) {
		FastReader in=new FastReader();
		
		int t=in.nextInt();
		assertion(t,1,100);
		for(int g=0;g<t;g++)
		{
			long n,k;
			n=in.nextLong();
			k=in.nextLong();
			//System.out.println(n+" "+k);
			assertion(n,1,ten);
			assertion(k,2,ten);
			BFS(n,k);
		}
		pw.close();
	}
	public static void BFS(long n,long k)
	{
		Queue<Long> q=new LinkedList<>();
		HashMap<Long,Long> map=new HashMap<>();
		q.add(n);
		map.put(n,0l);
		while(!q.isEmpty())
		{
			long u=q.poll();
			//System.out.println("Pulled out "+u);
			long a,b;
			a=u-(u%k);
			b=u/k;
			if(u!=a&&map.get(a)==null)
			{
				map.put(a,map.get(u)+(u%k));
				q.add(a);
				if(a==0l)
					break;
				//System.out.println("Put : "+a+" "+map.get(a));
			}
			if(u%k==0&&(map.get(b)==null))
			{
				map.put(b,map.get(u)+1);
				q.add(b);
				if(b==0l)
					break;
				//System.out.println("Put : "+b+" "+map.get(b));
			}
		}
		pw.println(map.get(0l));
	}
	public static void assertion(long a,long b,long c)
	{
		if(a<b||a>c)
			System.exit(0);
	}
}