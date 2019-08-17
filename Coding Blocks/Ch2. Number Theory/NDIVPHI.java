import java.util.*;
import java.io.*;
import java.math.BigInteger;
class Abc
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		ArrayList<Integer> primes=getPrimes();
		//getLimit(primes);
		/*for(int i=0;i<=38;i++)
		{
			System.out.print(primes.get(i)+" ");
		}*/
		//System.out.println();
		int t=20;
		while(t-->0)
		{
			String s=in.next();
			BigInteger n=new BigInteger(s);
			int i=0;
			BigInteger x=BigInteger.valueOf(primes.get(0));
			while(x.compareTo(n)<=0)
			{
				i++;
				if(i>39)
					break;
				x=x.multiply(BigInteger.valueOf(primes.get(i)));
			}
			x=x.divide(BigInteger.valueOf(primes.get(i)));
			System.out.println(x.toString());
		}
	}
	public static ArrayList<Integer> getPrimes()
	{
		ArrayList<Integer> primes=new ArrayList<>();
		int limit=1000;
		byte f[]=new byte[limit];
		for(int i=2;i<limit;i+=2)
		{
			f[i]=(byte)1;
		}
		for(int i=3;i<limit;i+=2)
		{
			if(f[i]==(byte)0)
			{
				for(int j=i*i;j>0&&j<limit;j+=2*i)
				{
					f[j]=(byte)1;
				}
			}
		}
		primes.add(2);
		for(int i=3;i<limit;i+=2)
		{
			if(f[i]==0)
				primes.add(i);
		}
		return primes;
	}
}