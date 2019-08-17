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
	static long mod=1000000007;
	public static void main(String[] args) {
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int t=in.nextInt();
		while(t-->0)
		{
			int n=in.nextInt();
			String s=Integer.toBinaryString(n);
			long r=0;
			for(int i=0;i<s.length();i++)
			{
				int c=s.charAt(i)-48;
				r=r*10+c;
				r%=(mod-1);
			}
			//pw.println(s);
			//pw.println(r);
			long res=pow(pow(2,r),2);
			pw.println(res);
		}
		pw.close();
	}
	public static long pow(long a,long n)
	{
		long result=1;
		while(n>0)
		{
			if(n%2==1)
			{
				result=(result*a)%mod;
			}
			a=(a*a)%mod;
			n/=2;
		}
		return result;
	}
}