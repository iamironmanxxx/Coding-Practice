import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,q;
		n=in.nextInt();
		int ar[]=new int[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
			if(i!=0)
			{
				ar[i]=ar[i-1]+ar[i];
			}
		}
		q=in.nextInt();
		for(int i=0;i<q;i++){
			int x=in.nextInt();
			int start=0,end=n-1,mid=0,flag=0;
			while(end-start>=0)
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
				System.out.println(mid+1);
			}
			else
			{
				System.out.println(start+1);
			}
		}
	}
}