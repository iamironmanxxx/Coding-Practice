import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			ar[i]=in.nextInt();
		}
		for(int i=1;i<n;i++)
		{
			ar[i]=ar[i-1]+ar[i];
		}
		int q=in.nextInt();
		for(int i=0;i<q;i++)
		{
			int x=in.nextInt();
			int start=0,end=n-1,mid=0,flag=0;
			while(start<=end)
			{
				mid=(start+end)/2;
				if(ar[mid]==x)
				{
					flag=1;
					break;
				}
				else if(ar[mid]>x)
				{
					end=mid-1;
				}
				else
				{
					start=mid+1;
				}
			}
			if(flag==1)
			{
				System.out.println(((n-mid)%2==1)?"A":"B");
			}
			else
			{
				System.out.println(((n-start)%2==1)?"A":"B");
			}
		}
	}
}