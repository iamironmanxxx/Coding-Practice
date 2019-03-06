import java.util.*;
class Abc
{
	static String names[]={"BOB","ALICE"};
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=0;i<t;i++)
		{
			int n,a,b;
			n=in.nextInt();
			a=in.nextInt();
			b=in.nextInt();
			int aCount=0,bCount=0,cCount=0;
			for(int j=0;j<n;j++)
			{
				int x=in.nextInt();
				if(x%a==0)
				{
					aCount++;
				}
				if(x%b==0)
				{
					bCount++;
				}
				if(x%a==0&&x%b==0)
				{
					cCount++;
				}
			}
			if(aCount==0&&bCount==0)
			{
				System.out.println(names[1]);
			}
			else if(a==b)
			{
				System.out.println(names[0]);
			}
			else if(a%b==0)
			{
				if(aCount==bCount)
				{
					System.out.println(names[0]);
				}
				else
				{
					System.out.println(names[1]);
				}
			}
			else if(b%a==0)
			{
				System.out.println(names[0]);
			}
			else
			{
				disjoint(aCount,bCount,cCount,0);
			}
			
		}
	}
	public static void disjoint(int aCount,int bCount,int cCount,int first)
	{
		aCount-=cCount;
		bCount-=cCount;
		if(aCount>bCount)
		{
			System.out.println(names[0]);
		}
		else if(bCount>aCount)
		{
			System.out.println(names[1]);
		}
		else if(cCount!=0)
		{
			System.out.println(names[0]);
		}
		else
		{
			System.out.println(names[1]);
		}
	}
}