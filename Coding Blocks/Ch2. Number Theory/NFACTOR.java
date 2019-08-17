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
    static int res[][];
	public static void main(String[] args) {
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		preprocess();
		int t=in.nextInt();
		while(t-->0)
		{
			int a,b,n;
			a=in.nextInt();
			b=in.nextInt();
			n=in.nextInt();
			int a_val=res[n][a-1];
			int b_val=res[n][b];
			pw.println(-a_val+b_val);
		}
		pw.close();
	}
	public static void preprocess()
	{
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
		HashMap<Integer,Integer> answers=new HashMap<>();
		for(int i=2;i<limit;i++)
		{
			HashSet<Integer> set=new HashSet<>();
			int n=i;
			while(f[n]!=0&&n%f[n]==0)
			{
				set.add(f[n]);
				n/=f[n];
			}
			set.add(n);
			answers.put(i,set.size());
		}
		answers.put(1,0);
		res=new int[11][limit];
		for(int i=0;i<11;i++)
		{
			for(int j=1;j<limit;j++)
			{
				int n_val=answers.get(j);
				if(n_val==i)
					res[i][j]=1+res[i][j-1];
				else
					res[i][j]=res[i][j-1];
			}
		}
	}
}