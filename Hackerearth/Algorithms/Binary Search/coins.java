import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		long f[]=new long[100001];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			f[ar[i]]++;
		}
		int start=0,end=100000,mid=0,flag=0;
		while(start<=end)
		{
			mid=(start+end)/2;
			if(check(f,mid)==0)
			{	
				flag=1;
				break;
			}
			else if(check(f,mid)>0)
			{
				end=mid-1;
			}
			else
			{
				start=mid+1;
			}
		}
		if(flag==1&&f[ar[0]]!=n)
		{
			System.out.println("YES");
		}
		else if(f[ar[0]]==n)
		{
		    System.out.println("NO");
		}
		else
		{
			System.out.println("NO");
		}
	}
	public static long check(long f[],int mid)
	{
		long left=0,right=0;
		for(long i=0;i<mid;i++)
		{
			left+=i*f[(int)i];
		}
		for(long i=mid+1;i<100001;i++)
		{
			right+=i*f[(int)i];
		}
		return left-right;
	}
}