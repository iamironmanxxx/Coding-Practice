import java.util.*;
class Abc
{
	static int n,k;
	static int ar[];
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		int q=in.nextInt();
		ar=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		for(int i=0;i<q;i++)
		{
			k=in.nextInt();
			int start=1,end=n,mid;
			while(end-start>0)
			{
				mid=(start+end)/2;
				if(verify(mid))
				{
					end=mid;
				}
				else
				{
					start=mid+1;
				}
			}
			if(start<n)
			{
				System.out.println(start);
			}
			else
			{
				System.out.println(-1);
			}
		}

	}
	static boolean verify(int size)
	{
		long sum=0;
		for(int i=0;i<size;i++)
		{
			sum+=Integer.bitCount(ar[i]);
		}
		long max=sum;
		int lptr=0,rptr=size-1;
		while(rptr<n)
		{
			sum+=Integer.bitCount(ar[rptr]);
			sum-=Integer.bitCount(ar[lptr]);
			if(sum>max)
			{
				max=sum;
			}
			rptr++;
			lptr++;
		}
		if(max>=k)
		{
			return true;
		}
		return false;
	}
}