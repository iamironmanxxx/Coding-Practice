import java.util.*;
import java.io.*;
class Abc
{
	static long mod=1000000007;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			long n,k,m;
			n=in.nextLong();
			k=in.nextLong();
			m=in.nextLong();
			if(m%2==1){
				long nPow,nMinusPow;
				nPow=pow(n,(m+2)/2);
				nMinusPow=pow(n-1,(m+2)/2);
				long num,res;
				num=((nPow-nMinusPow)+mod)%mod;
				res=((num*modInverse(nPow))%mod+mod)%mod;
				pw.print(res+"\n");
			}
			else
			{
				long nPow,nMinusPow;
				nPow=pow(n,(m)/2);
				nMinusPow=pow(n-1,m/2);
				long T1,num;
				num=((nPow-nMinusPow)+mod)%mod;
				T1=((num*modInverse(nPow))%mod+mod)%mod;
				long T2,res,denom;
				denom=((nPow*(n+k))%mod+mod)%mod;//prone to errors
				T2=((nMinusPow*modInverse(denom))%mod+mod)%mod;
				res=((T1+T2)%mod+mod)%mod;
				pw.print(res+"\n");
			}
		}
		pw.close();
	}
	static long pow(long a,long n)
	{
		long res=1;
		while(n>0)
		{
			if(n%2==1)
			{
				res=(res*a)%mod;
			}
			a=(a*a)%mod;
			n/=2;
		}
		return (res%mod);
	}
	static long x,y,gcd;
	static long extendedEuclid(long a,long b)
	{
		if(b==0)
		{
			gcd=a;
			x=1;
			y=0;
		}
		else
		{
			extendedEuclid(b,a%b);
			long temp=x;
			x=y;
			y=temp-((a/b)*y);
		}
		return gcd;
	}
	static long modInverse(long a)
	{
		extendedEuclid(a,mod);
		return (x%mod+mod)%mod;
	}
}