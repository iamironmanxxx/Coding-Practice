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
	public static void main(String[] args) {
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int limit=1000002;
		int f[]=new int[limit];
		for(int i=2;i*i<limit;i++)
		{
			if(f[i]==0)
			{
				for(int j=i*i;j<limit;j+=i)
				{
					if(f[j]==0)
						f[j]=i;
				}
			}
		}
		int t=in.nextInt();
		while(t-->0)
		{
			int n=in.nextInt();
			HashMap<Integer,Integer> map=new HashMap<>();
			while(f[n]!=0&&n%f[n]==0)
			{
				if(map.get(f[n])==null)
					map.put(f[n],1);
				else
					map.put(f[n],map.get(f[n])+1);
				n/=f[n];
			}
			if(map.get(n)==null)
				map.put(n,1);
			else
				map.put(n,map.get(n)+1);
			int max=0;
			for(Map.Entry<Integer,Integer> entry:map.entrySet())
			{
				//pw.println(entry.getKey()+" "+entry.getValue());
				if(max<entry.getValue())
				{
					max=entry.getValue();
				}
			}
			pw.println(max);
		}
		pw.close();
	}
}