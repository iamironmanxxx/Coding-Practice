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
	public static void main(String[] args) 
	{
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int t=in.nextInt();
		int f[]=new int[51];
		for(int i=3;i<=Math.sqrt(50);i+=2)
		{
			if(f[i]==0)
			{
				for(int j=i*i;j<=50;j+=2*i)
				{
					f[j]=1;
				}
			}
		}
		while(t-->0)
		{
			int n,r,m;
			n=in.nextInt();
			r=in.nextInt();
			m=in.nextInt();
			ArrayList<Integer> primes=new ArrayList<>();
			if(m%2==0)
			{
				primes.add(2);
			}
			for(int i=3;i<=50;i+=2)
			{
				if(m%i==0&&f[i]==0)
				{
					primes.add(i);
				}
			}
			long num[]=new long[primes.size()];
			long rem[]=new long[primes.size()];
			long pp[]=new long[primes.size()];
			long inv[]=new long[primes.size()];
			long prod=1;
			for(int i=0;i<primes.size();i++)
			{
				int prime=primes.get(i);
				num[i]=prime;
				rem[i]=nCr(n,r,prime);
				pp[i]=m/prime;
				inv[i]=pow(pp[i],prime-2,prime);
			}
			long sum=0;
			for(int i=0;i<primes.size();i++)
			{
				sum+=(((rem[i]*pp[i])%m*inv[i])%m);
			}
			sum%=m;
			sum%=mod;
			pw.println(sum);
		}
		pw.close();
	}
	public static long nCr(long n,long r,long m)
	{
		long prod=1;
		while(r>0)
		{
			long n_rem=n%m;
			long r_rem=r%m;
			prod*=calculate(n_rem,r_rem,m);
			prod%=m;
			n/=m;
			r/=m;
		}
		return prod;
	}
	public static long calculate(long n,long r,long m)
	{
		long C[]=new long[(int)r+1];
		C[0]=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=Math.min(i,(int)r);j>0;j--)
			{
				C[j]=(C[j]+C[j-1])%m;
			}
		}
		return C[(int)r];
	}
	public static long pow(long a,long n,long m)
	{
		long result=1;
		while(n>0)
		{
			if(n%2==1)
			{
				result=(result*a)%m;
			}
			a=(a*a)%m;
			n/=2;
		}
		return result;
	}
}