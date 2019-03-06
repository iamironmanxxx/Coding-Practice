import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,q;
		n=in.nextInt();
		q=in.nextInt();
		long ar[]=new long[n];
		long br[]=new long[n];
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			br[i]=in.nextInt();
		}
		for(int i=2;i<n;i++)
		{
			ar[i]=ar[i]+ar[i-2];
			br[i]=br[i]+br[i-2];
		}
		for(int g=0;g<q;g++)
		{
			int ch,l,r;
			ch=in.nextInt();
			l=in.nextInt();
			r=in.nextInt();
			l--;
			r--;
			int len=(r-l+1);
			long sum=0;
			if(ch==1)
			{
				if(len%2==1)
				{
					sum=ar[r];
					if(l>1)
					{
						sum-=ar[l-2];
					}
					sum+=br[r-1];
					if(l>0)
						sum-=br[l-1];
				}
				else
				{
					sum=ar[r-1];
					if(l>1)
					{
						sum-=ar[l-2];
					}
					sum+=br[r];
					if(l>0)
						sum-=br[l-1];
				}
			}
			else
			{
				if(len%2==1)
				{
					sum=br[r];
					if(l>1)
					{
						sum-=br[l-2];
					}
					sum+=ar[r-1];
					if(l>0)
					sum-=ar[l-1];
				}
				else
				{
					sum=br[r-1];
					if(l>1)
					{
						sum-=br[l-2];
					}
					sum+=ar[r];
					if(l>0)
					sum-=ar[l-1];
				}
			}
			System.out.println(sum);
		}
	}
}