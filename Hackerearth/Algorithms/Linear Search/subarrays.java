import java.util.*;
class Abc
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int ar[]=new int[n];
		int k=0;
		long max_so_far=0;
		long sum=0;
		for(int i=0;i<n;i++)
		{
			ar[i]=in.nextInt();
		}
		
		for(int i=0;i<n;i++)
		{
			sum+=ar[i];
			if(sum<0)
			{
			    sum=0;
			}
			if(sum>max_so_far)
			{
			    max_so_far=sum;
			}
		}
		sum=0;
		for(int i=0;i<n;i++)
		{
		    sum+=ar[i];
		    if(sum<0)
		    {
		        sum=0;
		    }
		    else if(sum==max_so_far)
		    {
		        k++;
		    }
		}
		System.out.println((max_so_far)+" "+k);
	}
}