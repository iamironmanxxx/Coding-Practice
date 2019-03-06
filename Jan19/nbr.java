import java.util.*;
import java.io.*;
class NBR
{
	static PrintWriter pw;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		pw=new PrintWriter(System.out);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int n=in.nextInt();
			int m=in.nextInt();
			if(n==1&&m==1)
			{
				pw.print("1\n1\n");
			}
			else if(n==2&&m==1)
			{
				pw.print("1\n1\n1\n");
			}
			else if(n==1&&m==2)
			{
				pw.print("1\n1 1\n");
			}
			else if(n==2&&m==2)
			{
				pw.print("2\n1 1\n2 2\n");
			}
			else if(n==2||m==2)
			{
				pw.print("3\n");
				int ar[][]=new int [n][m];
				fill2(ar,n,m);
				print(ar,n,m);
			}
			else
			{
				if(n!=1&&m!=1)
					pw.print("4\n");
				else
				{
					pw.print("2\n");
				}
				if(m>n)
				{
					int ar[][]=new int [n][m];
					fill(ar,n,m);
					print (ar,n,m);
				}
				else
				{
					int ar[][]=new int[m][n];
					fill(ar,m,n);
					printT(ar,m,n);
				}
			}
		}
		pw.close();
	}
	public static void fill2(int ar[][],int n,int m)
	{
		int c=1;
		for(int i=0;i<((n==2)?m:n);i++)
		{
			for(int j=0;j<2;j++)
			{
				if(n>m)
					ar[i][j]=c;
				else
				{
					ar[j][i]=c;
				}
			}
			c=toggle2(c);
		}
	}
	public static int toggle2(int c)
	{
		if(c==1)
		{
			return 2;
		}
		else if(c==2)
		{
			return 3;
		}
		return 1;
	}
	public static void printT(int ar[][],int n,int m)
	{
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				pw.print(ar[j][i]+" ");
			}
			pw.print("\n");
		}
	}
	public static void print(int ar[][],int n,int m)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				pw.print(ar[i][j]+" ");
			}
			pw.print("\n");
		}
	}
	public static void fill(int ar[][],int n,int m)
	{
		for(int i=0;i<n;i+=2)
		{
			int count=0;
			int c=(i%4==0)?1:2;
			for(int j=0;j<m;j++)
			{
				ar[i][j]=c;
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
		}
		for(int i=1;i<n;i+=2)
		{
			int count=0;
			int c=((i-1)%4==0)?3:4;
			for(int j=0;j<m;j++)
			{
				ar[i][j]=c;
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
		}
	}
	public static int toggle(int a)
	{
		if(a==1)
			return 2;
		else if(a==2)
			return 1;
		else if(a==3)
			return 4;
		return 3;
	}
}
