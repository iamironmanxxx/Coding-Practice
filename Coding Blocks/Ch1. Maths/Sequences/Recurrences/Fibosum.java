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
			//System.out.println("\n#"+t);
			int n,m;
			n=in.nextInt();
			m=in.nextInt();
			long sum_m=sum(m);
			//System.out.println(sum_m);
			long sum_n=sum(n-1);
			//System.out.println(sum_n);
			System.out.println((sum_m-sum_n+mod)%mod);
		}
	}
	public static long sum(int n)
	{
		if (n<=0)
			return 0l;
		long matrix[][]={{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,0},{-2,-2,3,1,1},{0,0,0,0,1}};
		long vector[][]={{1},{2},{4},{7},{-1}};
		matrix=rectify(matrix);
		vector=rectify(vector);
		long result[][]=dot(pow(matrix,n-1),vector);
		//print(result);
		return result[0][0];
	}
	public static void print(long a[][])
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static long[][] rectify(long A[][])
	{
		long C[][]=new long[A.length][A[0].length];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<A[0].length;j++)
			{
				C[i][j]=(A[i][j]+mod)%mod;
			}
		}
		return C;
	}
	public static long[][] dot(long A[][], long B[][])
	{
		long[][] C=new long[A.length][B[0].length];
		for(int i=0;i<A.length;i++)
		{
			for(int j=0;j<B[0].length;j++)
			{
				for(int k=0;k<A[0].length;k++)
				{
					C[i][j]+=(A[i][k]*B[k][j])%mod;
					C[i][j]+=mod;
					C[i][j]%=mod;
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
			if(n%2==1)
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
	public static long fiboacci(int n)
	{
		long vector[][]={{1},{1}};
		long matrix[][]={{0,1},{1,1}};
		long result[][]=dot(pow(matrix,n-1),vector);
		return result[0][0];
	}
}