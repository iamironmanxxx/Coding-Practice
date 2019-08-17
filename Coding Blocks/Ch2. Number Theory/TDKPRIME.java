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
	static int limit=87000008;
	static int f[]=new int[limit/64+1];
	static ArrayList<Integer> primes=new ArrayList<>();
	public static int checkIfNotPrime(int f[],int x)
	{
		return (f[x/64]&(1<<((x>>1)&31)));
	}
	public static void makeComposite(int f[],int x)
	{
		f[x/64]|=(1<<((x>>1)&31));
	}
	public static void sieve()
	{
		for(int i=3;i<=Math.sqrt(limit);i+=2)
		{
			if(checkIfNotPrime(f,i)==0)
			{
				for(int j=i*i;j<limit;j+=2*i)
				{
					makeComposite(f,j);
				}
			}
		}
		primes.add(2);
		for(int i=3;i<limit;i+=2)
		{
			if(checkIfNotPrime(f,i)==0)
				primes.add(i);
		}
		//System.out.println(primes.size());
	}
	public static void main(String[] args) {
		FastReader in=new FastReader();
		PrintWriter pw=new PrintWriter(System.out);
		int t=in.nextInt();
		sieve();
		while(t-->0)
		{
			int n=in.nextInt();
			pw.println(primes.get(n-1));
		}
		pw.close();
	}
}