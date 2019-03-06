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
			int max=1;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					int f[]=new int[5];
					for(int x=-2;x<3;x++)
					{
						for(int y=-2;y<3;y++)
						{
							int x1=i+x;
							int y1=j+y;
							if(Math.abs(x)+Math.abs(y)==2&&x1>=0&&y1>=0&&x1<n&&y1<m)
							{
								if(ar[x1][y1]!=0)
								{
									f[ar[x1][y1]]++;
								}
							}
						}
					}
					int min=0;
					for(int a=1;a<5;a++)
					{
						if(f[a]==0)
						{
							min=a;
							break;
						}
					}
					if(min>max)
					{
						max=min;
					}
					ar[i][j]=min;
					for(int x=-1;x<2;x++)
					{
						for(int y=-1;y<2;y++)
						{
							int x1=i+x;
							int y1=j+y;
							if(x1>=0&&y1>=0&&x1<n&&y1<m&&(x==0||y==0)&&!(x==y))
							{
								if(ar[x1][y1]==0&&isValidStep(ar,x1,y1,min))
								{
									ar[x1][y1]=min;
								}
							}
						}
					}
				}
			}
			pw.print(max+"\n");
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
}