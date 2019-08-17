import java.util.*;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0)
		{
			long n,p;
			n=in.nextLong();
			p=in.nextLong();
			long fact=p-1;
			if(n>=p)
			{
				for(long i=p;i<=n;i++)
				{
					fact=((fact%p)*(i%p))%p;
				}
			}
			else
			{
				for(long i=p-1;i>n;i--)
				{
					fact=(fact*pow(i,p-2,p))%p;
				}
			}
			System.out.println(fact);
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