import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int d=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		int start=0,end=n-1,mid;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(func(ar,mid,d))
			{
				start=mid-1;
			}
			else
			{
				end=mid+1;
			}
		}
		System.out.println(start);
		
	}
	public static boolean func(int ar[],int mid,int d)
	{
		long sum=0;
		for(int i=0;i<ar.length;i++)
		{
			sum+=ar[i];
			if(i>=mid)
			{
				sum-=d;
			}
			if(sum<0)
			{
				return false;
			}		
		}
		return true;	
	}
}