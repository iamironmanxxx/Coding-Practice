import java.io.*;
import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in =new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		for(int g=in.nextInt();g>0;g--)
		{
			int n=in.nextInt();
			int m=in.nextInt();
			int ar[][]=new int[n][m];
			fill(ar,n,m);
			//pw.print(isValid(ar)+"\n");
			print(pw,ar,n,m);
		}
		pw.close();
	}
	public static void print(PrintWriter pw, int ar[][],int n,int m)
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
		int len=n;
		int c=1;
		while(len>=m)
		{
			full_fill(ar,n,m,n-len,c);
			len-=m+1;
			c=toggle(c);
		}
		partial_fill(ar,n,m,n-len,c);
	}
	public static void partial_fill(int ar[][],int n,int m,int x,int c)
	{
		int cinit=c;
		for(int a=x,b=0;a<x+m&&a<n&&b<=((m%2==1)?m/2:m/2-1);a++,b++)
		{
			int count=0;
			for(int i=b;i<=m-1-b;i++)
			{
				ar[a][i]=c;
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
			for(int i=a+1;i<n;i++)
			{
				ar[i][m-1-b]=c;
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
			c=toggle(ar[a][b]);
			count=0;
			for(int i=a+1;i<n;i++)
			{
				ar[i][b]=c;
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
			c=change(ar[a][b]);
		}
	}
	public static void full_fill(int ar[][],int n,int m,int x,int c)
	{
		int cinit=c;
		for(int a=x,b=0;a<x+m&&b<=((m%2==1)?m/2:m/2-1);a++,b++)
		{
			int count=0;
			for(int i=b;i<=m-1-b;i++)
			{
				ar[a][i]=c;
				//println(1,ar,a,i);
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
			for(int i=a+1;i<2*x+m-a-1;i++)
			{
				ar[i][m-1-b]=c;
				//println(2,ar,i,m-1-b);
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
			for(int i=m-1-b;i>=b;i--)
			{
				ar[2*x+m-a-1][i]=c;
				//println(3,ar,2*x+m-a-1,i);
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
			for(int i=2*x+m-a-2;i>a;i--)
			{
				ar[i][b]=c;
				//println(4,ar,i,b);
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
			c=change(ar[a][b]);
		}
		/*c=toggle(change(cinit));
		int count=1;
		for(int i=0;i<m;i++)
		{
			if(x+m<n)
			{
				ar[x+m][i]=c;
				count++;
				if(count==2)
				{
					count=0;
					c=toggle(c);
				}
			}
		}*/
		if(x+m<n&&x+m-2>=0)
		{
			for(int i=1;i<m-1;i++)
			{
				
					ar[x+m][i]=toggle(ar[x+m-2][i]);
			}
			ar[x+m][0]=(m>2)?(ar[x+m][1]==ar[x+m][2])?toggle(ar[x+m][1]):ar[x+m][1]:ar[x+m][1];
			ar[x+m][m-1]=(m>=3)?(ar[x+m][m-2]==ar[x+m][m-3])?toggle(ar[x+m][m-3]):ar[x+m][m-2]:ar[x+m][m-2];
		}
	}
	public static int change(int x)
	{
		if(x==1)
			return 3;
		else if(x==2)
			return 4;
		else if(x==3)
			return 1;
		return 2;
	}
	public static int toggle(int x)
	{
		if(x<3)
		{
			if(x==1)
				return 2;
			return 1;
		}
		else
		{
			if(x==3)
				return 4;
			return 3;
		}
	}
	public static void println(int n,int ar[][],int i,int j)
	{
		System.out.println(n+" ar["+i+" , "+j+" ]= "+ar[i][j]);
	}
}