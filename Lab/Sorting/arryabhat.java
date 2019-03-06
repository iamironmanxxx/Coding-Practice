import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		long n,q;
		n=in.nextLong();
		q=in.nextLong();
		long ar[]=new long[(int)q];
		for(int i=0;i<q;i++)
		{
			ar[i]=in.nextLong();
		}
		Arrays.sort(ar);
		int count=0;
		for(int i=0;i<q;i++)
		{
			if(n>0&&n>=ar[i])
			{
				count++;
				n=n-ar[i];
			}
			else
			{
				break;
			}
		}
		System.out.println(count);
	}
}