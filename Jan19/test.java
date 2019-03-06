import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		for(int a=2;a<=100;a++)
		{
			for(int b=a;b<=100;b++)
			{
				int maxCount=1;
				int max=n/2-1;
				int n=a;
				int p=b;
				for(int i=1;i<=p;i++)
				{
					for(int j=1;j<=p;j++)
					{
						for(int k=1;k<=p;k++)
						{
							int res=(((n%i)%j)%k)%n;
							if(res==max)
							{
								System.out.println("for n= "+a+" p= "+b+" max= "+max+" maxCount= "+maxCount);
								maxCount++;
							}
						}
					}
				}
			}
		}
	}
}