import java.util.*;
import java.io.*;
class SEQ
{
	static PrintWriter pw;
	static Map<Integer,Integer> map=new HashMap<>();
	static int TEN=1000000000;
	public static void main(String args[])
	{
		Scanner in=new Scanner (System.in);
		int len=50000;
		int ar[]=new int[len];
		fill(ar);
		pw=new PrintWriter(System.out);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int n=in.nextInt();
			copy(ar,n);


		}
		pw.close();
	}
	public static void copy(int ar[],int n)
	{
		int cp[]=new int[n];
		int carry=ar[1]/2;
		map=new HashMap<>();
		cp[0]=2;
		for(int i=1;i<n-2;i++)
		{
			map.put(ar[i],1);
			carry=ar[i+1]/carry;
			cp[i]=ar[i];
		}
		cp[n-2]=ar[n-2]/carry;
		int pr=nextPrime(cp,n-2);
		cp[n-1]=pr;
		cp[n-2]*=pr;
		map.put(cp[n-2],1);
		pr=nextPrime(cp,n-1);
		cp[n-1]*=pr;
		cp[0]*=pr;
		print(cp);
	}
	public static boolean isValid(int ar[])
	{
		int n=ar.length;
		Map<Integer,Integer> tempMap=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			int a=i,b=(i+1)%n,c=(i+2)%n;
			if(gcd(ar[a],ar[b])==1||gcd(ar[a],gcd(ar[b],ar[c]))!=1)
			{
				//System.out.println("gcd 2 = "+gcd(ar[a],ar[b])+" gcd 3 ("+i+")="+gcd(ar[a],gcd(ar[b],ar[c])));
				return false;
			}
			if(tempMap.get(ar[i])!=null)
			{
				return false;
			}
			tempMap.put(ar[i],1);
		}
		return true;
	}
	public static int x;
	public static int gcd(int a,int b)
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
	public static void print(int ar[])
	{
		for(int i=0;i<ar.length;i++)
		{
			pw.print(ar[i]+" ");
		}
		pw.print("\n");
	}
	public static void fill(int ar[])
	{
		int n=ar.length;
		ar[0]=1;
		for(int i=0;i<n;i++)
		{
			int next=(i+1)%n;
			int pr=nextPrime(ar,i);
			ar[i]=pr*ar[i];
			ar[next]=(i==n-1)?ar[0]*pr:pr;
		}
	}
	public static int nextPrime(int ar[],int ind)
	{
		if(ind==0)
		{
			return 2;
		}
		for(int i=2;i<TEN;i++)
		{
			if(ind==ar.length-2&&i%2==0)
			{
				continue;
			}
			int prod=ar[ind]*i;
			if(ind==ar.length-1)
			{
				if(gcd(ar[ind],i)==1&&gcd(ar[0],i)==1&&gcd(ar[ind-1],i)==1&&gcd(ar[1],i)==1&&prod>0&&prod<TEN&&map.get(prod)==null&&map.get(ar[0]*i)==null)
				{
					map.put(prod,i);
					return i;
				}
			}
			else if(gcd(ar[ind],i)==1&&gcd(ar[ind-1],i)==1&&prod>0&&prod<TEN&&map.get(prod)==null)
			{
				map.put(prod,1);
				return i;
			}
		}
		return -1;
	}
}