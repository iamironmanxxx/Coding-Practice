import java.util.*;
import java.io.*;
class Abc
{
	static int limit=100000001;
	static int f[]=new int[limit/64+1];
	static ArrayList<Integer> primes=new ArrayList<>();
	static int checkIfNotPrime(int x)
	{
		return (f[x/64]&(1<<((x>>1)&31)));
	}
	static void makeComposite(int x)
	{
		f[x/64]|=(1<<((x>>1)&31));
	}
	static void sieve()
	{
		for(int i=3;i<=Math.sqrt(limit);i+=2)
		{
			if(checkIfNotPrime(i)==0)
			{
				for(int j=i*i;j<limit;j+=2*i)
				{
					makeComposite(j);
				}
			}
		}
		primes.add(2);
		for(int i=3;i<limit;i+=2)
		{
			if(checkIfNotPrime(i)==0)
			{
				primes.add(i);
			}
		}
	}
	public static void main(String[] args) {
		sieve();
		PrintWriter pw=new PrintWriter(System.out);
		for(int i=0;i<primes.size();i+=100)
		{
			pw.println(primes.get(i));
		}
		pw.close();
	}
}