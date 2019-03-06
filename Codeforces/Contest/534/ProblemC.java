import java.util.*;
public class Abc
{
	static int count=1;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		String s=in.next();
		int ar[][]=new int[4][4];
		//System.out.println(s.length());
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			int initCount=count;
			if(c=='0')
			{
				addVer(ar);
			}
			else
			{
				addHor(ar);
			}
			erase(ar);
		}
		//System.out.println(count);
	}
	public static void print(int ar[][])
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void addVer(int ar[][])
	{
		Outer: for(int i=0;i<1;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(ar[i][j]==0&&ar[i+1][j]==0)
				{
					System.out.println(i+1+" "+(j+1));
					ar[i][j]=count;
					ar[i+1][j]=count;
					count++;
					if(count==0)
					{
						count++;
					}
					break Outer;
				}
			}
		}
	}
	public static void addHor(int ar[][])
	{
		Outer: for(int i=2;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(ar[i][j]==0&&ar[i][j+1]==0)
				{
					System.out.println(i+1+" "+(j+1));
					ar[i][j]=count;
					ar[i][j+1]=count;
					count++;
					break Outer;
				}
			}
		}
	}
	public static void erase(int ar[][])
	{
		int row[]=new int[4];
		int col[]=new int[4];
		for(int i=0;i<4;i++)
		{
			int hCount=0,vCount=0;
			for(int j=0;j<4;j++)
			{
				if(ar[i][j]!=0)
				{
					hCount++;
				}
				if(ar[j][i]!=0)
				{
					vCount++;
				}
			}
			if(vCount==4)
			{
				col[i]=1;
			}
			if(hCount==4)
			{
				row[i]=1;
			}
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(row[i]==1)
				{
					ar[i][j]=0;
				}
				if(col[i]==1)
				{
					ar[j][i]=0;
				}
			}
		}
	}
}