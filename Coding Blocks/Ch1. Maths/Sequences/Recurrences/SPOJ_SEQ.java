import java.util.*;
import java.io.*;
class Abc
{
	static int mod=1000000000;
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			int k=in.nextInt();
			long vector[][]=new long[k][1];
			for (int i=0;i<k;i++)
			{
				vector[i][0]=in.nextInt();
			}
			long matrix[][]=new long[k][k];
			int index1=1,index2=0;
			int c[]=new int[k];
			for(int i=0;i<k;i++)
			{
				c[i]=in.nextInt();
			}
			for(int i=0;i<k;i++)
			{
				for(int j=0;j<k;j++)
				{
					if(i==k-1)
					{
						matrix[i][j]=c[k-j-1];
					}
					else if(j==index1&&i==index2)
					{
						matrix[i][j]=1;
						index1++;
						index2++;
					}
					else
					{
						matrix[i][j]=0;
					}
				}
			} 
			//print(matrix);
			int n=in.nextInt();
			long[][] result=dot(pow(matrix,n-1),vector);
			System.out.println(result[0][0]);
		}
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
					C[i][j]+=(A[i][k]*B[k][j])%mod;
					C[i][j]+=mod;
					C[i][j]%=mod;
				}
			}
		}
		return C;
	}
	public static long[][] pow(long matrix[][],int n)
	{
		long result[][]=identity(matrix.length,matrix[0].length);
		//print(result);
		while(n>0)
		{
			if(n%2==1)
			{
				result=dot(result,matrix);
			}
			matrix=dot(matrix,matrix);
			n/=2;
		}
		return result;
	}
	public static long[][] copy(long matrix[][])
	{
		long C[][]=new long[matrix.length][matrix[0].length];
		for(int i=0;i<C.length;i++)
		{
			for(int j=0;j<C[0].length;j++)
			{
				C[i][j]=matrix[i][j];
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
				if(i==j)
				{
					C[i][j]=1;
				}
				else
				{
					C[i][j]=0;
				}
			}
		}
		return C;
	}
	public static void print(long[][] result)
	{
		System.out.println();
		for(int i=0;i<result.length;i++)
		{
			for(int j=0;j<result[0].length;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
}