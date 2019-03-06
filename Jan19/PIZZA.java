import java.util.*;
class PIZZA
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int test=in.nextInt();
		for(int g=0;g<test;g++)
		{
			int n=in.nextInt();
			int t=in.nextInt();
			int x=in.nextInt();
			int y=in.nextInt();
			int z=in.nextInt();
			int alpha=(2*n+1);
			if(t==1)
			{
				if(y>x)
				{
					if(z>y)
					{
						//System.out.printn("1-((x+1)/(2n+3))");
						compute(alpha-(y+1),alpha);
					}
					else
					{
						//System.out.printn("(x-1)/(2n+3)");
						compute(y-1,alpha);
					}
				}
				else
				{
					if(z>y)
					{
						//System.out.printn("(x+1)/(2n+3)");
						compute(y+1,alpha);
					}
					else
					{
						compute(alpha-(y-1),alpha);
					}
				}
			}
			else if(t==2)
			{
				compute(alpha-(2*y),alpha);
			}
			else if(t==3)
			{
				if(y>x)
				{
					if(z>y)
					{
						compute(alpha-(y-1),alpha);
					}
					else
					{
						compute(y-1,alpha);
					}
				}
				else
				{
					if(z>y)
					{
						compute(y+1,alpha);
					}
					else
					{
						compute(alpha-(y+1),alpha);
					}
				}
			}
			else
			{
				compute(alpha-(2*y),alpha);
			}
		}
	}
	public static void compute(int a,int b)
	{
		System.out.println(a+" "+b);
		int gcd=hcf(a,b);
		System.out.println((a/gcd)+" "+(b/gcd));
		//System.out.println((a/(double)b)*(22.0/7));
	}
	static int x=1;
	public static int hcf(int a,int b)
	{
		if(a==0)
		{
			x=b;
			//System.out.println(b);
		}
		else
		{
			hcf(b%a,a);
		}
		return x;
	}
}
