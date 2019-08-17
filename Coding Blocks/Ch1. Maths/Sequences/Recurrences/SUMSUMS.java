import java.util.*;
import java.io.*;
class Abc
{
	static long mod=98765431;
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
		int n=in.nextInt();
		int t=in.nextInt();
		long c[]=new long[n];
		long matrix[][]={{0,1},{n-1,n-2}};
		rectify(matrix);
		long sum=0;
		for(int i=0;i<n;i++)
		{
			c[i]=in.nextInt();
			sum=(sum+c[i]+mod)%mod;
		}
		for(int i=0;i<n;i++)
		{
			long vector[][]={{c[i]},{sum-c[i]}};
			rectify(vector);
			long result[][]=dot(pow(matrix,t),vector);
			pw.println(result[0][0]);
		}
		pw.close();

	}
	public static long[][] dot(long A[][],long B[][])
	{
		long C[][]=new long[A.length][B[0].length];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<B[0].length;j++)
			{
				for(int k=0;k<A[0].length;k++)
				{
					C[i][j]=(C[i][j]+(A[i][k]*B[k][j])%mod+mod)%mod;
				}
			}
		}
		return C;
	}
	public static long[][] pow(long A[][],int n)
	{
		long result[][]=identity(A.length,A[0].length);
		while(n>0)
		{
			if (n%2==1)
			{
				result=dot(result,A);
			}
			A=dot(A,A);
			n/=2;
		}
		return result;
	}
	public static long[][] identity(int n,int m)
	{
		long C[][]=new long[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				C[i][j]=(i==j)?1:0;
			}
		}
		return C;
	}
	public static void rectify(long A[][])
	{
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<A[0].length;j++)
			{
				A[i][j]=(A[i][j]+mod)%mod;
			}
		}
	}
}