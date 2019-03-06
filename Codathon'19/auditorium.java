import java.io.*;
import java.util.*;
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
    static long mod=1000000007;
    public static void main(String args[])
    {
    	FastReader in=new FastReader();
    	PrintWriter pw=new PrintWriter(System.out);
    	int t=in.nextInt();
    	for(int g=0;g<t;g++)
    	{
    		long n=in.nextLong();
    		long t1=((exp(2,n-1)*(n%mod))+mod)%mod;
    		pw.print(((t1+mod)%mod)+"\n");
    	}
    	pw.close();
    }
    public static long exp(long a,long b)
    {
    	long res=1;
    	a%=mod;
    	while(b!=0)
    	{
    		if(b%2==1)
    		{
    			res=(res*a)%mod;
    		}
    		a=(a*a)%mod;
    		b/=2;
    	}
    	return ((res+mod)%mod);
    }

}