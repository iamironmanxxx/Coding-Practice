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
		int t=in.nextInt();
		PrintWriter pw=new PrintWriter(System.out);
		int limit=100000001;
		byte f[]=new byte[limit];
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
		ArrayList<Integer> primes=new ArrayList<>();
		primes.add(2);
		for(int i=3;i<limit;i+=2)
		{
			if(f[i]==0)
			{
				primes.add(i);
			}
		}
		//pw.println(primes.get(0)+" "+primes.get(1));
		while(t-->0)
		{
			long n=in.nextLong();
			long sum=1;
			long dup=n;
			for(int i=0;i<primes.size();i++)
			{
				int prime=primes.get(i);
				if(prime*prime>n)
					break;
				long count=0;
				if(n%prime==0)
				{
					while(n%prime==0)
					{
						n/=prime;
						count++;
					}
					// /pw.println(i+" comes "+count+" times");
					sum*=((pow(prime,count+1)-1)/(prime-1));
				}
			}
			if(n>1)
			{
				// /pw.println(n+" comes once");
				sum*=((pow(n,2)-1)/(n-1));
			}
			pw.println(sum-dup);
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
				result*=a;
			}
			a=a*a;
			n/=2;
		}
		return result;
	}
}