import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int x=in.nextInt();
			int a,b,c;
			a=in.nextInt();
			b=in.nextInt();
			c=in.nextInt();
			int count=0;
			Outer : for(int i=-1;i<=1;i+=2)
			{
				for(int j=-1;j<=1;j+=2)
				{
					for(int k=-1;k<=1;k+=2)
					{
						int sum=i*a+j*b+k*c;
						if(sum==x)
						{
							count=1;
							System.out.println("WIN");
							break Outer;
						}
					}
				}
			}
			if(count==0)
			{
				System.out.println("LOSE");
			}
		}
	}
}