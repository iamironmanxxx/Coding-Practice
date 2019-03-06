import java.util.*;
class Bbc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		for(int g=0;g<t;g++)
		{
			int n,k;
			n=in.nextInt();
			k=in.nextInt();
			int ar[]=new int[n];
			int i;
			for(i=0;i<n;i++)
			{
				ar[i]=in.nextInt();
			}
			//int prev=0;
			for(i=0;i<n;i++)
			{
				/*if(func(ar,i,k))
				{
					break;
				}*/
				func(ar,i,k);
			}
			//System.out.println(i+1);

		}
	}
	public static boolean func (int ar[],int p,int k)
	{
		//System.out.println("p= "+p);
		int n=ar.length;
		long sum=0;
		for(int i=p;i<n;i++)
		{
			sum+=ar[i]/(i-p+1);
		}
		System.out.println(sum);
		if(sum<=k)
			return true;
		return false;
	}
}