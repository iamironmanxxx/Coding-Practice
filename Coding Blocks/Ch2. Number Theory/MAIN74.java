import java.util.*;
import java.io.*;
class Abc
{
	static long mod=1000000007;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			long n=in.nextLong();
			long fact=fib(n+1);
			if(n==0)
			{
				System.out.println(0);
				continue;
			}
			else if(n==1)
			{
				System.out.println(2);
				continue;
			}
			System.out.println(fact);
		}
	}
	public static long fib(long n)
	{
		long vector[][]={{1},{1}};
		long matrix[][]={{0,1},{1,1}};
		long result[][]=dot(pow(matrix,n+1),vector);
		return result[0][0];
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
	public static long[][] pow(long A[][],long n)
	{
		long result[][]=identity(A.length,A[0].length);
		while(n>0)
		{
			if(n%2==1)
			{
				result=dot(result,A);
			}
			A=dot(A,A);
			n/=2;
		}
		return result;
	}
}