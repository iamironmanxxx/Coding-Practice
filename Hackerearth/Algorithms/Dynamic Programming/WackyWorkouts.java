import java.util.*;
class Abc
{
	static long mod=1000000007;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t--!=0)
		{
			long matrix[][]={
				{0,1},
				{1,1}
			};
			long f[]={1,1};
			long n=in.nextLong();
			n+=2;
			if(n>1)
			{
				matrix=pow(matrix,n-1);
			}
			long res=0;
			for(int i=0;i<matrix[0].length;i++)
			{
				res+=(matrix[0][i]*f[i])%mod;
				res%=mod;
			}
			System.out.println(res);
		}
	}
	static long[][] dot(long X[][],long Y[][])
	{
		long res[][]=new long[X.length][X[0].length];
		for(int i=0;i<X.length;i++)
		{
			for(int j=0;j<X[0].length;j++)
			{
				for(int k=0;k<Y[0].length;k++)
				{
					res[i][j]=(res[i][j]+(X[i][k]*Y[k][j])%mod)%mod;
				}
			}
		}
		return res;
	}
	static long[][] pow(long A[][],long b)
	{
		if (b == 1)
	        return A;
	    if (b % 2==1)
	        return dot(A, pow(A, b-1));
	    long[][] X = pow(A, b/2);
	    return dot(X, X);
	}
}