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
			int count=0;
			flag=0;
			fill(ar,0,0,n,m,0);
			pw.print(isValid(ar)+"\n");
			print(pw,ar,n,m);
		}
		pw.close();
	}
	static class Node
	{
		int x,y;
		Node(int a,int b)
		{
			x=a;
			y=b;
		}
	}
	static int flag=0;
	public static void fill(int ar[][],int i,int j,int n,int m,int count)
	{
		int c=0;
		while(nextAvailable(ar,i,j,c)!=-1)
		{
			
			//add least no. available at (i,j)
			ar[i][j]=nextAvailable(ar,i,j,c);
			c++;

			//System.out.println("ar["+i+","+j+"] ="+ar[i][j]+" count= "+ count);

			if(count==n*m-1)
			{
				flag=1;
				break;
			}

			int i1=(count+1)/m;
			int j1=(count+1)%m;
			if(i1>=0&&j1>=0&&i1<n&&j1<m)
			{
				fill(ar,i1,j1,n,m,count+1);
				if(flag==0)
				{
					ar[i][j]=0;
				}
				else 
				{
					break;
				}
			}

		}
	}
	public static int nextAvailable(int ar[][],int i ,int j,int pos)
	{
		int f[]=new int [5];
		for(int x=-2;x<3;x++)
		{
			for(int y=-2;y<3;y++)
			{
				int x1=x+i;
				int y1=y+j;
				if(Math.abs(x)+Math.abs(y)==2&&x1>=0&&y1>=0&&y1<ar[0].length&&x1<ar.length)
				{
					if(ar[x1][y1]!=0)
					{
						f[ar[x1][y1]]++;
					}
				}
			}
		}
		int c=0;
		for(int a=1;a<5;a++)
		{
			if(f[a]==0)
			{
				if(c==pos)
				{
					return a;
				}
				c++;
			}
		}
		return -1;
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
	public static boolean isValidStep(int ar[][],int i,int j,int a)
	{
		for(int x=-2;x<3;x++)
		{
			for(int y=-2;y<3;y++)
			{
				if(Math.abs(x)+Math.abs(y)==2)
				{
					int x1=i+x;
					int y1=j+y;
					if(x1>=0&&y1>=0&&x1<ar.length&&y1<ar[0].length&&ar[x1][y1]==a)
						return false;
				}
			}
		}
		return true;
	}
	public static boolean isValid(int ar[][])
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				int f[]=new int[10];
				for(int x=-1;x<2;x++)
				{
					for(int y=-1;y<2;y++)
					{
						int x1=i+x;
						int y1=j+y;
						if((x==0||y==0)&&!(x1==i&&y1==j)&&(x1>=0&&y1>=0&&x1<ar.length&&y1<ar[0].length))
						{
							if(ar[x1][y1]==0)
							{
								//System.out.println(x1+" "+y1);
								return false;
							}
							if(f[ar[x1][y1]]==0)
							{
								f[ar[x1][y1]]++;
							}
							else
							{
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}