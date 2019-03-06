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
	public static void main(String args[])
	{
		FastReader in=new FastReader();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			long n,k,x1,y1,c,d,e1,e2,f;
			n=in.nextLong();
			k=in.nextLong();
			x1=in.nextLong();
			y1=in.nextLong();
			c=in.nextLong();
			d=in.nextLong();
			e1=in.nextLong();
			e2=in.nextLong();
			f=in.nextLong();

			long x[]=new long[(int)n];
			long y[]=new long[(int)n];
			long ar[]=new long[(int)n];

			x[0]=x1;
			y[0]=y1;
			ar[0]=(x1+y1)%f;

			for(int i=1;i<n;i++)
			{
				x[i]=(c*x[i-1]+d*y[i-1]+e1)%f;
				y[i]=(d*x[i-1]+c*y[i-1]+e2)%f;
				ar[i]=(x[i]+y[i])%f;
			}

			long sum=(ar[0]*((n*k)%mod))%mod;
			long sm=k;
			for(int i=2;i<=n;i++)
			{
				long num=(i*((pow(i,k)-1+mod)%mod));
				sm+=(num*modInverse((i-1+mod)%mod))%mod;
				sm%=mod;
				sum+=(ar[i-1]*(((n+1-i+mod)%mod*sm)%mod)+mod)%mod;
				sum%=mod;
			}
			System.out.println("Case #"+(g+1)+": "+sum);
		}
	}
	static long mod=1000000007;
	public static long pow(long a,long b)
	{
		long result=1;
		while(b>0)
		{
			if(b%2==1)
			{
				result=(result*a)%mod;
			}
			a=(a*a)%mod;
			b/=2;
		}
		return result%mod;
	}
	static long xgcd,ygcd;
	public static long modInverse(long a)
	{
		gcd(a,mod);
		return(xgcd%mod+mod)%mod;
	}
	public static void gcd(long a,long b)
	{
		if(b==0)
		{
			xgcd=1;
			ygcd=0;
		}
		else
		{
			gcd(b,a%b);
			long temp=xgcd;
			xgcd=ygcd;
			ygcd=temp-((a/b)*ygcd);

		}
	}
}