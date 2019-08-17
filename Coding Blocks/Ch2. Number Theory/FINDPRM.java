import java.util.*;
import java.io.*;
class Abc
{
	static int limit=10000002;
	static byte f[]=new byte[limit];
	static int count[]=new int[limit];
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
		int t=in.nextInt();
		sieve();
		countFunc();
		while(t-->0)
		{
			int n=in.nextInt();
			int n2=n/2;
			//handle 0,1,2,3
			if(n==3)
			{
				pw.println(2);
				continue;
			}
			else if(n==2)
			{
				pw.println(1);
				continue;
			}
			else if(n==1||n==0)
			{
				pw.println(0);
				continue;
			}
			if(n%2==0)
				n-=1;
			if(n2%2==0&&n2!=2)
				n2-=1;
			pw.println(count[n]-count[n2]);
		}
		pw.close();
	}
	public static void sieve()
	{
		f[1]=(byte)1;
		f[0]=(byte)1;
		for(int i=4;i<limit;i+=2)
		{
			f[i]=(byte)1;
		}
		for(int i=3;i<limit;i+=2)
		{
			if(f[i]==(byte)0)
			{
				for(int j=i*i;j>0&&j<limit;j+=2*i)
				{
					f[j]=(byte)1;
				}
			}
		}
	}
	public static void countFunc()
	{
		count[2]=1;
		count[3]=2;
		for(int i=5;i<limit;i+=2)
		{
			count[i]=(f[i]==(byte)0)?1+count[i-2]:count[i-2];
		}
	}
}