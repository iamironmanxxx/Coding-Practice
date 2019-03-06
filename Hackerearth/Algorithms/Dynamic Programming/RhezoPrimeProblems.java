import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		int prime[]=new int[n+1];
		for(int i=2;i<=n;i++)
		{
			for(int j=2;j*i<=n;j++)
			{
				prime[j*i]=1;
			}
		}
		//System.out.println(Arrays.toString(prime));
		int maxPrime=0;
		for(int i=2;i<=n;i++)
		{
			if(prime[i]==0)
			{
				maxPrime=i;
			}
		}
		//System.out.println(maxPrime);
		long sum=0,maxSum=0;
		for(int i=0;i<maxPrime;i++)
		{
			sum+=ar[i];
		}
		maxSum=sum;
		int lptr=0;
		for(int i=maxPrime;i<n;i++)
		{
			sum+=ar[i];
			sum-=ar[lptr];
			lptr++;
			if(maxSum<sum)
			{
				maxSum=sum;
			}
		}
		System.out.println(maxSum);
	}
}