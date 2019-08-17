import java.util.*;
import java.io.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		long n=in.nextLong();
		long p1=186583;
		long p2=587117;
		long ans_x1=1,ans_x2=1,current_fact1=1,current_fact2=1;
		for(int i=2;i<=n;i++)
		{
			current_fact2*=i;
			current_fact2%=p2;
			current_fact1*=i;
			current_fact1*=p1;
			ans_x2*=current_fact2;
			ans_x2%=p2;
			ans_x1*=current_fact1;
			ans_x1%=p1;
		}
		long inv1,inv2;
		inv1=pow(p2,p1-2,p1);
		inv2=pow(p1,p2-2,p2);
		long mod=p1*p2;
		long x=(((ans_x1*inv1)%mod)*(p2%mod))%mod+(((ans_x2*inv2)%mod)*p1%mod)%mod;
		x%=mod;
		System.out.println(x);
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