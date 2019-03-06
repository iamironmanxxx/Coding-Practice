import java.util.*;
import java.io.*;
class Sequence
{
	static int count=0;
	static int TEN=1000000000;
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		int prime[]=getPrimes();
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int n=in.nextInt();
			int ar[]=new int[n];
			for(int i=0;i<n;i++)
			{
				ar[i]=1;
			}
			int c=1;
			for(int i=0,j=0;j<count&&i<n;j+=c,i++)
			{
				if(ar[i]*prime[j]<=0||ar[i]*prime[j]>TEN)
				{
					if(i<n-2)
					{
						j=0;
					}
					else
					{
						j=2;
					}
					c++;
				}
				ar[i]*=(prime[j]);
				ar[(i+1)%n]*=prime[j];
			}
			pw.print(isValid(ar)+"\n");
		}
		pw.close();
	}
	static int x=0;
	static int gcd(int a,int b)
	{
		if(a==0)
		{
			x=b;
		}
		else	
		{
			gcd(b%a,a);
		}
		return x;
	}
	public static boolean isValid(int ar[])
	{
		int n=ar.length;
		for(int i=0;i<n;i++)
		{
			int a=i,b=(i+1)%n,c=(i+2)%n;
			if(gcd(ar[a],ar[b])==1||gcd(ar[a],gcd(ar[b],ar[c]))!=1)
			{
				System.out.println(i+" gcd2="+gcd(ar[a],ar[b])+" gcd3="+gcd(ar[a],gcd(ar[b],ar[c])));
				return false;
			}
		}
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<ar.length;i++)
		{
			if(map.get(ar[i])!=null)
			{
				return false;
			}
			else
			{
				map.put(ar[i],1);
			}
		}
		return true;
	}
	public static int[] getPrimes()
	{
		int ar[]=new int[100000000];
		for(int i=2;i<ar.length;i++)
		{
			if(ar[i]==0)
			{
				for(int k=2;k*i<ar.length;k++)
				{
					ar[k*i]=1;
				}
			}
		}
		count=0;
		int prime[]=new int[7000000];
		for(int i=2;i<ar.length;i++)
		{
			if(ar[i]==0)
			{
				prime[count++]=i;
			}
		}
		return prime;
	}
}