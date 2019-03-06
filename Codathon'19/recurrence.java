import java.util.*;
import java.io.*;
class Abc
{
	static long mod=1000000007;
	static PrintWriter pw;
	public static void main(String args[])
	{
		pw=new PrintWriter(System.out);
		FastReader in=new FastReader();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			long T1[][]={{0,1,0,0,0},
						{0,0,1,0,0},
						{0,0,0,1,0},
						{-3,3,-1,2,1},
						{0,0,0,0,1}};
			long T2[][]={{0,1,0,0,0},
						{0,0,1,0,0},
						{0,0,0,1,0},
					    {-2,2,-1,2,1},
						{0,0,0,0,1}};
			//print(T);
			long a,b,c;
			a=in.nextLong();
			b=in.nextLong();
			c=in.nextLong();
			long y=in.nextLong();
			long F[]=new long[5];
			F[0]=a;
			F[1]=b;
			F[2]=c;
			F[3]=(c+(3*a)+(2*3))%mod;
			F[4]=2;
			long[][] T=T1;
			if((((3*a)+(2*3))/a)%2==0)
			{
				F[3]=(c+(2*a)+(3*3))%mod;
				F[4]=3;
				T=T2;
			}
			if(y<3)
			{
				long res=(y==1)?b:(y==2)?c:(y==0)?a:-1;
				pw.print(res+"\n");
				continue;
			}
			long Tpr[][]=pow(T,y-1);
			//print(Tpr);
			long res = 0;
	    	for(int i=0;i<5;i++)
	        res = (res + (Tpr[1][i] * F[i])) % mod;
	    	pw.print(res+"\n");
		}
		pw.close();
	}
	public static long[][] mul(long A[][],long B[][])
	{
		long C[][]=new long[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				for(int k=0;k<5;k++)
				{
					C[i][j]=(C[i][j]+(A[i][k]*B[k][j]))%mod;
				}
			}
		}
		return C;
	}
	static long[][] pow(long[][] A, long p)
	{
		if(p==1)
		{
			return A;
		}
	    if (p % 2==1)
	        return mul(A, pow(A, p-1));
	    long[][] X = pow(A, p/2);
	    return mul(X, X);
	}
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
}