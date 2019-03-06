import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n;
		long x;
		n=in.nextInt();
		x=in.nextLong();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		int start=1,end=n,mid;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(func(ar,x,n,mid))
			{
				start=mid+1;
			}
			else 
			{
				end=mid-1;
			}
		}
		System.out.println(start-1);

	}
	static boolean func(int ar[],long x,int n,int k)
	{
		long sum=0;
		for(int i=0;i<k;i++)
		{
			sum+=ar[i];
		}
		if(sum>x)
		{
			return false;
		}
		int lptr=0;
		for(int i=k;i<n;i++,lptr++)
		{
			sum+=ar[i];
			sum-=ar[lptr];
			if(sum>x)
			{
				return false;
			}
		}
		return true;
	}
}