import java.util.*;
public class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n,m;
		n=in.nextInt();
		m=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		if(n>=m)
		{
			System.out.println("YES");
			return;
		}
		int can[][]=new int[n+1][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(can[i][j]==1)
				{
					can[i+1][(ar[i]+j)%m]=1;	
					can[i+1][j]=1;
				}
				if(ar[i]%m==j)
				{
					can[i][j]=1;
					can[i+1][j]=1;
				}
			}
		}
		//print(can);
		if(can[n][0]==1)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
	public static void print(int ar[][])
	{
		for(int i=0;i<ar.length;i++)
		{
			for(int j=0;j<ar[0].length;j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
}