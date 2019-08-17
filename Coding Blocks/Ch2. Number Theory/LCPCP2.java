import java.io.*;
import java.util.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int i=1;i<=t;i++)
		{
			long a,b,m;
			a=in.nextLong();
			b=in.nextLong();
			m=in.nextLong();
			System.out.println(i+". "+pow(a,b,m));
		}
	}
	public static long pow(long a,long b,long mod)
	{
		long result=1;
		while(b>0)
		{
			if(b%2==1)
			{
				result=(result*a)%mod;
			}
			a=(a*a)%mod;
			b/=2;
		}
		return result;
	}
}