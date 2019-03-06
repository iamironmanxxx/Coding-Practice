import java.util.*;
import java.io.*;
import java.math.BigInteger;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner (System.in);
		BigInteger l=new BigInteger(in.next());
		BigInteger r=new BigInteger(in.next());
		long lCount=getCount(l);
		long rCount=getCount(r);
		System.out.println((rCount-lCount+2*mod)%mod);

	}
	public static long getCount(BigInteger big)
	{
		String s=big.toString(2);
		int n=s.length();
		long count=0;
		for(int i=0;i<n;i++)
		{
			char c=s.charAt(i);
			if(c-'0'==1)
			{
				count+=pow(n-1-i);
				count%=mod;
			}
		}
		count+=((2*(pow(n-1)))%mod-(n-1)+2*mod)%mod;
		return count%mod;
	}
	public static long pow(long n)
	{
		long res=1;
		long a=2;
		while(n>0)
		{
			if(n%2==1)
			{
				res=(res*a)%mod;
			}
			a=(a*a)%mod;
			n/=2;
		}
		return res;
	}
	static long mod=1000000007;
}