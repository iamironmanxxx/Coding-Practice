import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			long maxCount=0;
			long n=in.nextInt();
			long p=in.nextInt();
			long i=(n==1||n==2)?1:(long)(Math.ceil(n/2.0));
			if(n>2)
				maxCount=(p-i+1)*(p-i+1)+(p-n)*(p-i+1)+(p-n)*(p-n);
			else
			{
					maxCount=(p*p*p);
			}
			System.out.println(maxCount);
		}
	}
}